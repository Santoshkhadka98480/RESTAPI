package com.example.demo.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private Boolean status;
    private String message;
    private Object data;
}
