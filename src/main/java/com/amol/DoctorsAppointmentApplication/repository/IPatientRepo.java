package com.amol.DoctorsAppointmentApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.DoctorsAppointmentApplication.model.Patient;

public interface IPatientRepo extends JpaRepository<Patient, Long> {

    Patient findFirstByPatientEmail(String userEmail);
}
