package ru.itis.notarize.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDto extends SignUpDto {
    private String fullName;
    private String city;
    private Integer age;

    public ClientDto(String username,
                     String password,
                     String role,
                     String fullName,
                     String city,
                     Integer age) {
        super(username, password, role);
        this.fullName = fullName;
        this.city = city;
        this.age = age;
    }
}
