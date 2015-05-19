package org.thehellnet.smlgr.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by sardylan on 14/05/15.
 */

@Configuration
@ImportResource("classpath:application.xml")
@PropertySource("classpath:properties/database.properties")
@ComponentScan(basePackages = "org.thehellnet.smlgr.web")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter implements WebApplicationInitializer {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("org.thehellnet.smlgr.web.config");
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    public class JsonViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            view.setPrettyPrint(true);
            return view;
        }
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
        OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor = new OpenEntityManagerInViewInterceptor();
        openEntityManagerInViewInterceptor.setEntityManagerFactory(entityManagerFactory);
        return openEntityManagerInViewInterceptor;
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/pages/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

        resolvers.add(new JsonViewResolver());

        resolvers.add(jspViewResolver());

        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setViewResolvers(resolvers);
        resolver.setContentNegotiationManager(manager);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/src/main/resources/**").addResourceLocations("/src/main/resources/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor());
    }
}
