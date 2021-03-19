package com.smoothstack.utopia.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rob Maes
 * Mar 17 2021
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class BookingUser {

  @Id
  @Column(columnDefinition = "int")
  private Long bookingId;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @JsonIgnoreProperties({ "bookingUser" })
  @OneToOne
  @JoinColumn(name = "booking_id", referencedColumnName = "id")
  private Booking booking;
}
