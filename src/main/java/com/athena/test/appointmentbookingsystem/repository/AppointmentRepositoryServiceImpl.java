package com.athena.test.appointmentbookingsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.athena.test.appointmentbookingsystem.models.Appointment;

public class AppointmentRepositoryServiceImpl implements AppointmentRepositoryService {

  private static final String CREATE_APPOINTMENT =
      "INSERT INTO appointment(time_of_appointment,posting_time,description,patient_id,doctor_id) VALUES (?, ?, ?, ?, ?)";
  // private static final String DELETE_APPOINTMENT = "DELETE FROM appointment where appointment_id = ?";
  // private static final String SELECT_APPOINTMENT = "SELECT * FROM appointment WHERE appointment_id = ?";
  private static final String SELECT_APPOINTMENTS_FOR_DAY =
      "SELECT * FROM appointment WHERE time_of_appointment >= ? AND time_of_appointment < ? AND doctor_id = ? ORDER BY time_of_appointment";
  // private static final String UPDATE_APPOINTMENT =
  // "UPDATE APPOINTMENT SET name = ?, qualification = ?, experience = ?, specialization = ? WHERE appointment_id = ?";

  @Override
  public void createAppointment(Appointment appointment) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(CREATE_APPOINTMENT)) {

      statement.setTimestamp(1, Timestamp.from(appointment.getTimeOfAppointment().toInstant()));
      statement.setTimestamp(2, Timestamp.from(appointment.getPostingTime().toInstant()));
      statement.setString(3, appointment.getDescription());
      statement.setInt(4, appointment.getPatientId());
      statement.setInt(5, appointment.getDoctorId());

      boolean created = statement.executeUpdate() > 0;
      System.out.println(appointment.toString() + " created: " + created);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Appointment> getAppointmentsForDay(ZonedDateTime startTime, ZonedDateTime endTime, int doctorId) {
    List<Appointment> appointments = new ArrayList<>();
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(SELECT_APPOINTMENTS_FOR_DAY)) {

      statement.setTimestamp(1, Timestamp.from(startTime.toInstant()));
      statement.setTimestamp(2, Timestamp.from(endTime.toInstant()));
      statement.setInt(3, doctorId);

      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        appointments.add(new Appointment(resultSet.getInt("patient_id"), resultSet.getInt("doctor_id"),
            ZonedDateTime.ofInstant(resultSet.getTimestamp("time_of_appointment").toInstant(), ZoneId.systemDefault()),
            ZonedDateTime.ofInstant(resultSet.getTimestamp("posting_time").toInstant(), ZoneId.systemDefault()),
            resultSet.getString("description")));
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return appointments;
  }

}
