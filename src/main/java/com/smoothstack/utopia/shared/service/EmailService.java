package com.smoothstack.utopia.shared.service;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoothstack.utopia.shared.dto.SendEmailDto;
import com.smoothstack.utopia.shared.mailmodels.BaseMailModel;
import com.smoothstack.utopia.shared.mailmodels.SampleMailModel;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * @author Rob Maes
 * Apr 19 2021
 */
@Service
public class EmailService {

  private final FreeMarkerConfigurer freemarkerConfigurer;

  @Autowired
  public EmailService(FreeMarkerConfigurer freemarkerConfigurer) {
    this.freemarkerConfigurer = freemarkerConfigurer;
  }

  public enum MailTemplate {
    SAMPLE("sample.ftl"),
    BOOKING_CONFIRMATION("booking-confirmation.ftl");

    public final String path;

    MailTemplate(String path) {
      this.path = path;
    }
  }

  private String processTemplate(
    MailTemplate template,
    BaseMailModel templateModel
  ) throws IOException, TemplateException {
    Template freemarkerTemplate = freemarkerConfigurer
      .getConfiguration()
      .getTemplate(template.path);
    return FreeMarkerTemplateUtils.processTemplateIntoString(
      freemarkerTemplate,
      templateModel
    );
  }

  public void send(
    String recipient,
    MailTemplate template,
    BaseMailModel templateModel
  ) {
    try {
      String htmlBody = processTemplate(template, templateModel);
      SendEmailDto sendEmailDto = new SendEmailDto(
        recipient,
        "subject",
        htmlBody
      );
      callLambda(sendEmailDto);
    } catch (IOException | TemplateException e) {
      System.out.println(e.getMessage());
    }
  }

  //TODO make this async
  private void callLambda(SendEmailDto sendEmailDto)
    throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    String payload = objectMapper.writeValueAsString(sendEmailDto);
    InvokeRequest invokeRequest = new InvokeRequest()
      .withFunctionName("utopiaSendEmail2")
      .withPayload(payload);
    InvokeResult invokeResult = null;
    AWSLambda awsLambda = AWSLambdaClientBuilder
      .standard()
      .withCredentials(new ProfileCredentialsProvider())
      .withRegion(Regions.US_EAST_1)
      .build();
    invokeResult = awsLambda.invoke(invokeRequest);
    String ans = new String(
      invokeResult.getPayload().array(),
      StandardCharsets.UTF_8
    );
    System.out.println(ans);
    System.out.println(invokeResult.getStatusCode());
  }
}
