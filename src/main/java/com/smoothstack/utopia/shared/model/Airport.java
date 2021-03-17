package com.smoothstack.utopia.shared.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Airport {

  @Id
  @Column(length = 3, columnDefinition = "char")
  private String iataId;

  @Column(length = 45)
  private String city;

  @OneToMany(mappedBy = "destinationAirport")
  private Set<Route> arrivals;

  @OneToMany(mappedBy = "originAirport")
  private Set<Route> departures;
}
