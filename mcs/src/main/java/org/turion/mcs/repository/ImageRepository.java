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

}

