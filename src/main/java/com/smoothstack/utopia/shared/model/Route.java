package com.smoothstack.utopia.shared.model;

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
public class Route {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  private Airport originAirport;

  @ManyToOne(optional = false)
  private Airport destinationAirport;

  public Route(Airport originAirport, Airport destinationAirport) {
    this.originAirport = originAirport;
    this.destinationAirport = destinationAirport;
  }
}
