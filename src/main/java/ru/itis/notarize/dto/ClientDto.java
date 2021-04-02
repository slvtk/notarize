package ru.itis.notarize.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDto extends UserDto {
    private String fullName;
    private String city;
    private Integer age;

    public ClientDto(String username,
                     String password,
                     String fullName,
                     String city,
                     Integer age) {
        super(username, password);
        this.fullName = fullName;
        this.city = city;
        this.age = age;
    }
}
