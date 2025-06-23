package com.amol.DoctorsAppointmentApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.DoctorsAppointmentApplication.model.Appointment;
import com.amol.DoctorsAppointmentApplication.model.AppointmentKey;

public interface IAppointmentRepo extends JpaRepository<Appointment, AppointmentKey> {

public String findByIdAppId(Long id);

public String time(Long date);

public String findByTime(Long date);
}
