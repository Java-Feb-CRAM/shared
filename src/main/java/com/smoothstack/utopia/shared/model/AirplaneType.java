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
public class AirplaneType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer maxCapacity;

  public AirplaneType(Integer maxCapacity) {
    this.maxCapacity = maxCapacity;
  }
}
