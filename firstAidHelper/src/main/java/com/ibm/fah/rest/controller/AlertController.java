package com.ibm.fah.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fah.rest.dto.AlertDTO;
import com.ibm.fah.rest.response.SuccessResponse;
import com.ibm.fah.rest.services.AlertService;

@RestController
@RequestMapping("/api/alert/mongodb")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @PostMapping
    public ResponseEntity<AlertDTO> addAlert(@Valid @RequestBody AlertDTO alertDTO) {
        return ResponseEntity.ok(alertService.addAlert(alertDTO));
    }

    @GetMapping
    public ResponseEntity<AlertDTO> getAlert(@RequestParam String id) {
        return ResponseEntity.ok(alertService.getAlert(id));
    }
    
    @GetMapping("/allAlerts")
    public ResponseEntity<?> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAlert(@RequestParam String id) {
        alertService.deleteAlert(id);
        return ResponseEntity.ok(new SuccessResponse("deleted"));
    }
}
