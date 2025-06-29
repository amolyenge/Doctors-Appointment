package com.amol.DoctorsAppointmentApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amol.DoctorsAppointmentApplication.dto.SignInInput;
import com.amol.DoctorsAppointmentApplication.dto.SignInOutput;
import com.amol.DoctorsAppointmentApplication.dto.SignUpInput;
import com.amol.DoctorsAppointmentApplication.dto.SignUpOutput;
import com.amol.DoctorsAppointmentApplication.model.Doctor;
import com.amol.DoctorsAppointmentApplication.service.AuthenticationService;
import com.amol.DoctorsAppointmentApplication.service.PatientService;

import java.util.List;

@RestController
@RequestMapping(value = "patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AuthenticationService authService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return patientService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return patientService.signIn(signInDto);
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam String userEmail , @RequestParam String token){
        HttpStatus status;
        List<Doctor> allDoctors = null;

        

        if(authService.authenticate(userEmail,token))
        {

            allDoctors =  patientService.getAllDoctors();
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }



        return new ResponseEntity<List<Doctor>>(allDoctors, status);


    }


}
