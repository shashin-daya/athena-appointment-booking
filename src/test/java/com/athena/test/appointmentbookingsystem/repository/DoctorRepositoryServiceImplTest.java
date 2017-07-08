package com.athena.test.appointmentbookingsystem.repository;

import org.junit.Test;

import com.athena.test.appointmentbookingsystem.models.Doctor;
import com.athena.test.appointmentbookingsystem.models.Qualification;
import com.athena.test.appointmentbookingsystem.models.Specialization;

public class DoctorRepositoryServiceImplTest {

  @Test
  public void testCreateDoctor() {
    DoctorRepositoryService service = new DoctorRepositoryServiceImpl();

    Doctor doctor = new Doctor("Rajan A", Qualification.MBBS, "4 years", Specialization.SURGERY);

    service.createDoctor(doctor);
  }

}
