package natsystem.sato.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CardApplication implements CommandLineRunner {

    @Autowired
    private CardService cardService;

    public static void main(String[] args) {
        SpringApplication.run(CardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] values = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Reine", "Roi"};
        String[] colors = {"Trèfle", "Pique", "Carreau", "Coeur"};
        List<Card> cards = new ArrayList<>();
        Integer i = 1;
        for (String c:
                colors) {
            for (String v:
                    values) {
                cards.add(new Card(c,v,"images/"+ i.toString()));
                i++;
            }
        }
        this.cardService.insertCards(cards);
    }
}
