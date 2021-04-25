package com.smoothstack.utopia.shared.mailmodels;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rob Maes
 * Apr 19 2021
 */
@Getter
@Setter
public abstract class BaseMailModel {

  // But why mail models?
  private String basePath;

  public String getBasePath() {
    return "http://d29rs8p92481zc.cloudfront.net";
  }
}
