package com.smoothstack.utopia.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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

  @JsonIgnoreProperties(
    {
      "flights",
      "bookingPayment",
      "bookingGuest",
      "bookingAgent",
      "bookingUser",
    }
  )
  @ManyToMany
  @JoinTable(
    name = "flight_bookings",
    joinColumns = @JoinColumn(name = "flight_id"),
    inverseJoinColumns = @JoinColumn(name = "booking_id")
  )
  private Set<Booking> bookings;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonIgnoreProperties({ "flight" })
  @OneToMany(mappedBy = "flight")
  private Set<Seat> seats;

  @Transient
  private Integer availableSeats;

  @Transient
  private Integer totalSeats;

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

  public Integer getAvailableSeats() {
    int count = 0;
    if (this.getSeats() != null) {
      Set<Seat> seats = this.getSeats();
      for (Seat seat : seats) {
        if (seat.getPassenger() == null) {
          count += 1;
        }
      }
    }

    return count;
  }

  public Integer getTotalSeats() {
    if (this.getSeats() != null) {
      return this.getSeats().size();
    } else {
      return 0;
    }
  }
}
