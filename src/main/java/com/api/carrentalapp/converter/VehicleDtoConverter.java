package com.api.carrentalapp.converter;

import com.api.carrentalapp.request.VehicleRequest;
import com.api.carrentalapp.dto.VehicleDto;
import com.api.carrentalapp.model.User;
import com.api.carrentalapp.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleDtoConverter {

    //Fromlanan yeni oluşturulan dto'nun değeri olarak ata.
    public VehicleDto convert(Vehicle from) {
        return new VehicleDto(from.getId(),
                from.getBrand(),
                from.getModel(),
                from.getCreationDate(),
                from.getUser());
    }

    public Vehicle convert(VehicleRequest request, User user) {

        Vehicle vehicle = new Vehicle();

        vehicle.setUser(user);
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setCreationDate(request.getCreationDate());
        vehicle.setRegistrationDate(request.getRegistrationDate());
        vehicle.setChassisNumber(request.getChassisNumber());
        vehicle.setMileage(request.getMileage());

        return vehicle;
    }

    public Vehicle toVehicle(VehicleDto dto) {

        Vehicle vehicle = new Vehicle();

        vehicle.setId(dto.getId());
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setCreationDate(dto.getCreationDate());
        vehicle.setUser(dto.getUser());

        return vehicle;
    }

    public VehicleDto toDto(Vehicle vehicle) {

        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setId(vehicle.getId());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setCreationDate(vehicle.getCreationDate());
        vehicleDto.setUser(vehicle.getUser());

        return vehicleDto;
    }

}
