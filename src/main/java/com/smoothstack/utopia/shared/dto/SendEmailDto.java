package com.smoothstack.utopia.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rob Maes
 * Apr 19 2021
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SendEmailDto {

  private String sendTo;
  private String subject;
  private String body;
}
