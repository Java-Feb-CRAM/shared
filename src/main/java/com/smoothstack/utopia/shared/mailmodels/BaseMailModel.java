package com.smoothstack.utopia.shared.mailmodels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Rob Maes
 * Apr 19 2021
 */
@Getter
@Setter
public abstract class BaseMailModel {

  // But why mail models?
  @Value("${basePath}")
  private String basePath;
}
