package com.smoothstack.utopia.shared.config;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * @author Rob Maes
 * Apr 19 2021
 */
@org.springframework.context.annotation.Configuration
public class FreeMarkerConfig {

  @Bean
  public FreeMarkerConfigurer freemarkerClassLoaderConfig() {
    Configuration configuration = new Configuration(
      Configuration.VERSION_2_3_27
    );
    TemplateLoader templateLoader = new ClassTemplateLoader(
      this.getClass(),
      "/mail-templates"
    );
    configuration.setTemplateLoader(templateLoader);
    FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
    freeMarkerConfigurer.setConfiguration(configuration);
    return freeMarkerConfigurer;
  }
}
