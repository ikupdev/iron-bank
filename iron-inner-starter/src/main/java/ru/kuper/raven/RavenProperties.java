package ru.kuper.raven;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author Ilya V. Kupriyanov
 * @version 08.03.2022
 */
@ConfigurationProperties("raven")
@Data
public class RavenProperties {
    List<String> where;
}
