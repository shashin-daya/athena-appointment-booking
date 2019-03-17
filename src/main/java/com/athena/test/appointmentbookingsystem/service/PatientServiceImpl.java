package com.athena.test.appointmentbookingsystem.service;

import com.athena.test.appointmentbookingsystem.models.Patient;
import com.athena.test.appointmentbookingsystem.repository.PatientRepositoryService;
import com.athena.test.appointmentbookingsystem.repository.PatientRepositoryServiceImpl;

public class PatientServiceImpl implements PatientService {

  private final PatientRepositoryService patientRepositoryService;

  public PatientServiceImpl() {
    patientRepositoryService = new PatientRepositoryServiceImpl();
  }

  @Override
  public void createPatient(Patient patient) {
    if (patient.getPatientId() != 0 && patient.getName() != null) {
      patientRepositoryService.createPatient(patient);
    }
  }

  @Override
  public void updatePatient(Patient patient) {
    if (patient.getPatientId() != 0 && patientRepositoryService.getPatient(patient.getPatientId()) != null) {
      patientRepositoryService.updatePatient(patient);
    }
  }

  @Override
  public void deletePatient(int patientId) {
    if (patientId != 0 && patientRepositoryService.getPatient(patientId) != null) {
      patientRepositoryService.deletePatient(patientId);
    }
  }

  @Override
  public Patient getPatient(int patientId) {
    return patientRepositoryService.getPatient(patientId);
  }

  @Override
  public Patient getPatient(String name) {
    return patientRepositoryService.getPatient(name);
  }

}
