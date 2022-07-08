package tdv.repository;
import tdv.model.Animal;
import org.springframework.stereotype.Repository;

/**
 * Repositorio(bean) que maninipula a entidad Animal.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 * @see RepoBase
 * @see Animal
 */
@Repository("AnimalRepository")
public interface AnimalRepository extends RepoBase<Animal, Long> {
}

