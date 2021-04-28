package com.smoothstack.utopia.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rob Maes
 * Apr 28 2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendSmsDto {

  private String sendToNumber;
  private String message;
}
