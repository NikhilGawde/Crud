package com.example.Crud.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private Integer id;
    private String name;
    private Long number;
    private String city;

}
