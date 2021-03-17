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
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  private UserRole userRole;

  private String givenName;
  private String familyName;

  @Column(length = 45)
  private String username;

  private String email;
  private String password;

  @Column(length = 45)
  private String phone;

  public User(
    UserRole userRole,
    String givenName,
    String familyName,
    String username,
    String email,
    String password,
    String phone
  ) {
    this.userRole = userRole;
    this.givenName = givenName;
    this.familyName = familyName;
    this.username = username;
    this.email = email;
    this.password = password;
    this.phone = phone;
  }
}
