package org.turion.clientapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("imagePath")
    private String imagePath;

    @JsonProperty("satelliteId")
    private Long satelliteId;

    @JsonProperty("imageRequestId")
    private Long imageRequestId;

}
