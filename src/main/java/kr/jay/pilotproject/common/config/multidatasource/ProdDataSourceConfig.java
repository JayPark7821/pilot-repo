package kr.jay.pilotproject.common.config.multidatasource;

import com.atomikos.spring.AtomikosDataSourceBean;
import java.util.Properties;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ProdDataSourceConfig
 *
 * @author jaypark
 * @version 1.0.0
 * @since 1/12/24
 */

@Slf4j
@Configuration
@RequiredArgsConstructor
@DependsOn("multiTxManager")
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = {"kr.jay.pilotproject.infrastructure.persistance.prod"}
    , entityManagerFactoryRef = "prodEntityManagerFactory"
    , transactionManagerRef = "multiTxManager"
)
@EntityScan("kr.jay.pilotproject.domain.prod")
public class ProdDataSourceConfig {

    private final EdcDataSourcesConfig edcDataSourcesConfig;
    private final JpaVendorAdapter jpaVendorAdapter;

    @Bean(name = "prodDataSource")
    public DataSource prodDataSource() {
        DataSourceProperties builder = edcDataSourcesConfig.getDatasource().get("PROD");

        Properties xaProperties = new Properties();
        xaProperties.put("user", builder.getUsername());
        xaProperties.put("password", builder.getPassword());
        xaProperties.put("url", builder.getUrl());

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        dataSource.setUniqueResourceName("PROD");
        dataSource.setXaProperties(xaProperties);
        return dataSource;
    }

    @Bean(name = "prodEntityManagerFactory")
    @DependsOn("multiTxManager")
    public LocalContainerEntityManagerFactoryBean prodEntityManagerFactory() {
        log.info("==================== builderEntityManagerFactory");
        Properties properties = new Properties();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        properties.put("hibernate.physical_naming_strategy",
            CamelCaseToUnderscoresNamingStrategy.class.getName());
        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(prodDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setPackagesToScan("kr.jay.pilotproject.domain.prod");
        entityManager.setJpaProperties(properties);

        return entityManager;
    }

}
