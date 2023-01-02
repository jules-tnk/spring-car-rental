package com.example.springcarrental.dto.incoming;

import com.example.springcarrental.dto.PaymentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarRentalRequestDTO {
    private String userEmail;
    private Long CarDescriptionId;
    private PaymentDTO payment;
}
