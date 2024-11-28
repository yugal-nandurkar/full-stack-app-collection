package microteam.root.HybridApp.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.task.TaskExecutor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.sql.DataSource;
import java.util.concurrent.Executor;

@Configuration
public class MigrationConfig {

    private static final Logger logger = LoggerFactory.getLogger(MigrationConfig.class);

    @Bean
    public MigrationService migrationService() {
        return new MigrationService();
    }

    @Bean
    public DbSeeder dbSeeder() {
        return new DbSeeder();
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        MigrationService migrationService = event.getApplicationContext().getBean(MigrationService.class);
        DbSeeder dbSeeder = event.getApplicationContext().getBean(DbSeeder.class);

        try {
            migrationService.migrateDatabase();
            dbSeeder.seedDatabase();
        } catch (Exception e) {
            logger.error("Database migration or seeding failed", e);
            throw new RuntimeException("Migration and seeding error", e);
        }
    }
}

@Component
class MigrationService {

    private static final Logger logger = LoggerFactory.getLogger(MigrationService.class);

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void migrateDatabase() {
        // Simulate a migration (Hibernate's auto-update can be leveraged, or Flyway/Liquibase can be integrated here)
        logger.info("Running database migrations...");
        // Implement actual migration logic here
        logger.info("Database migrations completed successfully.");
    }
}

@Component
class DbSeeder {

    private static final Logger logger = LoggerFactory.getLogger(DbSeeder.class);

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    public void seedDatabase() {
        logger.info("Seeding database with initial data...");
        // Perform database seeding operations
        // For example: Insert default values into tables
        logger.info("Database seeding completed successfully.");
    }
}

