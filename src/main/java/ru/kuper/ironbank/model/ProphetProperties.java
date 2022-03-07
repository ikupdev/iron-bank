package ru.kuper.ironbank.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @author Ilya V. Kupriyanov
 * @version 06.03.2022
 */
@Validated
@Getter
@Setter
@Configuration
@ConfigurationProperties("ironbank")
public class ProphetProperties {
        @NotNull
        List<String> returning;
}
