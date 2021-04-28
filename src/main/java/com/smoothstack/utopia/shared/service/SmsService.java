package com.smoothstack.utopia.shared.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoothstack.utopia.shared.dto.SendSmsDto;
import org.springframework.stereotype.Service;

/**
 * @author Rob Maes
 * Apr 28 2021
 */
@Service
public class SmsService {

  private String formatNumber(String rawNumber) {
    String strippedNumber = rawNumber.replaceAll("-", "");
    return "+1001" + strippedNumber;
  }

  public void send(String recipientNumber, String message) {
    try {
      String formattedNumber = formatNumber(recipientNumber);
      SendSmsDto sendSmsDto = new SendSmsDto(formattedNumber, message);
      callLambda(sendSmsDto);
    } catch (JsonProcessingException e) {
      System.out.println(e.getMessage());
    }
  }

  private void callLambda(SendSmsDto sendSmsDto)
    throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    String payload = objectMapper.writeValueAsString(sendSmsDto);
    InvokeRequest invokeRequest = new InvokeRequest()
      .withFunctionName("utopiaSendSMS")
      .withPayload(payload);
    AWSLambda awsLambda = AWSLambdaClientBuilder
      .standard()
      .withRegion(Regions.US_EAST_1)
      .build();
    awsLambda.invoke(invokeRequest);
  }
}
