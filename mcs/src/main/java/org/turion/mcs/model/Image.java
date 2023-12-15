package org.turion.mcs.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

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

//    @Enumerated(EnumType.STRING)
//    @Column(name = "status", nullable = false)
//    private StatusEnum status;

    public Long getImageRequestId() {
        return this.imageRequestId;
    }

}
