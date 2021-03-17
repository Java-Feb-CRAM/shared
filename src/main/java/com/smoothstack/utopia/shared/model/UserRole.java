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
public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 45)
  private String name;

  public UserRole(String name) {
    this.name = name;
  }
}
