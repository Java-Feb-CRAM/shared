package com.smoothstack.utopia.shared.model;

import java.time.Instant;
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
public class Flight {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  private Route route;

  @ManyToOne
  private Airplane airplane;

  private Instant departureTime;
  private Integer reservedSeats;
  private Float seatPrice;

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
