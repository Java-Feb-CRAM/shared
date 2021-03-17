package com.smoothstack.utopia.shared.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class BookingPayment {

  @Id
  @Column(columnDefinition = "int")
  private Long bookingId;

  private String stripeId;

  @Column(columnDefinition = "tinyint")
  private Boolean refunded;

  @OneToOne
  @JoinColumn(name = "booking_id", referencedColumnName = "id")
  private Booking booking;
}
