package com.smoothstack.utopia.shared.model;

import java.util.List;
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
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Boolean isActive;
  private String confirmationCode;
  // TODO: fixme
  private BookingGuest bookingGuest;
  private BookingUser bookingUser;
  private BookingAgent bookingAgent;

  @ManyToMany
  private List<Flight> flights;
}
