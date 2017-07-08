package com.athena.test.appointmentbookingsystem.repository;

import java.time.ZonedDateTime;
import java.util.List;

import com.athena.test.appointmentbookingsystem.models.Appointment;

public interface AppointmentRepositoryService {

  void createAppointment(Appointment appointment);

  List<Appointment> getAppointmentsForDay(ZonedDateTime startTime, ZonedDateTime endTime, int doctorId);

}
