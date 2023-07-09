package com.example.automapperproject.Dto;

import com.example.automapperproject.Entity.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
public class ProductResponseDto {
    private Integer id;

    private String productName;

    private String categoryName;
}
