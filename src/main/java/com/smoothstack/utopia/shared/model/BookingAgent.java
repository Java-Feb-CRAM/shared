package com.smoothstack.utopia.shared.model;

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
public class BookingAgent {

  @Id
  @Column(columnDefinition = "int")
  private Long bookingId;

  @ManyToOne
  @JoinColumn(name = "agent_id", nullable = false)
  private User agent;

  @OneToOne
  @JoinColumn(name = "booking_id", referencedColumnName = "id")
  private Booking booking;
}
