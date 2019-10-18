package natsystem.sato.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private CardRepository cardRepository;

    public Card insertCard(Card card) {
        return this.cardRepository.save(card);
    }
    public Iterable<Card> insertCards(Iterable<Card> cards) {
        return this.cardRepository.saveAll(cards);
    }
    public Iterable<Card> findAllCards(){
        return this.cardRepository.findAll();
    }

    public Card getCard(Long id) {
        return this.cardRepository.findById(id).get();
    }

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public long getCardNumber() {
        return this.cardRepository.count();
    }
}
