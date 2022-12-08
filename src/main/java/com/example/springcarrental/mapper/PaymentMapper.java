package com.example.springcarrental.mapper;

import com.example.springcarrental.dto.PaymentDTO;
import com.example.springcarrental.model.Payment;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentMapper extends GenericMapper<Payment, PaymentDTO> {
    @Override
    Payment asEntity(PaymentDTO dto);
}