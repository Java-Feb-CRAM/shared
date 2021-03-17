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
public class Airplane {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  private AirplaneType airplaneType;

  @ManyToMany
  private List<Booking> bookings;

  public Airplane(AirplaneType airplaneType) {
    this.airplaneType = airplaneType;
  }
}
