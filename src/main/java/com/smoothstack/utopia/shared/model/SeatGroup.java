package com.smoothstack.utopia.shared.model;

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
 * May 10 2021
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class SeatGroup {

  @Id
  @Column(columnDefinition = "int")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "layout_id", nullable = false)
  private SeatLayout seatLayout;

  private String name;

  private char[] columns;

  @OneToMany(mappedBy = "seatGroup")
  private Set<SeatLocation> seatLocations;
}
