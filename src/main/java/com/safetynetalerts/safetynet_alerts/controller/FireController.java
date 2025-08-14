package com.safetynetalerts.safetynet_alerts.controller;

import com.safetynetalerts.safetynet_alerts.dto.FireAddressResponseDTO;
import com.safetynetalerts.safetynet_alerts.service.FireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
@RequestMapping(value = "/fire", produces = MediaType.APPLICATION_JSON_VALUE)
public class FireController {

    private final FireService fireService;

    public FireController(FireService fireService) {
        this.fireService = fireService;
    }

    @GetMapping
    public ResponseEntity<?> getFireByAddress(@RequestParam("address") String address) {
        if (address == null || address.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "Query param 'address' is required"
                    ));
        }

        return fireService.getFireInfoByAddress(address)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of(
                                "status", 404,
                                "error", "Not Found",
                                "message", "No fire station coverage found for address: " + address.trim()
                        )));
    }

}

