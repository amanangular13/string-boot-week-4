package com.Aman.productionReadyFeatures.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDTO {

    private Long id;

    private String title;

    private String description;
}
