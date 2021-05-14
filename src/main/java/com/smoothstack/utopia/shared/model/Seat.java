package com.smoothstack.utopia.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * May 14 2021
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Seat {

  @Id
  @Column(columnDefinition = "int")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnoreProperties({ "seats" })
  @ManyToOne
  @JoinColumn(name = "flight_id", nullable = false)
  private Flight flight;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonIgnoreProperties({ "seat" })
  @OneToOne(optional = true)
  @JoinColumn(name = "passenger_id", referencedColumnName = "id")
  private Passenger passenger;

  private Integer row;
  private Character col;
}
