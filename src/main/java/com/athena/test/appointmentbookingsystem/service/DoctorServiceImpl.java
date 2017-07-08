package com.athena.test.appointmentbookingsystem.service;

import com.athena.test.appointmentbookingsystem.models.Doctor;
import com.athena.test.appointmentbookingsystem.repository.DoctorRepositoryService;
import com.athena.test.appointmentbookingsystem.repository.DoctorRepositoryServiceImpl;

public class DoctorServiceImpl implements DoctorService {

  private final DoctorRepositoryService doctorRepositoryService;

  public DoctorServiceImpl() {
    doctorRepositoryService = new DoctorRepositoryServiceImpl();
  }

  @Override
  public void createDoctor(Doctor doctor) {
    if (doctor.getDoctorId() != 0 && doctor.getName() != null) {
      doctorRepositoryService.createDoctor(doctor);
    }
  }

  @Override
  public void updateDoctor(Doctor doctor) {
    if (doctor.getDoctorId() != 0 && doctorRepositoryService.getDoctor(doctor.getDoctorId()) != null) {
      doctorRepositoryService.updateDoctor(doctor);
    }
  }

  @Override
  public void deleteDoctor(int doctorId) {
    if (doctorId != 0 && doctorRepositoryService.getDoctor(doctorId) != null) {
      doctorRepositoryService.deleteDoctor(doctorId);
    }
  }

  @Override
  public Doctor getDoctor(int doctorId) {
    return doctorRepositoryService.getDoctor(doctorId);
  }

  @Override
  public Doctor getDoctor(String name) {
    return doctorRepositoryService.getDoctor(name);
  }

}
