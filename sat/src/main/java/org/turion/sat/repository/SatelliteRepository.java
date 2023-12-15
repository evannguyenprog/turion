package org.turion.sat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.turion.sat.model.Satellite;

import java.util.List;

@Repository
public interface SatelliteRepository extends CrudRepository<Satellite, Long> {

//    // Spring Data JPA query method
//    List<Satellite> findAllByImagePathAndId(String imagePath, Long id);

    // Custom native query using @Query annotation
    @Query(value = "SELECT image_path FROM satellite WHERE id = :id", nativeQuery = true)
    List<String> findAllImagesById(@Param("id") Long id);
}

