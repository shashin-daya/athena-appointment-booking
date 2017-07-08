package com.athena.test.appointmentbookingsystem.repository;

import com.athena.test.appointmentbookingsystem.models.Patient;

public interface PatientRepositoryService {

  void createPatient(Patient patient);

  void updatePatient(Patient patient);

  Patient getPatient(int patientId);

  Patient getPatient(String name);

  void deletePatient(int patientId);

}
