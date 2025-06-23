package com.amol.DoctorsAppointmentApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.DoctorsAppointmentApplication.model.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Long> {


    Doctor findByDoctorId(Long docId);
}
