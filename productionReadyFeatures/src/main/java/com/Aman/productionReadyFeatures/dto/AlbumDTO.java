package com.Aman.productionReadyFeatures.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class AlbumDTO {

    private Long userId;

    private Long id;

    private String title;
}
