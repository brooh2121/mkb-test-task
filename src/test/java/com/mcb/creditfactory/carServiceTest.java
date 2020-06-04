package com.mcb.creditfactory;


import com.mcb.creditfactory.model.Assessment;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.repository.CarRepository;
import com.mcb.creditfactory.service.car.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.beans.Expression;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@RunWith(JUnit4.class)
@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan("com.mcb.creditfactory.repository")
public class carServiceTest {

    @Autowired
    CarRepository carRepository;

    @Test
    public void DummyTest () {
        Assessment assessment = new Assessment();
        assessment.setAssessment_id(1l);
        assessment.setValue(new BigDecimal(150000));
        assessment.setAssessmentDate(new Timestamp(System.currentTimeMillis()));
        List<Assessment> assessments = new ArrayList<>();
        assessments.add(assessment);
        Car car = new Car();
        car.setId(1l);
        car.setBrand("testBrand");
        car.setModel("testModel");
        car.setPower(5000d);
        car.setYear(Short.parseShort("2008"));
        car.setAssessments(assessments);
        carRepository.save(car);
        //carService.save(car);
    }
}
