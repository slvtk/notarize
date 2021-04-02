package ru.itis.notarize.security.jwt;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Slf4j
@NoArgsConstructor
public class JwtTokenVerifierFilter extends OncePerRequestFilter {
    @Value("${yaml.tokenKey}")
    private String TOKEN_KEY;

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse resp,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = req.getHeader("Authorization");
        if (Strings.isNullOrEmpty(authHeader) || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(req, resp);
            return;
        }
        String token = req.getHeader("Authorization").replace("Bearer ", "");
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(TOKEN_KEY.getBytes())).build()
                    .parseClaimsJws(token).getBody();

            String username = claims.getSubject();

            String role = ((ArrayList<String>) claims.get("authorities")).stream().findFirst().orElse(null);

            List<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(role));
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    simpleGrantedAuthorities
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (JwtException e) {
            throw new IllegalStateException("Incorrect token");
        }
        filterChain.doFilter(req, resp);
    }
}
