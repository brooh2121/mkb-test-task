package com.mcb.creditfactory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;

    @Column(name = "year_of_issue")
    private Short yearOfIssue;

    @Column(name = "fuelcapacity")
    private Long fuelCapacity;
    private Long seats;

    @OneToMany(targetEntity = Assessment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "id",referencedColumnName = "id")
    private List<Assessment> assessments;

    /*
    @Column(name = "assessed_value")
    private BigDecimal value;
     */
}
