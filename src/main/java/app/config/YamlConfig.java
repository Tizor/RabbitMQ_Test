package app.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "hibernate.properties")
@PropertySource(value = "classpath:application.yaml")
public class YamlConfig {

    private String dialect;
    private String showSQL;
    private String formatSQL;
    private String basePackage;
}
