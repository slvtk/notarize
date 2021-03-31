package ru.itis.notarize.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotaryDto extends SignUpDto {
    private String fullName;
    private String city;
    private String companyName;
    private String description;

    public NotaryDto(String username,
                     String password,
                     String role,
                     String fullName,
                     String city,
                     String companyName,
                     String description) {
        super(username, password, role);
        this.fullName = fullName;
        this.city = city;
        this.companyName = companyName;
        this.description = description;
    }
}
