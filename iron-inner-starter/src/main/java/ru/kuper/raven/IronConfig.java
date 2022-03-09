package ru.kuper.raven;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ilya V. Kupriyanov
 * @version 07.03.2022
 */
@Configuration
@EnableConfigurationProperties(RavenProperties.class)
public class IronConfig {

    @Bean
    @ConditionOnProduction
    @ConditionalOnRaven
    @ConditionalOnMissingBean
    public RavenListener ravenListener(RavenProperties rp) {
        return new RavenListener(rp);
    }

}
