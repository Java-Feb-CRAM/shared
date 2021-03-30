package com.smoothstack.utopia.shared.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class User {

  @Id
  @Column(columnDefinition = "int")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnoreProperties({ "users" })
  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false)
  private UserRole userRole;

  @JsonIgnoreProperties({ "agent" })
  @OneToMany(mappedBy = "agent")
  private Set<BookingAgent> bookingAgents;

  @JsonIgnoreProperties({ "user" })
  @OneToMany(mappedBy = "user")
  private Set<BookingUser> bookingUsers;

  private String givenName;
  private String familyName;

  @Column(length = 45)
  private String username;

  @Column(columnDefinition = "TINYINT")
  private boolean active;
  
  private String email;
  
  @JsonIgnore
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
