package com.smoothstack.utopia.shared.service;

import com.smoothstack.utopia.shared.mailmodels.SampleMailModel;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
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

  public void test() {
    SampleMailModel model = new SampleMailModel();
    model.setText("Text");
    model.setSenderName("John Smith");
    model.setRecipientName("Joe Bob");
    try {
      Template freemarkerTemplate = freemarkerConfigurer
        .getConfiguration()
        .getTemplate("sample.ftl");
      String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(
        freemarkerTemplate,
        model
      );
      System.out.println(htmlBody);
    } catch (IOException | TemplateException e) {
      System.out.println(e.getMessage());
    }
  }
}
