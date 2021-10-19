package com.example.elasticsearchservice.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindByDto {

    @NotBlank
    private String query;
}
