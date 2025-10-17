package com.example.cards.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class CardsDto {

    @NotEmpty(message = "Mobile Number can't be null or empty")
    private String mobileNumber;

    @NotEmpty(message = "Card Number can't be null or empty")
    private String cardNumber;

    @NotEmpty(message = "Card Type can't be null or empty")
    private String cardType;

    @Positive(message = "Total limit should be greater than zero")
    private int totalLimit;

    @PositiveOrZero(message = "Total amount should be equal or greater than zero")
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    private int availableAmount;
}
