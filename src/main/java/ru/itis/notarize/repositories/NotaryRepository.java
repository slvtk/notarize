package ru.itis.notarize.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.notarize.models.Notary;

public interface NotaryRepository extends JpaRepository<Notary, Long> {

}
