package ru.edjll.android.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edjll.android.web.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
