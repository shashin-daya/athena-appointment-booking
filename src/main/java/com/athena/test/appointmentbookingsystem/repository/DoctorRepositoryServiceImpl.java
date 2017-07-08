package com.athena.test.appointmentbookingsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.athena.test.appointmentbookingsystem.models.Doctor;
import com.athena.test.appointmentbookingsystem.models.Qualification;
import com.athena.test.appointmentbookingsystem.models.Specialization;

public class DoctorRepositoryServiceImpl implements DoctorRepositoryService {

  private static final String CREATE_DOCTOR =
      "INSERT INTO doctor(name,qualification,experience,specialization) VALUES (?, ?, ?, ?)";
  private static final String DELETE_DOCTOR = "DELETE FROM doctor where doctor_id = ?";
  private static final String SELECT_DOCTOR = "SELECT * FROM doctor WHERE doctor_id = ?";
  private static final String SELECT_DOCTOR_BY_NAME = "SELECT * FROM doctor WHERE name = ?";
  private static final String UPDATE_DOCTOR =
      "UPDATE DOCTOR SET name = ?, qualification = ?, experience = ?, specialization = ? WHERE doctor_id = ?";

  @Override
  public void createDoctor(Doctor doctor) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(CREATE_DOCTOR)) {

      statement.setString(1, doctor.getName());
      statement.setString(2, doctor.getQualification().toString());
      statement.setString(3, doctor.getExperience());
      statement.setString(4, doctor.getSpecialization().toString());

      boolean created = statement.executeUpdate() > 0;
      System.out.println(doctor.toString() + " created: " + created);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void updateDoctor(Doctor doctor) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(UPDATE_DOCTOR)) {

      statement.setString(1, doctor.getName());
      statement.setString(2, doctor.getQualification().toString());
      statement.setString(3, doctor.getExperience());
      statement.setString(4, doctor.getSpecialization().toString());
      statement.setInt(5, doctor.getDoctorId());

      boolean updated = statement.executeUpdate() > 0;
      System.out.println(doctor.toString() + " updated: " + updated);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteDoctor(int doctorId) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(DELETE_DOCTOR)) {

      statement.setInt(1, doctorId);
      boolean deleted = statement.executeUpdate() > 0;
      System.out.println(doctorId + " deleted: " + deleted);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Doctor getDoctor(int doctorId) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(SELECT_DOCTOR)) {

      statement.setInt(1, doctorId);

      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return new Doctor(resultSet.getInt("doctor_id"), resultSet.getString("name"),
            Qualification.valueOf(resultSet.getString("qualification")), resultSet.getString("experience"),
            Specialization.valueOf(resultSet.getString("specialization")));
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Doctor getDoctor(String name) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(SELECT_DOCTOR_BY_NAME)) {

      statement.setString(1, name);

      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return new Doctor(resultSet.getInt("doctor_id"), resultSet.getString("name"),
            Qualification.valueOf(resultSet.getString("qualification")), resultSet.getString("experience"),
            Specialization.valueOf(resultSet.getString("specialization")));
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

}
