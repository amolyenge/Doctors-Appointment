package com.amol.DoctorsAppointmentApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.DoctorsAppointmentApplication.model.Appointment;
import com.amol.DoctorsAppointmentApplication.model.Doctor;
import com.amol.DoctorsAppointmentApplication.repository.IDoctorRepo;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    IDoctorRepo doctorRepo;

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public void addDoctor(Doctor doctor) {

        doctorRepo.save(doctor);

    }

    public List<Appointment> getMyAppointments(Long docId) {

        Doctor myDoc = doctorRepo.findByDoctorId(docId);

        if(myDoc == null)
        {
            throw new IllegalStateException("The doctor does not exist");
        }

        return myDoc.getAppointments();
    }
}