package tdv.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdv.model.Animal;
import tdv.servicios.AnimalService;


/**
 * RestController de animal brinda acceso a los servicios que competen a esta entidad.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *          Nicolás Carsaniga: nikitobombero@gmail.com
 *          Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Animal
 * @since 25/06/2022
 */
@RestController
@RequestMapping("/animal")
public class AnimalController {

    /**
     * Bean(instancia única) de los servicios de animal.
     *
     * @see AnimalService
     */
	@Autowired
	private AnimalService animalService;

    /**
     * Controlador que provee acceso al servicio encargado de devolver el listado de animals.
     *
     * @return listado: animal
     */
    @GetMapping("")
    @Operation(
            summary = "Devuelve el listado: animal",
            description = "Servicio encargado de devolver el listado de animales.",
            tags = { "Animal-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Animal.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(animalService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de retornar un animal con id ingresado por parámetro
     * @param id identificador único
     * @return animal
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Devuelve un animal",
            description = "Servicio encargado de retornar un animal con id ingresado por parámetro {id}.",
            tags = { "Animal-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Animal.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(animalService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de persistir un animal, retornando el animal con el id asignado.
     *
     * @param entity animal a persistir.
     * @return animal c
     */
    @PostMapping("")
    @Operation(
            summary = "Persiste un animal",
            description = "Servicio encargado de persistir un animal, retornando el animal con el id asignado.",
            tags = { "Animal-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Animal.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> save(@RequestBody Animal entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(animalService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de actualizar el animal con el ID ingresado por parámetro, retornando el animal actualizado.
     *
     * @param id  identificador único
     * @param entity animal con cambios
     * @return animal actualizado
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Actualiza un animal",
            description = "Servicio encargado de actualizar un animal con el ID ingresado por parámetro, retornando un animal actualizado.",
            tags = { "Animal-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Animal.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Animal entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(animalService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de eliminar un animal con el ID ingresado por parámetro.
     *
     * @param id identificador único
     * @return mensaje de respuesta
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Elimina una" +
                    " animal",
            description = "Servicio encargado de eliminar el animal con el ID ingresado por parámetro.",
            tags = { "Animal-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Animal.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(animalService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }
	
}
