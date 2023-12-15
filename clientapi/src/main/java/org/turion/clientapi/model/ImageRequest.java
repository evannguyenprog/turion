package org.turion.clientapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ImageRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @JsonProperty("status")
    private StatusEnum status;

    @JsonProperty("satelliteId")
    private Long satelliteId;

}
