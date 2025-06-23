package com.amol.DoctorsAppointmentApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.DoctorsAppointmentApplication.model.AuthenticationToken;
import com.amol.DoctorsAppointmentApplication.repository.ITokenRepo;

@Service
public class AuthenticationService {

    @Autowired
    ITokenRepo tokenRepo;
    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }


    public boolean authenticate(String userEmail, String token) {
        AuthenticationToken authToken = tokenRepo.findFirstByToken(token);
        String expectedEmail = authToken.getPatient().getPatientEmail();
        return expectedEmail.equals(userEmail);
    }
}
