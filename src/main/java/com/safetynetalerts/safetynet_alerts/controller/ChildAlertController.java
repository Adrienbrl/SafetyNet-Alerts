package com.safetynetalerts.safetynet_alerts.controller;

import com.safetynetalerts.safetynet_alerts.dto.ChildDTO;
import com.safetynetalerts.safetynet_alerts.service.ChildAlertService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/childAlert")
public class ChildAlertController {

    private final ChildAlertService childAlertService;

    public ChildAlertController(ChildAlertService childAlertService) {
        this.childAlertService = childAlertService;
    }

    @GetMapping
    public List<ChildDTO> getChildrenByAddress(@RequestParam String address) {
        return childAlertService.getChildrenByAddress(address);
    }
}

