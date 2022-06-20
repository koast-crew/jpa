package net.koast.jpa.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Map;

import static java.util.Objects.requireNonNull;
import static org.hibernate.cfg.AvailableSettings.*;

/**
 *
 * @author : gt1000
 * @date   : 2021-10-29 오후 5:19
 */
@Slf4j
@RequiredArgsConstructor
@PropertySource({"classpath:application.yml"})
@Configuration
public class JpaConfig {

    private final Environment env;

//    @Bean("jasyptStringEncryptor")
//    public StringEncryptor stringEncryptor() {
//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
////        config.setPassword(environment.getProperty("jasypt.encryptor.password", "MyPassword")); #Change your password
//        config.setPassword(KeyManager.getInitKey());
//        config.setAlgorithm("PBEWithSHA1AndDESede");
//        config.setKeyObtentionIterations("1000");
//        config.setPoolSize("1");
////        config.setProvider(new BouncyCastleProvider());
////        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//        config.setStringOutputType("base64");
//        encryptor.setConfig(config);
//        return encryptor;
//    }

    @Bean
    public EntityManagerFactory entityManagerFactory(HikariDataSource dataSource) {
        log.info("------------- url = {}", dataSource.getJdbcUrl());
        log.info("------------- username = {}", dataSource.getUsername());
        log.info("------------- password = {}", dataSource.getPassword());

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan("net.koast.jpa");
        // spring boot는 아래가 필요 없지 싶은데...
//        entityManagerFactoryBean.setPersistenceUnitName("MariaUnit");
//        entityManagerFactoryBean.setPersistenceXmlLocation("classpath:/META-INF/persistence.xml");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaPropertyMap(getJpaProperties());
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

    private Map<String, String> getJpaProperties() {
        String jpaPropertyPrefix = "spring.jpa.properties.";
        return Map.of(
                PHYSICAL_NAMING_STRATEGY, SpringPhysicalNamingStrategy.class.getName(),
                HBM2DDL_AUTO, requireNonNull(env.getProperty(jpaPropertyPrefix + HBM2DDL_AUTO)),
                SHOW_SQL, requireNonNull(env.getProperty(jpaPropertyPrefix + SHOW_SQL)),
                FORMAT_SQL, requireNonNull(env.getProperty(jpaPropertyPrefix + FORMAT_SQL)),
                USE_SQL_COMMENTS, requireNonNull(env.getProperty(jpaPropertyPrefix + USE_SQL_COMMENTS)),
                DIALECT, requireNonNull(env.getProperty(jpaPropertyPrefix + DIALECT))
        );
    }
}