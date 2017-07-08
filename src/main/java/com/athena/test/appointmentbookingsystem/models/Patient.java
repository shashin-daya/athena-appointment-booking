package com.athena.test.appointmentbookingsystem.models;

public class Patient {

  private int patientId;
  private final String name;
  private final String address;
  private final String phoneNumber;

  public Patient(String name, String address, String phoneNumber) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  public Patient(int patientId, String name, String address, String phoneNumber) {
    this.patientId = patientId;
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  public int getPatientId() {
    return patientId;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public String toString() {
    return "Patient [patientId=" + patientId + ", name=" + name + ", address=" + address + ", phoneNumber="
        + phoneNumber + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + patientId;
    result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
    Patient other = (Patient) obj;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (patientId != other.patientId)
      return false;
    if (phoneNumber == null) {
      if (other.phoneNumber != null)
        return false;
    } else if (!phoneNumber.equals(other.phoneNumber))
      return false;
    return true;
  }

}
