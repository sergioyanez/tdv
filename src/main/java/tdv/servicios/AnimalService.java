package tdv.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdv.model.Animal;
import tdv.model.Mascota;
import tdv.repository.AnimalRepository;
import tdv.repository.MascotaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


/**
 * Clase encargada de ofrecer servicios concernientes a la entidad Cliente.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Mascota
 * @since 25/06/2022
 */
@Service
public class AnimalService implements BaseService<Animal>{

    /**
     * Bean(instancia única) del repositorio de Cliente.
     *
     * @see AnimalRepository
     */
    @Autowired
    private AnimalRepository animalRepository;
    @Override
    @Transactional
    public List findAll() throws Exception {
        try{
            return (List<Animal>) animalRepository.findAll();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Animal findById(Long id) throws Exception {
        try{
            Optional<Animal> entityOpcional = animalRepository.findById(id);
            return entityOpcional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Animal save(Animal entity) throws Exception {
        try{
            return animalRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Animal update(Long id, Animal entity) throws Exception {
        try{
            Optional<Animal> entityOpcional = animalRepository.findById(id);
            Animal animal = entityOpcional.get();
            animal = animalRepository.save(entity);
            return animal;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try{
            if(animalRepository.existsById(id)){
                animalRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
