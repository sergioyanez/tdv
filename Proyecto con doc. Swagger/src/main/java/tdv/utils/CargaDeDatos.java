package tdv.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tdv.model.Animal;
import tdv.model.Mascota;
import tdv.servicios.AnimalService;
import tdv.servicios.MascotaService;


import java.time.LocalDate;
import java.util.stream.IntStream;

/**
 * Clase encargada de la generación de datos para el llenado de la base de datos con datos de muestra.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail,.com
 * @version 1.0
 * @since 25/06/2022
 */
@Configuration
public class CargaDeDatos {
    /**
     * Variable auxiliar
     */
    long ID =1;

    /**
     * Bean con la lógica de la inserción de datos generados(mock) pra el llenado de la base de datos.
     *
     * @param mascotas Servicio clientes
     * @param animales Servicio producto
     * @return Línea de comando a ejecutar por Spring
     */
    @Bean
    public CommandLineRunner cargaDB(MascotaService mascotas, AnimalService animales){
        return args-> {
            //Se insertan 10 animales y 10 mascotas
            IntStream.range(0, 10).forEach(i -> {
                Animal a = new Animal("Animal " + i);
                try {
                    animales.save(a);
                    Mascota m = new Mascota("Mascota " + i, a,5);
                    mascotas.save(m);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        };
    }
}
