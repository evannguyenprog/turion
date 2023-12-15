package org.turion.mcs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.turion.mcs.model.Image;
import org.turion.mcs.model.ImageRequest;
import org.turion.mcs.model.StatusEnum;

import java.util.List;

@Repository
public interface ImageRepository  extends CrudRepository<Image, Long> {


//    List<ImageRequest> findAllByStatus(StatusEnum status);

    @Query(value = "SELECT image_path FROM image_request WHERE image_path = :id", nativeQuery = true)
    ImageRequest findByImagePath(String imagePath);
}

