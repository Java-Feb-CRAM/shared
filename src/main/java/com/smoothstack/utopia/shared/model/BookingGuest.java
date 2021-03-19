package com.smoothstack.utopia.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class BookingGuest {

  @Id
  @Column(columnDefinition = "int")
  private Long bookingId;

  private String contactEmail;

  @Column(length = 45)
  private String contactPhone;

  @JsonIgnoreProperties({ "bookingGuest" })
  @OneToOne
  @JoinColumn(name = "booking_id", referencedColumnName = "id")
  private Booking booking;
}
