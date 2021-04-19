package com.smoothstack.utopia.shared.mailmodels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rob Maes
 * Apr 19 2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SampleMailModel extends BaseMailModel {

  private String recipientName;
  private String text;
  private String senderName;
}
