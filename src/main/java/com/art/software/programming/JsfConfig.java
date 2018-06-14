package com.art.software.programming;

import com.sun.faces.config.FacesInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.HashSet;
import java.util.Set;
/**
 * @author Vass Cisse
 * This configuration is generally done in faces-config.xml
 * but we can do it programmatically
 *
 * We still need faces-config.xml though (in webapp\WEB-INF)
 * for the SpringBeanFacesELResolver
 */
@Configuration
public class JsfConfig {

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean servletRegistrationBean = new JsfServletRegistrationBean();
        servletRegistrationBean.addUrlMappings("Faces Servlet", "/faces/*");
        servletRegistrationBean.addUrlMappings("Faces Servlet", "*.jsf");
        servletRegistrationBean.addUrlMappings("Faces Servlet", "*.faces");
        servletRegistrationBean.addUrlMappings("Faces Servlet", "*.xhtml");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    private class JsfServletRegistrationBean extends ServletRegistrationBean {

        public JsfServletRegistrationBean() {
            super();
        }

        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {
            Set<Class<?>> cla = new HashSet<Class<?>>();
            cla.add(JsfConfig.class);

            FacesInitializer facesInitializer = new FacesInitializer();
            facesInitializer.onStartup(cla, servletContext);
        }
    }
}
