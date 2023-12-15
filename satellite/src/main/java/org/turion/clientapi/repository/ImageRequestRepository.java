package org.turion.clientapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.turion.clientapi.model.ImageRequest;

import java.util.List;

@Repository
public interface ImageRequestRepository  extends CrudRepository<ImageRequest, Long> {

    // Custom native query using @Query annotation
    @Query(value = "SELECT * FROM image_request WHERE satellite_id = :id", nativeQuery = true)
    List<String> findAllImageRequestsBySatelliteId(@Param("id") Long id);
}

