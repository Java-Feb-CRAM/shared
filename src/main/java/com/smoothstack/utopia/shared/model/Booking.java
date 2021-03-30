package com.smoothstack.utopia.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Booking {

  @Id
  @Column(columnDefinition = "int")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "tinyint")
  private Boolean isActive;

  private String confirmationCode;

  @JsonIgnoreProperties({ "bookings" })
  @ManyToMany(mappedBy = "bookings")
  private Set<Flight> flights;

  @JsonIgnoreProperties({ "booking" })
  @OneToMany(mappedBy = "booking")
  private Set<Passenger> passengers;

  @JsonIgnoreProperties({ "booking" })
  @OneToOne(mappedBy = "booking")
  private BookingPayment bookingPayment;

  @JsonIgnoreProperties({ "booking" })
  @OneToOne(mappedBy = "booking")
  private BookingGuest bookingGuest;

  @JsonIgnoreProperties({ "booking" })
  @OneToOne(mappedBy = "booking")
  private BookingAgent bookingAgent;

  @JsonIgnoreProperties({ "booking", "bookingUsers" })
  @OneToOne(mappedBy = "booking")
  private BookingUser bookingUser;
}
