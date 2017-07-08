package com.athena.test.appointmentbookingsystem.models;

import java.time.ZonedDateTime;

public class Appointment {

  private int patientId;
  private int doctorId;
  private ZonedDateTime timeOfAppointment;
  private ZonedDateTime postingTime;
  private String description;

  public Appointment(int patientId, int doctorId, ZonedDateTime timeOfAppointment, ZonedDateTime postingTime,
      String description) {
    this.patientId = patientId;
    this.doctorId = doctorId;
    this.timeOfAppointment = timeOfAppointment;
    this.postingTime = postingTime;
    this.description = description;
  }

  public int getPatientId() {
    return patientId;
  }

  public int getDoctorId() {
    return doctorId;
  }

  public ZonedDateTime getTimeOfAppointment() {
    return timeOfAppointment;
  }

  public ZonedDateTime getPostingTime() {
    return postingTime;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "Appointment [patientId=" + patientId + ", doctorId=" + doctorId + ", timeOfAppointment=" + timeOfAppointment
        + ", postingTime=" + postingTime + ", description=" + description + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + doctorId;
    result = prime * result + patientId;
    result = prime * result + ((postingTime == null) ? 0 : postingTime.hashCode());
    result = prime * result + ((timeOfAppointment == null) ? 0 : timeOfAppointment.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Appointment other = (Appointment) obj;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (doctorId != other.doctorId)
      return false;
    if (patientId != other.patientId)
      return false;
    if (postingTime == null) {
      if (other.postingTime != null)
        return false;
    } else if (!postingTime.equals(other.postingTime))
      return false;
    if (timeOfAppointment == null) {
      if (other.timeOfAppointment != null)
        return false;
    } else if (!timeOfAppointment.equals(other.timeOfAppointment))
      return false;
    return true;
  }

}
