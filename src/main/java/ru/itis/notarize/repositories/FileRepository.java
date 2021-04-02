package ru.itis.notarize.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.notarize.models.File;

public interface FileRepository extends JpaRepository<File, Long> {
}
