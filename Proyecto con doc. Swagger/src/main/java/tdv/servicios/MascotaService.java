package tdv.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdv.model.Mascota;
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
public class MascotaService implements BaseService<Mascota>{

    /**
     * Bean(instancia única) del repositorio de Cliente.
     *
     * @see MascotaRepository
     */
    @Autowired
    private MascotaRepository mascotaRepository;
    @Override
    @Transactional
    public List findAll() throws Exception {
        try{
            return (List<Mascota>) mascotaRepository.findAll();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Mascota findById(Long id) throws Exception {
        try{
            Optional<Mascota> entityOpcional = mascotaRepository.findById(id);
            return entityOpcional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mascota save(Mascota entity) throws Exception {
        try{
            return mascotaRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mascota update(Long id, Mascota entity) throws Exception {
        try{
            Optional<Mascota> entityOpcional = mascotaRepository.findById(id);
            Mascota mascota = entityOpcional.get();
            mascota = mascotaRepository.save(entity);
            return mascota;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try{
            if(mascotaRepository.existsById(id)){
                mascotaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
