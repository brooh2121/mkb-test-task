package com.mcb.creditfactory.external;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface CollateralObject {
    BigDecimal getValue();
    Short getYear();
    LocalDate getDate();
    CollateralType getType();
}
