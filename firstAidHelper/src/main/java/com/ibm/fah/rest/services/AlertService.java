package com.ibm.fah.rest.services;

import java.util.List;

import com.ibm.fah.rest.dto.AlertDTO;

public interface AlertService {
    public AlertDTO addAlert(AlertDTO alertDTO);
    public AlertDTO getAlert(String id);
    public void deleteAlert(String id);
    public List<AlertDTO> getAllAlerts();
}
