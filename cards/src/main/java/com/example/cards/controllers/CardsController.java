package com.example.cards.controllers;

import com.example.cards.constants.CardsConstants;
import com.example.cards.dto.CardsDto;
import com.example.cards.dto.ResponseDto;
import com.example.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CardsController {

    private ICardsService iCardsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createNewCard(@RequestParam String mobileNumber){
        iCardsService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCard(@RequestParam String mobileNumber){
        return ResponseEntity.status(HttpStatus.OK)
                .body(iCardsService.fetchCard(mobileNumber));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCard(@RequestBody CardsDto cardsDto){
        boolean isUpdated = iCardsService.updateCard(cardsDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCard(@RequestParam String mobileNumber){
        if(iCardsService.deleteCard(mobileNumber)){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_DELETE));
        }
    }
}
