package natsystem.sato.card;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Card {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private String value;
    private String image;

    public Card() {
    }

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public Card(String color, String value, String image) {
        this.color = color;
        this.value = value;
        this.image = image;
    }
}
