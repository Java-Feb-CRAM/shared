package com.smoothstack.utopia.shared.mailmodels;

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
public class AlertMailModel extends BaseMailModel {

  private String name;
}
