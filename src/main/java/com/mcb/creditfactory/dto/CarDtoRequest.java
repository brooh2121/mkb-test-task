package com.mcb.creditfactory.dto;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("car")
public class CarDtoRequest implements Collateral{
    private Long id;
    private String brand;
    private String model;
    private Double power;
    private Short year;
}
