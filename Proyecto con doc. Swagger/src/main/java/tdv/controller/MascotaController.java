package tdv.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdv.model.Mascota;
import tdv.servicios.MascotaService;

/**
 * RestController de cliente brinda acceso a los servicios que competen a esta entidad.
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *          Nicolás Carsaniga: nikitobombero@gmail.com
 *          Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @see Mascota
 * @since 25/06/2022
 */
@RestController
@RequestMapping("/mascota")
public class MascotaController {

    /**
     * Bean(instancia única) de los servicios de cliente.
     *
     * @see MascotaService
     */
	@Autowired
	private MascotaService mascotaService;

    /**
     * Controlador que provee acceso al servicio encargado de devolver el listado de clientes.
     *
     * @return listado: Cliente
     */
    @GetMapping("")
    @Operation(
            summary = "Devuelve el listado: Mascota",
            description = "Servicio encargado de devolver el listado de mascotas.",
            tags = { "Mascota-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mascota.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mascotaService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de retornar un cliente con id ingresado por parámetro
     * @param id identificador único
     * @return Cliente
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Devuelve una mascota",
            description = "Servicio encargado de retornar una masxcotas con id ingresado por parámetro {id}.",
            tags = { "Mascota-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mascota.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mascotaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de persistir un cliente, retornando el cliente con el id asignado.
     *
     * @param entity Cliente a persistir.
     * @return Cliente c
     */
    @PostMapping("")
    @Operation(
            summary = "Persiste una Mascota",
            description = "Servicio encargado de persistir una mascota, retornando la mascota con el id asignado.",
            tags = { "Mascota-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mascota.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> save(@RequestBody Mascota entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mascotaService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de actualizar la mascota con el ID ingresado por parámetro, retornando la mascota actualizada.
     *
     * @param id  identificador único
     * @param entity cliente con cambios
     * @return mascota actualizado
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Actualiza una Mascota",
            description = "Servicio encargado de actualizar una mascota con el ID ingresado por parámetro, retornando una mascota actualizada.",
            tags = { "Mascota-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mascota.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Mascota entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mascotaService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    /**
     * Controlador que provee acceso al servicio encargado de eliminar una mascota con el ID ingresado por parámetro.
     *
     * @param id identificador único
     * @return mensaje de respuesta
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Elimina una Mascota",
            description = "Servicio encargado de eliminar la mascota con el ID ingresado por parámetro.",
            tags = { "Mascota-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mascota.class))
                    ),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mascotaService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }
	
}
