package com.example.springcarrental.controller.impl;

import com.example.springcarrental.controller.CarRentalController;
import com.example.springcarrental.dto.CarRentalDTO;
import com.example.springcarrental.dto.incoming.CarRentalRequestDTO;
import com.example.springcarrental.mapper.CarRentalMapper;
import com.example.springcarrental.mapper.PaymentMapper;
import com.example.springcarrental.model.*;
import com.example.springcarrental.service.*;
import com.example.springcarrental.service.impl.CarServiceImpl;
import com.example.springcarrental.service.impl.ClientServiceImpl;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/car-rental")
@RestController
public class CarRentalControllerImpl implements CarRentalController {
    private final CarRentalService carRentalService;
    private final ClientServiceImpl clientService;
    private final CarDescriptionService carDescriptionService;
    private final CarServiceImpl carService;

    private final PaymentService paymentService;
    private final CarRentalMapper carRentalMapper = Mappers.getMapper(CarRentalMapper.class);
    private final PaymentMapper paymentMapper = Mappers.getMapper(PaymentMapper.class);

    public CarRentalControllerImpl(CarRentalService carRentalService, ClientServiceImpl clientService, CarDescriptionService carDescriptionService, CarServiceImpl carService, PaymentService paymentService) {
        this.carRentalService = carRentalService;
        this.clientService = clientService;
        this.carDescriptionService = carDescriptionService;
        this.carService = carService;
        this.paymentService = paymentService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarRentalDTO save(@RequestBody CarRentalDTO carRentalDTO) {
        CarRental carRental = carRentalMapper.asEntity(carRentalDTO);
        return carRentalMapper.asDTO(carRentalService.save(carRental));
    }

    @Override
    @GetMapping("/{id}")
    public CarRentalDTO findById(@PathVariable("id") Long id) {
        CarRental carRental = carRentalService.findById(id).orElse(null);
        return carRentalMapper.asDTO(carRental);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        carRentalService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CarRentalDTO> list() {
        return carRentalMapper.asDTOList(carRentalService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CarRentalDTO> pageQuery(Pageable pageable) {
        Page<CarRental> carRentalPage = carRentalService.findAll(pageable);
        List<CarRentalDTO> dtoList = carRentalPage
                .stream()
                .map(carRentalMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, carRentalPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CarRentalDTO update(@RequestBody CarRentalDTO carRentalDTO, @PathVariable("id") Long id) {
        CarRental carRental = carRentalMapper.asEntity(carRentalDTO);
        return carRentalMapper.asDTO(carRentalService.update(carRental, id));
    }

    @Override
    @PostMapping("/create")
    public CarRentalDTO createNewRental(@RequestBody CarRentalRequestDTO carRentalRequest) {
        AppUser client = clientService.getByEmail(carRentalRequest.getClientEmail());
        //Get the client by his email
        if (client==null){
            return null;
        }
        //get the car description by id
        Optional<CarDescription> carDescriptionOpt = carDescriptionService.findById(carRentalRequest.getCarDescriptionId());
        if (!carDescriptionOpt.isPresent()){
            return null;
        }
        //get first the car available by description
        Car carToRent = carService.findFirstAvailable(carDescriptionOpt.get());
        if (carToRent==null){
            return null;
        }

        CarRental newCarRental = new CarRental();
        newCarRental.setClient(client);
        newCarRental.setCar(carToRent);
        newCarRental.setStatus(CarRental.Status.RESERVED);
        Payment firstPayment = paymentMapper.asEntity(carRentalRequest.getPayment());
        newCarRental.getPayments().add(firstPayment);
        paymentService.save(firstPayment);
        carRentalService.save(newCarRental);
        return carRentalMapper.asDTO(newCarRental);
    }
}