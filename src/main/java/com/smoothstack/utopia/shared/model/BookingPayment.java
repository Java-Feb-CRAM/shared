package com.smoothstack.utopia.shared.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
public class BookingPayment {

  @OneToOne(optional = false)
  private Booking booking;

  private String stripeId;
  private Boolean refunded;
}
