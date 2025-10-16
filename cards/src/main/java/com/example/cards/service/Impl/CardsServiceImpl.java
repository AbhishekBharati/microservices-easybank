package com.example.cards.service.Impl;

import com.example.cards.constants.CardsConstants;
import com.example.cards.entity.Cards;
import com.example.cards.exception.CardAlreadyExistsException;
import com.example.cards.repository.CardsRepository;
import com.example.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {
    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber){
        Optional<Cards> cards = cardsRepository.findByMobileNumber(mobileNumber);
        if(cards.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with the given mobile number " + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber){
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);

        newCard.setCreatedAt(LocalDateTime.now());
        newCard.setCreatedBy("Annonymous");

        return newCard;
    }

}
