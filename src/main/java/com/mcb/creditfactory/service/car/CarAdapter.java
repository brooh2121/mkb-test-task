package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Assessment;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {
    private CarDto car;


    @Override
    public BigDecimal getValue() {
        BigDecimal value = null;
        List<Assessment> assessments = new ArrayList<>();
        List<Assessment> listFromOpt = Optional.ofNullable(car.getAssessments()).orElseGet(Collections::emptyList).stream().filter(Objects::isNull).collect(Collectors.toList());
        if(listFromOpt.size() == 0) {
            assessments = car.getAssessments();
            Collections.sort(assessments);
            value = assessments.get(assessments.size() - 1).getValue();
            return value;
        }else {
            return value;
        }
    }


    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        // Для автомобилей дата оценки не используется, поэтому всегда берем текущую
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}
