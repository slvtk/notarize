package ru.itis.notarize.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Notary extends User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String fullName;
    private String city;
    private String companyName;
    private String description;

    public Notary(String username,
                  String password,
                  Role role,
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
