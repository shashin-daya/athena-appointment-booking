package com.athena.test.appointmentbookingsystem.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import com.athena.test.appointmentbookingsystem.models.Appointment;
import com.athena.test.appointmentbookingsystem.models.Doctor;
import com.athena.test.appointmentbookingsystem.models.Patient;
import com.athena.test.appointmentbookingsystem.repository.AppointmentRepositoryService;
import com.athena.test.appointmentbookingsystem.repository.AppointmentRepositoryServiceImpl;

public class AppointmentServiceImpl implements AppointmentService {

  private final AppointmentRepositoryService appointmentRepositoryService;
  private static final int DURATION_OF_APPOINTMENT = 20;


  public AppointmentServiceImpl() {
    appointmentRepositoryService = new AppointmentRepositoryServiceImpl();
  }

  @Override
  public LocalTime getWorkingDayStart() {
    return LocalTime.of(9, 0, 0, 0);
  }

  @Override
  public LocalTime getWorkingDayEnd() {
    return LocalTime.of(20, 0, 0, 0);
  }

  @Override
  public void bookAppointmentForDay(LocalDate date, Doctor doctor, Patient patient, LocalTime startTime,
      LocalTime endTime, String description) {

    if (doctor.getDoctorId() == 0 || patient.getPatientId() == 0 || date == null) {
      throw new IllegalArgumentException("Doctor ID, Patient ID and Date are required to book an appointment");
    }

    if (startTime == null || startTime.isBefore(getWorkingDayStart())) {
      startTime = getWorkingDayStart();
    }
    if (endTime == null || endTime.isAfter(getWorkingDayEnd())) {
      endTime = getWorkingDayEnd();
    }

    List<Appointment> appointments =
        appointmentRepositoryService.getAppointmentsForDay(
            ZonedDateTime.of(LocalDateTime.of(date, startTime), ZoneId.systemDefault()),
            ZonedDateTime.of(LocalDateTime.of(date, endTime), ZoneId.systemDefault()), doctor.getDoctorId());

    LocalTime availableStartTime = startTime;

    if(appointments.isEmpty()==false){
      for(int i=1;i<appointments.size();i++){
        if (appointments.get(i - 1).getTimeOfAppointment().plusMinutes(DURATION_OF_APPOINTMENT + 1)
            .isBefore(appointments.get(i).getTimeOfAppointment())) {
          availableStartTime =
              appointments.get(i - 1).getTimeOfAppointment().toLocalTime().plusMinutes(DURATION_OF_APPOINTMENT);
          break;
        } else {
          availableStartTime =
              appointments.get(i).getTimeOfAppointment().toLocalTime().plusMinutes(DURATION_OF_APPOINTMENT);
        }
      }
    }

    if (availableStartTime.isBefore(endTime)) {
      Appointment appointment = new Appointment(patient.getPatientId(), doctor.getDoctorId(),
          ZonedDateTime.of(LocalDateTime.of(date, availableStartTime), ZoneId.systemDefault()),
          ZonedDateTime.now(), description);
      appointmentRepositoryService.createAppointment(appointment);
    }

  }

  @Override
  public Appointment bookAppointmentForDateAndTime(LocalDateTime dateAndTime, Doctor doctor, Patient patient,
      String description) {

    if (doctor.getDoctorId() == 0 || patient.getPatientId() == 0 || dateAndTime == null) {
      throw new IllegalArgumentException("Doctor ID, Patient ID and Date are required to book an appointment");
    }
    if (dateAndTime.toLocalTime().isBefore(getWorkingDayStart())) {
      throw new IllegalArgumentException("Time is before working day start");
    }
    if (dateAndTime.toLocalTime().isAfter(getWorkingDayEnd())) {
      throw new IllegalArgumentException("Time is after working day end");
    }

    List<Appointment> appointments =
        appointmentRepositoryService.getAppointmentsForDay(dateAndTime.minusMinutes(DURATION_OF_APPOINTMENT).atZone(ZoneId.systemDefault()),
            dateAndTime.atZone(ZoneId.systemDefault()), doctor.getDoctorId());

    if (appointments.isEmpty()) {
      Appointment appointment = new Appointment(patient.getPatientId(), doctor.getDoctorId(),
          dateAndTime.atZone(ZoneId.systemDefault()), ZonedDateTime.now(), description);
      appointmentRepositoryService.createAppointment(appointment);
      return appointment;
    } else {
      return null;
    }

  }

}
