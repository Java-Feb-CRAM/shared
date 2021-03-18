package com.smoothstack.utopia.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Flight {

  @Id
  @Column(columnDefinition = "int")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnoreProperties({ "flights" })
  @ManyToOne
  @JoinColumn(name = "route_id", nullable = false)
  private Route route;

  @JsonIgnoreProperties({ "flights" })
  @ManyToOne
  @JoinColumn(name = "airplane_id", nullable = false)
  private Airplane airplane;

  private Instant departureTime;
  private Integer reservedSeats;
  private Float seatPrice;

  @ManyToMany
  @JoinTable(
    name = "flight_bookings",
    joinColumns = @JoinColumn(name = "flight_id"),
    inverseJoinColumns = @JoinColumn(name = "booking_id")
  )
  private Set<Booking> bookings;

  public Flight(
    Route route,
    Instant departureTime,
    Integer reservedSeats,
    Float seatPrice
  ) {
    this.route = route;
    this.departureTime = departureTime;
    this.reservedSeats = reservedSeats;
    this.seatPrice = seatPrice;
  }

  public Flight(
    Route route,
    Airplane airplane,
    Instant departureTime,
    Integer reservedSeats,
    Float seatPrice
  ) {
    this.route = route;
    this.airplane = airplane;
    this.departureTime = departureTime;
    this.reservedSeats = reservedSeats;
    this.seatPrice = seatPrice;
  }
}
