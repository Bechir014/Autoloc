
package tn.esprit.autoloc.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/agences")
@Tag(name = "Gestion des agences")
public class AgenceRestController {

    private final IAgenceService agenceService;

    @GetMapping
    @Operation(summary = "Récupérer toutes les agences")
    @ApiResponse(responseCode = "200",
            description = "Liste des agences récupérée")
    public List<Agence> getAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une agence par ID")
    @ApiResponse(responseCode = "200",
            description = "Agence trouvée")
    @ApiResponse(responseCode = "404",
            description = "Agence introuvable")
    public Agence getAgence(@PathVariable Long id) {
        return agenceService.retrieveAgence(id);
    }

    @PostMapping
    @Operation(summary = "Ajouter une agence")
    @ApiResponse(responseCode = "201",
            description = "Agence créée")
    public ResponseEntity<Agence> addAgence(
            @RequestBody Agence agence) {

        Agence result = agenceService.addAgence(agence);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une agence")
    @ApiResponse(responseCode = "200",
            description = "Agence modifiée")
    @ApiResponse(responseCode = "404",
            description = "Agence introuvable")
    public Agence updateAgence(
            @PathVariable Long id,
            @RequestBody Agence agence) {

        agence.setIdAgence(id);
        agenceService.retrieveAgence(id);
        return agenceService.updateAgence(agence);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une agence")
    @ApiResponse(responseCode = "204",
            description = "Agence supprimée")
    @ApiResponse(responseCode = "404",
            description = "Agence introuvable")
    public ResponseEntity<Void> deleteAgence(
            @PathVariable Long id) {

        agenceService.retrieveAgence(id);
        agenceService.removeAgence(id);
        return ResponseEntity.noContent().build();
    }
}
