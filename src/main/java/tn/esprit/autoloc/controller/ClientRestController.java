
package tn.esprit.autoloc.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IclientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
@Tag(name = "Gestion des clients")
public class ClientRestController {

    private final IclientService clientService;

    @GetMapping
    @Operation(summary = "Récupérer tous les clients")
    @ApiResponse(responseCode = "200",
            description = "Liste des clients récupérée")
    public List<Client> getAllClients() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un client par ID")
    @ApiResponse(responseCode = "200",
            description = "Client trouvé")
    @ApiResponse(responseCode = "404",
            description = "Client introuvable")
    public Client getClient(@PathVariable Long id) {
        return clientService.retrieveClient(id);
    }

    @PostMapping
    @Operation(summary = "Ajouter un client")
    @ApiResponse(responseCode = "201",
            description = "Client créé")
    public ResponseEntity<Client> addClient(
            @RequestBody Client client) {

        Client result = clientService.addClient(client);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un client")
    @ApiResponse(responseCode = "200",
            description = "Client modifié")
    @ApiResponse(responseCode = "404",
            description = "Client introuvable")
    public Client updateClient(
            @PathVariable Long id,
            @RequestBody Client client) {

        client.setIdClient(id);
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un client")
    @ApiResponse(responseCode = "204",
            description = "Client supprimé")
    @ApiResponse(responseCode = "404",
            description = "Client introuvable")
    public ResponseEntity<Void> deleteClient(
            @PathVariable Long id) {

        clientService.removeClient(id);
        return ResponseEntity.noContent().build();
    }
}
