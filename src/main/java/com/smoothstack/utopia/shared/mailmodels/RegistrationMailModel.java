package com.smoothstack.utopia.shared.mailmodels;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
public class RegistrationMailModel extends BaseMailModel {

  private String givenName;
  private String familyName;
  private String emailValidationToken;
  private String date = LocalDate
    .now()
    .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
  private String year = "" + LocalDate.now().getYear();
  private String url;

  public String getUrl() {
    return (
      getBasePath() + "/validation?validationToken=" + getEmailValidationToken()
    );
  }
}
