package com.amol.DoctorsAppointmentApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.DoctorsAppointmentApplication.model.AuthenticationToken;

public interface ITokenRepo extends JpaRepository<AuthenticationToken, Long> {


    AuthenticationToken findByPatient(Patient patient);

    AuthenticationToken findFirstByToken(String token);
}
