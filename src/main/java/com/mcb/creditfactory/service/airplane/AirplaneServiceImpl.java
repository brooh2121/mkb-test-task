package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.repository.AirPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirPlaneService {

    @Autowired
    private AirPlaneRepository airPlaneRepository;

    @Autowired
    private ExternalApproveService approveService;

    @Override
    public boolean approve(AirPlaneDto dto) {
        return approveService.approve(new AirplaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airPlaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airPlaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirPlaneDto dto) {
        return new Airplane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getManufacturer(),
                dto.getYearOfIssue(),
                dto.getFuelCapacity(),
                dto.getSeats(),
                dto.getAssessments()
                );
    }

    @Override
    public AirPlaneDto toDTO(Airplane airplane) {
        return new AirPlaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getYearOfIssue(),
                airplane.getFuelCapacity(),
                airplane.getSeats(),
                airplane.getAssessments()
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }
}
