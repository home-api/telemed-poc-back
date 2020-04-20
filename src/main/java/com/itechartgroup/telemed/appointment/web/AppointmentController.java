package com.itechartgroup.telemed.appointment.web;

import com.itechartgroup.telemed.appointment.entity.Appointment;
import com.itechartgroup.telemed.appointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointment/test")
    public ResponseEntity<Collection<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentService.getAll(), HttpStatus.OK);
    }

}