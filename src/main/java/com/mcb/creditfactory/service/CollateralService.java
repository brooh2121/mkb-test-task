package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.airplane.AirPlaneService;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: reimplement this
@Service
public class CollateralService {
    @Autowired
    private CarService carService;

    @Autowired
    private AirPlaneService airPlaneService;
/*
    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        if (!(object instanceof CarDto)) {
            throw new IllegalArgumentException();
        }

        CarDto car = (CarDto) object;
        boolean approved = carService.approve(car);
        if (!approved) {
            return null;
        }

        return Optional.of(car)
                .map(carService::fromDto)
                .map(carService::save)
                .map(carService::getId)
                .orElse(null);
    }
*/
/*
    public Collateral getInfo(Collateral object) {
        if (!(object instanceof CarDto)) {
            throw new IllegalArgumentException();
        }

        return Optional.of((CarDto) object)
                .map(carService::fromDto)
                .map(carService::getId)
                .flatMap(carService::load)
                .map(carService::toDTO)
                .orElse(null);
    }
*/
    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        if(object instanceof CarDto) {
            CarDto car = (CarDto) object;
            boolean approved = carService.approve(car);
            if (!approved) {
                return null;
            }

            return Optional.of(car)
                    .map(carService::fromDto)
                    .map(carService::save)
                    .map(carService::getId)
                    .orElse(null);
        }else if (object instanceof AirPlaneDto) {
            AirPlaneDto airplane = (AirPlaneDto) object;
            boolean approved = airPlaneService.approve(airplane);
            if(!approved) {
                return null;
            }
            return Optional.of(airplane)
                    .map(airPlaneService::fromDto)
                    .map(airPlaneService::save)
                    .map(airPlaneService::getId)
                    .orElse(null);
        }else {
            throw new IllegalArgumentException();
        }
    }

    public Collateral getInfo(Collateral object) {
        if (object instanceof CarDto) {
            return Optional.of((CarDto) object)
                    .map(carService::fromDto)
                    .map(carService::getId)
                    .flatMap(carService::load)
                    .map(carService::toDTO)
                    .orElse(null);
        }else if (object instanceof AirPlaneDto) {
            return Optional.of((AirPlaneDto) object)
                    .map(airPlaneService::fromDto)
                    .map(airPlaneService::getId)
                    .flatMap(airPlaneService::load)
                    .map(airPlaneService::toDTO)
                    .orElse(null);
        }else {
            throw new IllegalArgumentException();
        }


    }

}
