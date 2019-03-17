package com.athena.test.appointmentbookingsystem.models;

public class Doctor {

  private int doctorId;
  private final String name;
  private final Qualification qualification;
  private final String experience;
  private final Specialization specialization;

  public Doctor(String name, Qualification qualification, String experience, Specialization specialization) {
    this.name = name;
    this.qualification = qualification;
    this.experience = experience;
    this.specialization = specialization;
  }

  public Doctor(int doctorId, String name, Qualification qualification, String experience,
      Specialization specialization) {
    this.doctorId = doctorId;
    this.name = name;
    this.qualification = qualification;
    this.experience = experience;
    this.specialization = specialization;
  }

  public int getDoctorId() {
    return doctorId;
  }

  public String getName() {
    return name;
  }

  public Qualification getQualification() {
    return qualification;
  }

  public String getExperience() {
    return experience;
  }

  public Specialization getSpecialization() {
    return specialization;
  }

  @Override
  public String toString() {
    return "Doctor [doctorId=" + doctorId + ", name=" + name + ", qualification=" + qualification + ", experience="
        + experience + ", specialization=" + specialization + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + doctorId;
    result = prime * result + ((experience == null) ? 0 : experience.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
    result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
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
    Doctor other = (Doctor) obj;
    if (doctorId != other.doctorId)
      return false;
    if (experience == null) {
      if (other.experience != null)
        return false;
    } else if (!experience.equals(other.experience))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (qualification != other.qualification)
      return false;
    if (specialization != other.specialization)
      return false;
    return true;
  }

}
