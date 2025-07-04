package com.amol.DoctorsAppointmentApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.DoctorsAppointmentApplication.model.Appointment;
import com.amol.DoctorsAppointmentApplication.model.AppointmentKey;
import com.amol.DoctorsAppointmentApplication.repository.IAppointmentRepo;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
  //  IAppointmentRepo appointmentRepo;
    public void bookAppointment(Appointment appointment) {

        Optional<Appointment> myAppointment = appointmentRepo.findById(appointment.getId());
        if(myAppointment.isEmpty()){
            appointmentRepo.save(appointment);
        }else{
            throw new IllegalStateException("Appointment with id already present");
        }

    }

    public void cancelAppointment(AppointmentKey key) {
        appointmentRepo.deleteById(key);
    }
}
