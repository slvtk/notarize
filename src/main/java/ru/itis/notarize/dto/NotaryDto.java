package ru.itis.notarize.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotaryDto extends UserDto {
    private String fullName;
    private String city;
    private String companyName;
    private String description;

    public NotaryDto(String username,
                     String password,
                     String fullName,
                     String city,
                     String companyName,
                     String description) {
        super(username, password);
        this.fullName = fullName;
        this.city = city;
        this.companyName = companyName;
        this.description = description;
    }
}
