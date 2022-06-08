package es.incidence.ms.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import es.incidence.ms.converter.IncidenceConverter;
import es.incidence.ms.converter.OrganizationConverter;
import tech.jhipster.config.JHipsterProperties;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
public class WebConfigurer implements ServletContextInitializer, WebMvcConfigurer  {

	private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    private final Environment env;

    private final JHipsterProperties jHipsterProperties;
    
    @Autowired
    private IncidenceConverter incidenceConverter;
    
    @Autowired
    private OrganizationConverter organizationConverter;
    
    private final String [] ALLOWED_URIS = {
    		"/api/**",
    		"/management/**",
    		"/v2/api-docs",
    		"/v3/api-docs",
    		"/swagger-resources",
    		"/swagger-ui/**",
    		"/incidenceApi/**"
        };

    public WebConfigurer(Environment env, JHipsterProperties jHipsterProperties) {
        this.env = env;
        this.jHipsterProperties = jHipsterProperties;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if (env.getActiveProfiles().length != 0) {
            log.info("Web application configuration, using profiles: {}", (Object[]) env.getActiveProfiles());
        }

        log.info("Web application fully configured");
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = jHipsterProperties.getCors();
        if (!CollectionUtils.isEmpty(config.getAllowedOrigins()) || !CollectionUtils.isEmpty(config.getAllowedOriginPatterns())) {
            log.debug("Registering CORS filter");
            for(String uri : ALLOWED_URIS ) 
            {
            	 log.debug("Registering ALLOWED URIS: uri={}", uri);
            	source.registerCorsConfiguration(uri, config);
            }
            /*
            source.registerCorsConfiguration("/api/**", config);
            source.registerCorsConfiguration("/management/**", config);
            source.registerCorsConfiguration("/v3/api-docs", config);
            source.registerCorsConfiguration("/swagger-ui/**", config);
            */
        }
        return new CorsFilter(source);
    }
    
    @Override
   	public void addFormatters(FormatterRegistry registry) {
   		// TODO Auto-generated method stub
    	
    	registry.addConverter(incidenceConverter);
    	registry.addConverter(organizationConverter);
    	
   		WebMvcConfigurer.super.addFormatters(registry);
   	}
}
