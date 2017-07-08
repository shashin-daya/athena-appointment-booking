package com.athena.test.appointmentbookingsystem.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import com.athena.test.appointmentbookingsystem.models.Doctor;
import com.athena.test.appointmentbookingsystem.models.Patient;

public class AppointmentServiceImplTest {

  @Test
  public void testBookAppointmentForDateAndTime() {
    DoctorService doctorService = new DoctorServiceImpl();
    Doctor doctor = doctorService.getDoctor("Rajan A");

    PatientService patientService = new PatientServiceImpl();
    Patient patient = patientService.getPatient("Vivek J");

    AppointmentService appointmentService = new AppointmentServiceImpl();
    appointmentService.bookAppointmentForDateAndTime(LocalDateTime.of(2017, 07, 20, 19, 41), doctor, patient,
        "test appointment");
  }

  @Test
  public void testCreateAppointment() {
    DoctorService doctorService = new DoctorServiceImpl();
    Doctor doctor = doctorService.getDoctor("Rajan A");

    PatientService patientService = new PatientServiceImpl();
    Patient patient = patientService.getPatient("Vivek J");

    AppointmentService appointmentService = new AppointmentServiceImpl();
    appointmentService.bookAppointmentForDay(LocalDate.of(2017, 07, 20), doctor, patient, null, null, "test 2");
  }

}
