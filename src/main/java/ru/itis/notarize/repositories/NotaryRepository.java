package ru.itis.notarize.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.notarize.models.Notary;

@Repository
public interface NotaryRepository extends JpaRepository<Notary, Long> {

}
