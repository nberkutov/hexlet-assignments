package exercise.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"title", "price"})
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String title;
    private long price;
}