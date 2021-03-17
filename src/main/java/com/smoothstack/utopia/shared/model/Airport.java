package com.smoothstack.utopia.shared.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Airport {

  @Id
  @Column(columnDefinition = "CHAR(3)")
  private String iataId;

  @Column(length = 45)
  private String city;
}
