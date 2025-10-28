package com.example.loans.controllers;

import com.example.loans.constants.LoansConstants;
import com.example.loans.dto.LoansContactInfoDto;
import com.example.loans.dto.LoansDto;
import com.example.loans.dto.ResponseDto;
import com.example.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class LoansController {
    private ILoansService iLoansService;

    @Autowired
    private LoansContactInfoDto loansContactInfoDto;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createNewLoan(@RequestParam String mobileNumber){
        iLoansService.createLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoan(@RequestParam String mobileNumber){
        return ResponseEntity.status(HttpStatus.OK)
                .body(iLoansService.fetchLoan(mobileNumber));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoan(@RequestBody LoansDto loansDto){
        if(iLoansService.updateLoan(loansDto)){
            return new ResponseEntity<>(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoan(@RequestParam String mobileNumber){
        if(iLoansService.deleteLoan(mobileNumber)){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
        }
    }

    @GetMapping("/get-contact")
    public ResponseEntity<LoansContactInfoDto> getContactInfo(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(loansContactInfoDto);
    }
}
