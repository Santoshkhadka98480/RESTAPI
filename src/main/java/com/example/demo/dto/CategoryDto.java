package com.example.demo.dto;


import lombok.*;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDto {
    private Integer id;
    private String name;
    private String description;

}
