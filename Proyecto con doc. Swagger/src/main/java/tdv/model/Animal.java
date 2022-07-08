package tdv.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Data
@Table(name = "animal")
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Especie de animal que es la mascota
     */
    private String especie;

    /**
     * Identificador único
     */
    public Animal() {
        super();
    }

    /**
     * Constructor con todos los atributos
     * @param especie del animal
     */
    public Animal(String especie) {
        this.especie = especie;
    }


}