package kgfsl.stalk.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import kgfsl.genie.core.utility.ApplicationStartUpFactory;

@Configuration
@RefreshScope
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "kgfsl" })
public class JPAConfig {

	@Bean
	public Validator getValidator() {
		return new LocalValidatorFactoryBean();
	}

	@Value("${db.url}")
	String dbUrl;

	@Value("${db.driverClassName}")
	String dbDriverClassName;

	@Value("${db.userName}")
	String dbUserName;

	@Value("${db.password}")
	String dbPassword;

	@Value("${db.databaseType}")
	String dbDatabaseType;

	@Bean
	@RefreshScope
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbDriverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}

	@Bean
	public Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<>();
		props.put("hibernate.dialect", ApplicationStartUpFactory.getDialect(dbDatabaseType));
		props.put("javax.persistence.validation.mode", "none");
		return props;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(ApplicationStartUpFactory.getJPAVendor(dbDatabaseType));
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(this.dataSource());
		lef.setJpaPropertyMap(this.jpaProperties());
		lef.setJpaVendorAdapter(this.jpaVendorAdapter());
		String entityPackages = "kgfsl.stalk.entity,kgfsl.genie.fileupload,kgfsl.genie.makerchecker";
		lef.setPackagesToScan(entityPackages.split(","));
		return lef;
	}
}
