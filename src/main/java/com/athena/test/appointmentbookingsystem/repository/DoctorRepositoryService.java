package com.athena.test.appointmentbookingsystem.repository;

import com.athena.test.appointmentbookingsystem.models.Doctor;

public interface DoctorRepositoryService {

  void createDoctor(Doctor doctor);

  void updateDoctor(Doctor doctor);

  Doctor getDoctor(int doctorId);

  void deleteDoctor(int doctorId);

  Doctor getDoctor(String name);

}
