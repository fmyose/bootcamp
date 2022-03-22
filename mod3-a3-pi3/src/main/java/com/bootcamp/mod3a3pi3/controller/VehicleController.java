package com.bootcamp.mod3a3pi3.controller;

import com.bootcamp.mod3a3pi3.model.Vehicle;
import com.bootcamp.mod3a3pi3.model.dto.VehicleDTO;
import com.bootcamp.mod3a3pi3.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/v1/api/veiculos")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle, UriComponentsBuilder uriBuilder) {
        vehicleService.add(vehicle);
        URI uri = uriBuilder
                .path("/v1/api/veiculos/{id}")
                .buildAndExpand(vehicle.getModel())
                .toUri();
        return ResponseEntity.created(uri).body(vehicle);
    }

    @GetMapping("/v1/api/veiculos")
    public ResponseEntity<List<VehicleDTO>> getVehicle() {
        List<VehicleDTO> vehicleDTOS = vehicleService.getVehiclesByManufactureDate();

        return ResponseEntity.ok(vehicleDTOS);
    }

    @GetMapping("/v1/api/veiculos/dates")
    public ResponseEntity<List<VehicleDTO>> getVehicleByDates(@RequestParam(name = "since") Integer sinceDate,
                                                              @RequestParam(name = "to") Integer toDate) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByManufactureDate(sinceDate, toDate);

        return ResponseEntity.ok(VehicleDTO.convertToDTO(vehicles));
    }

    @GetMapping("/v1/api/veiculos/prices")
    public ResponseEntity<List<VehicleDTO>> getVehicleByPrices(@RequestParam(name = "since") Double sincePrice,
                                                               @RequestParam(name = "to") Double toPrice) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByPrices(sincePrice, toPrice);

        return ResponseEntity.ok(VehicleDTO.convertToDTO(vehicles));
    }

    @GetMapping("/v1/api/veiculos/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) {
        Vehicle vehicle = vehicleService.getVehicle(id);

        return ResponseEntity.ok(vehicle);
    }

}
