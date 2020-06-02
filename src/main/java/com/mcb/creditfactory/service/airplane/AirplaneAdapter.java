package com.mcb.creditfactory.service.airplane;


import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {

    private AirPlaneDto airPlaneDto;


    @Override
    public BigDecimal getValue() {
        return airPlaneDto.getValue();
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
