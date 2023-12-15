package org.turion.clientapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.turion.clientapi.model.Image;

import java.util.List;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

    @Query(value = "SELECT * FROM image WHERE id = :id", nativeQuery = true)
    List<Image> findAllImagesById(Long id);
}

