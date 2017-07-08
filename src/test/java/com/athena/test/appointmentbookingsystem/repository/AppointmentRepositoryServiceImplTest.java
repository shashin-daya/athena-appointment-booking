package com.athena.test.appointmentbookingsystem.repository;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.athena.test.appointmentbookingsystem.models.Appointment;

public class AppointmentRepositoryServiceImplTest {

  @Test
  public void testCreateAppointment() {
    AppointmentRepositoryService service = new AppointmentRepositoryServiceImpl();
    service.createAppointment(new Appointment(1, 1, ZonedDateTime.now(), ZonedDateTime.now(), "test 1"));
  }


}
