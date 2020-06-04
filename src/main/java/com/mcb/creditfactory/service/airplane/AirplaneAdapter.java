package com.mcb.creditfactory.service.airplane;


import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Assessment;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {

    private AirPlaneDto airPlaneDto;


    @Override
    public BigDecimal getValue() {
        BigDecimal value = null;
        List<Assessment> assessments = new ArrayList<>();
        List<Assessment> listFromOpt = Optional.ofNullable(airPlaneDto.getAssessments()).orElseGet(Collections::emptyList).stream().filter(Objects::isNull).collect(Collectors.toList());
        if(listFromOpt.size() == 0) {
            assessments = airPlaneDto.getAssessments();
            Collections.sort(assessments);
             value = assessments.get(assessments.size() - 1).getValue();
            return value;
        }else {
            return value;
        }
        //airPlaneDto.getAssessments().stream().forEach(assessment -> values.add(assessment.getValue()));

    }


    @Override
    public Short getYear() {
        return airPlaneDto.getYearOfIssue();
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
