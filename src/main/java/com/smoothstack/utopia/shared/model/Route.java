package com.smoothstack.utopia.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Route {

  @Id
  @Column(columnDefinition = "int")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnoreProperties({ "arrivals", "departures" })
  @ManyToOne
  @JoinColumn(name = "origin_id", nullable = false)
  private Airport originAirport;

  @JsonIgnoreProperties({ "arrivals", "departures" })
  @ManyToOne
  @JoinColumn(name = "destination_id", nullable = false)
  private Airport destinationAirport;

  @JsonIgnoreProperties({ "route" })
  @OneToMany(mappedBy = "route")
  private Set<Flight> flights;

  public Route(Airport originAirport, Airport destinationAirport) {
    this.originAirport = originAirport;
    this.destinationAirport = destinationAirport;
  }
}
