package com.biblio.etudiant2023.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "global.params")
public class GlobalConfig {
    private int g1;
    private int g2;
}
