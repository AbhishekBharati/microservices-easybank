package com.example.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AccountsDTO {
    @NotEmpty
    private Long accountNumber;

    @NotEmpty
    private String accountType;

    @NotEmpty
    private String branchAddress;

}
