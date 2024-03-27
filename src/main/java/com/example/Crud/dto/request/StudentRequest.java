package com.example.Crud.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalIdCache;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String name;
    private Long number;
    private String city;
}
