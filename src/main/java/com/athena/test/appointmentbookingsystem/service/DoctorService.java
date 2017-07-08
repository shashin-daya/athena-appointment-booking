package com.athena.test.appointmentbookingsystem.service;

import com.athena.test.appointmentbookingsystem.models.Doctor;

public interface DoctorService {

  void createDoctor(Doctor doctor);

  void updateDoctor(Doctor doctor);

  Doctor getDoctor(int doctorId);

  void deleteDoctor(int doctorId);

  Doctor getDoctor(String name);

}
