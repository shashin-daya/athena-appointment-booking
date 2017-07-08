package com.athena.test.appointmentbookingsystem.service;

import com.athena.test.appointmentbookingsystem.models.Patient;

public interface PatientService {

  void createPatient(Patient patient);

  void updatePatient(Patient patient);

  Patient getPatient(int patientId);

  Patient getPatient(String name);

  void deletePatient(int patientId);

}
