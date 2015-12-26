package org.thehellnet.smlgr.web.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by sardylan on 26/09/15.
 */

@Configuration
@ComponentScan(basePackages = {"v.config"})
@EnableJpaRepositories(basePackages = "org.thehellnet.smlgr.web.repository")
@EnableTransactionManagement
@PropertySource("classpath:properties/repository.properties")
public class RepositoryConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(environment.getRequiredProperty("repository.config.datasource.driver_class", String.class));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            return null;
        }

        dataSource.setJdbcUrl(environment.getRequiredProperty("repository.config.datasource.jdbc_url", String.class));
        dataSource.setUser(environment.getRequiredProperty("repository.config.datasource.user", String.class));
        dataSource.setPassword(environment.getRequiredProperty("repository.config.datasource.password", String.class));
        dataSource.setMaxPoolSize(environment.getRequiredProperty("repository.config.datasource.max_pool_size", Integer.class));
        dataSource.setMaxIdleTime(environment.getRequiredProperty("repository.config.datasource.max_idle_time", Integer.class));

        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("org.thehellnet.smlgr.web.model");
        entityManagerFactory.setDataSource(getDataSource());
        entityManagerFactory.setJpaVendorAdapter(getHibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(getHibernateProperties());
        return entityManagerFactory;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager getJpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getLocalContainerEntityManagerFactoryBean().getObject());
        return transactionManager;
    }

    @Bean(name = "hibernateJpaAutoConfiguration")
    public HibernateJpaVendorAdapter getHibernateJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("repository.config.hibernate.dialect", String.class));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("repository.config.hibernate.show_sql", Boolean.class));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("repository.config.hibernate.hbm2ddl.auto", String.class));
        properties.put("hibernate.c3p0.min_size", environment.getRequiredProperty("repository.config.hibernate.c3p0.min_size", Integer.class));
        properties.put("hibernate.c3p0.max_size", environment.getRequiredProperty("repository.config.hibernate.c3p0.max_size", Integer.class));
        properties.put("hibernate.c3p0.timeout", environment.getRequiredProperty("repository.config.hibernate.c3p0.timeout", Integer.class));
        properties.put("hibernate.c3p0.max_statements", environment.getRequiredProperty("repository.config.hibernate.c3p0.max_statements", Integer.class));
//        properties.put("jadira.usertype.autoRegisterUserTypes", true);
        return properties;
    }
}
