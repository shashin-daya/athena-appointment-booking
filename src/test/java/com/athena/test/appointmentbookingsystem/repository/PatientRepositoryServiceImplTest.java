package com.athena.test.appointmentbookingsystem.repository;

import org.junit.Test;

import com.athena.test.appointmentbookingsystem.models.Patient;

public class PatientRepositoryServiceImplTest {

  @Test
  public void testCreatePatient() {
    PatientRepositoryService service = new PatientRepositoryServiceImpl();
    service.createPatient(new Patient("Vivek J", "318 BSK 3", "9911211121"));
  }

}
