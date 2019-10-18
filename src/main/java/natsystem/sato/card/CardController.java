package natsystem.sato.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/cards/")
public class CardController {

    private CardService cardService;

    @GetMapping()
    public Iterable<Card> getAllCards() {
        return this.cardService.findAllCards();
    }

    @GetMapping("images")
    public ResponseEntity<List<InputStreamResource>> getImages() throws IOException {

        List<InputStreamResource> images = new ArrayList<>();
        ClassPathResource imgFile = null;

        for (int i = 1; i<cardService.getCardNumber(); i++) {
            imgFile = new ClassPathResource("images/" + i + ".png");
            images.add(new InputStreamResource(imgFile.getInputStream()));
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(images);
    }

    @GetMapping("{id}")
    public Card getOneCard(@PathVariable Long id) {
        return this.cardService.getCard(id);
    }

    @GetMapping(value = "images/{id}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable Long id) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("images/" + id + ".png");

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
}
