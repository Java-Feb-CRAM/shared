package com.smoothstack.utopia.shared.mailmodels;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rob Maes
 * Apr 20 2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillingMailModel extends BaseMailModel {

  private String givenName;
  private String familyName;
  private String confirmationCode;
  private String date = LocalDate
    .now()
    .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
  private Map<String, String> items = new HashMap<>();
  private String totalAmount;
  private String year = "" + LocalDate.now().getYear();
}
