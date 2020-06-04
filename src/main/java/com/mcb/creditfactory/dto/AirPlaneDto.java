package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.model.Assessment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirPlaneDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Short yearOfIssue;
    private Long fuelCapacity;
    private Long seats;
    private List<Assessment> assessments;
    //private BigDecimal value;
}
