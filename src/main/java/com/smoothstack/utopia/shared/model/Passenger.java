package com.smoothstack.utopia.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rob Maes
 * Mar 16 2021
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Passenger {

  @Id
  @Column(columnDefinition = "int")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String givenName;
  private String familyName;
  private LocalDate dob;

  @Column(length = 45)
  private String gender;

  @Column(length = 45)
  private String address;

  @JsonIgnoreProperties({ "passengers" })
  @ManyToOne
  @JoinColumn(name = "booking_id", nullable = false)
  private Booking booking;

  public Passenger(
    Booking booking,
    String givenName,
    String familyName,
    LocalDate dob,
    String gender,
    String address
  ) {
    this.booking = booking;
    this.givenName = givenName;
    this.familyName = familyName;
    this.dob = dob;
    this.gender = gender;
    this.address = address;
  }
}
