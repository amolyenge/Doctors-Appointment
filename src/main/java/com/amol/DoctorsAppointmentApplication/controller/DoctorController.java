package com.amol.DoctorsAppointmentApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amol.DoctorsAppointmentApplication.model.Appointment;
import com.amol.DoctorsAppointmentApplication.model.Doctor;
import com.amol.DoctorsAppointmentApplication.service.DoctorService;

import java.util.List;


@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    DoctorService docService;

    @PostMapping()
    void addDoctor(@RequestBody Doctor doctor){
        docService.addDoctor(doctor);
    }

    @GetMapping("{docId}/appointments")
    ResponseEntity<List<Appointment>> getDocMyAppointments(@PathVariable Long docId)
    {

        List<Appointment> myAppointments = null;
        HttpStatus status;
        try
        {
            myAppointments = docService.getMyAppointments(docId);
           
            if(myAppointments.isEmpty())
            {
                status = HttpStatus.NO_CONTENT;
            }
            else
            {
                status = HttpStatus.OK;
            }
        }
        catch(Exception e)
        {
            System.out.println("The doc Id is not valid");
            status = HttpStatus.BAD_REQUEST;

        }

        return new ResponseEntity<List<Appointment>>(myAppointments,status);

    }


}
