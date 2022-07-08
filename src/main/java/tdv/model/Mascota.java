package tdv.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad Mascota
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *			Héctor Liceaga: lice2187@gmail.com
 *			Nicolás Carsaniga: nikitobombero@gmail.com
 *			Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 */
@Getter
@Setter
@Entity
@Data
@Table(name = "mascota")
public class Mascota implements Serializable {

    /**
     * Identificador único
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * String nombre de la mascota
     */
    @Column
    private String nombre;

    /**
     * Animal tipo de animal que es la mascota
     */
    @ManyToOne
    @JoinColumn(name = "tipo_animal_id")
    private Animal tipoAnimal;

    @Column
    private int edad;

    /**
     * Constructor vacío
     */
    public Mascota(){
        super();
    }

    /**
     * Constructor con todos los atributos
     * @param nombre de la mascota
     * @param tipoAnimal de la mascota
     * @param edad de la mascota
     */
    public Mascota(String nombre, Animal tipoAnimal, int edad) {
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoAnimal=" + tipoAnimal +
                ", edad=" + edad +
                '}';
    }
}

