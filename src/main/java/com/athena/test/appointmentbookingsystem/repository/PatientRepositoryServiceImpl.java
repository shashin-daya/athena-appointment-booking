package com.athena.test.appointmentbookingsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.athena.test.appointmentbookingsystem.models.Patient;

public class PatientRepositoryServiceImpl implements PatientRepositoryService {

  private static final String CREATE_PATIENT = "INSERT INTO patient(name,address,phone_no) VALUES (?, ?, ?)";
  private static final String DELETE_PATIENT = "DELETE FROM patient where patient_id = ?";
  private static final String SELECT_PATIENT = "SELECT * FROM patient WHERE patient_id = ?";
  private static final String SELECT_PATIENT_BY_NAME = "SELECT * FROM patient WHERE name = ?";
  private static final String UPDATE_PATIENT =
      "UPDATE PATIENT SET name = ?, address = ?, phone_no = ? WHERE patient_id = ?";

  @Override
  public void createPatient(Patient patient) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(CREATE_PATIENT)) {

      statement.setString(1, patient.getName());
      statement.setString(2, patient.getAddress());
      statement.setString(3, patient.getPhoneNumber());

      boolean created = statement.executeUpdate() > 0;
      System.out.println(patient.toString() + " created: " + created);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void updatePatient(Patient patient) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(UPDATE_PATIENT)) {

      statement.setString(1, patient.getName());
      statement.setString(2, patient.getAddress());
      statement.setString(3, patient.getPhoneNumber());
      statement.setInt(4, patient.getPatientId());

      boolean updated = statement.executeUpdate() > 0;
      System.out.println(patient.toString() + " updated: " + updated);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deletePatient(int patientId) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(DELETE_PATIENT)) {

      statement.setInt(1, patientId);
      boolean deleted = statement.executeUpdate() > 0;
      System.out.println(patientId + " deleted: " + deleted);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Patient getPatient(int patientId) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(SELECT_PATIENT)) {

      statement.setInt(1, patientId);

      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return new Patient(resultSet.getInt("patient_id"), resultSet.getString("name"),
            resultSet.getString("address"), resultSet.getString("phone_no"));
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Patient getPatient(String name) {
    try (Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(SELECT_PATIENT_BY_NAME)) {

      statement.setString(1, name);

      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return new Patient(resultSet.getInt("patient_id"), resultSet.getString("name"), resultSet.getString("address"),
            resultSet.getString("phone_no"));
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }


}
