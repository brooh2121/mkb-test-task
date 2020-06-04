package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASSESSMENT")
public class Assessment implements Comparable<Assessment>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private Long assessment_id;
    @Column(name = "assessed_value")
    private BigDecimal value;
    @Column(name = "assessment_date")
    private Timestamp assessmentDate;

    @Override
    public int compareTo(Assessment o) {
        return getAssessmentDate().compareTo(o.getAssessmentDate());
    }
}
