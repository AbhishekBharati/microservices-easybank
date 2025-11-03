package com.example.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDetailsDto {
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email address should be valid value")
    private String email;

    private String mobileNumber;

    private AccountsDTO accountsDTO;

    private LoansDto loansDto;

    private CardsDto cardsDto;
}
