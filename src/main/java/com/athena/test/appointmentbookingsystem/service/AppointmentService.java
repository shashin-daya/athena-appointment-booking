package com.athena.test.appointmentbookingsystem.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.athena.test.appointmentbookingsystem.models.Appointment;
import com.athena.test.appointmentbookingsystem.models.Doctor;
import com.athena.test.appointmentbookingsystem.models.Patient;

public interface AppointmentService {

  LocalTime getWorkingDayStart();

  LocalTime getWorkingDayEnd();

  void bookAppointmentForDay(LocalDate date, Doctor doctor, Patient patient, LocalTime startTime, LocalTime endTime,
      String description);

  Appointment bookAppointmentForDateAndTime(LocalDateTime dateAndTime, Doctor doctor, Patient patient,
      String description);

}
