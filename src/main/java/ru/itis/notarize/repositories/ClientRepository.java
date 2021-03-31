package ru.itis.notarize.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.notarize.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
