package com.smoothstack.utopia.shared.model;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

/**
 * @author Rob Maes
 * Mar 16 2021
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Passenger {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  private Booking booking;

  private String givenName;
  private String familyName;
  private LocalDate dob;

  @Column(length = 45)
  private String gender;

  @Column(length = 45)
  private String address;

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
