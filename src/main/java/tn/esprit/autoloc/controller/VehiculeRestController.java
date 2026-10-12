
package tn.esprit.autoloc.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicules")
@Tag(name = "Gestion des véhicules")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    @GetMapping
    @Operation(summary = "Récupérer tous les véhicules")
    @ApiResponse(responseCode = "200",
            description = "Liste des véhicules récupérée")
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un véhicule par ID")
    @ApiResponse(responseCode = "200",
            description = "Véhicule trouvé")
    @ApiResponse(responseCode = "404",
            description = "Véhicule introuvable")
    public Vehicule getVehicule(@PathVariable Long id) {
        return vehiculeService.retrieveVehicule(id);
    }

    @PostMapping
    @Operation(summary = "Ajouter un véhicule")
    @ApiResponse(responseCode = "201",
            description = "Véhicule créé")
    public ResponseEntity<Vehicule> addVehicule(
            @RequestBody Vehicule vehicule) {

        Vehicule result = vehiculeService.addVehicule(vehicule);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un véhicule")
    @ApiResponse(responseCode = "200",
            description = "Véhicule modifié")
    @ApiResponse(responseCode = "404",
            description = "Véhicule introuvable")
    public Vehicule updateVehicule(
            @PathVariable Long id,
            @RequestBody Vehicule vehicule) {

        vehicule.setIdVehicule(id);
        vehiculeService.retrieveVehicule(id);
        return vehiculeService.updateVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un véhicule")
    @ApiResponse(responseCode = "204",
            description = "Véhicule supprimé")
    @ApiResponse(responseCode = "404",
            description = "Véhicule introuvable")
    public ResponseEntity<Void> deleteVehicule(
            @PathVariable Long id) {

        vehiculeService.retrieveVehicule(id);
        vehiculeService.removeVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
