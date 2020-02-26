package com.github.fasterthanlight.gachaxgacha.config;

import com.github.fasterthanlight.gachaxgacha.util.SiteMappings;
import com.github.fasterthanlight.gachaxgacha.util.ViewNames;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configures the web application.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * Adds default views.
     *
     * @param registry the registry to alter
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(SiteMappings.HOME).setViewName(ViewNames.HOME);
        registry.addViewController(SiteMappings.TEST).setViewName(ViewNames.TEST);
    }
}
