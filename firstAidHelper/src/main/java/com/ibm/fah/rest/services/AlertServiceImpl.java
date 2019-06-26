package com.ibm.fah.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fah.mongodb.models.Alert;
import com.ibm.fah.mongodb.repositories.AlertRepository;
import com.ibm.fah.rest.dto.AlertDTO;
import com.ibm.fah.rest.exception.EntityNotFoundException;

@Service
public class AlertServiceImpl implements AlertService{

	@Autowired
    private AlertRepository alertRepository;

    @Override
    public AlertDTO addAlert(AlertDTO alertDTO) {
        /**
         * We are manually creating {@link Alert} object however there is mapper
         * available to convert to-from {@link AlertDTO}.
         */
        Alert alert = new Alert();
        alert.setUserId(alertDTO.getUserId());
        alert.setLocation(alertDTO.getLocation());
        alertRepository.save(alert);

        /* set generated alert id to response object */
        alertDTO.setId(alert.getId());
        return alertDTO;
    }

    @Override
    public AlertDTO getAlert(String id) {
        Optional<Alert> alert = alertRepository.findById(id);
        if (Objects.isNull(alert)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new EntityNotFoundException(Alert.class, id);
        }
        return (alert.isPresent() ? new AlertDTO().build(alert.get()) : null);
    }
    
    @Override
    public List<AlertDTO> getAllAlerts() {
        List<Alert> alerts = alertRepository.findAll();
        if (Objects.isNull(alerts)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new EntityNotFoundException(Alert.class);
        }
        List<AlertDTO> dtos = new ArrayList<AlertDTO>();
        for (Alert alert: alerts) {
        	dtos.add(new AlertDTO().build(alert));
        }
        return dtos;
    }

    @Override
    public void deleteAlert(String id) {
        alertRepository.deleteById(id);
    }
}	
