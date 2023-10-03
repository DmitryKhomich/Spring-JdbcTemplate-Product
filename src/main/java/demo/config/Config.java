package demo.config;
import demo.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@ComponentScan("demo")
public class Config {
    @Bean
     DataSource getDataSource(){
         DriverManagerDataSource manager = new DriverManagerDataSource();
         manager.setDriverClassName(Constants.DRIVER);
         manager.setUrl(Constants.URL);
         manager.setUsername(Constants.DB_USER);
         manager.setPassword(Constants.DB_PASS);
         return manager;
    }
}
