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
import javax.persistence.Transient;
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
public class AirplaneType {

  @Id
  @Column(columnDefinition = "int")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Transient
  private Integer maxCapacity;

  public Integer getMaxCapacity() {
    return this.getSeatLayout()
      .getSeatGroups()
      .stream()
      .mapToInt(group -> group.getSeatLocations().size())
      .sum();
  }

  @JsonIgnoreProperties({ "airplaneType" })
  @OneToMany(mappedBy = "airplaneType")
  private Set<Airplane> airplanes;

  @JsonIgnoreProperties({ "airplaneTypes" })
  @ManyToOne
  @JoinColumn(name = "layout_id", nullable = false)
  private SeatLayout seatLayout;
}
