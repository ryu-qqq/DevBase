package com.ryuqq.devbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackages = {
        "com.ryuqq.devbase.domain",
        "com.ryuqq.devbase.api",
        "com.ryuqq.devbase.batch",
        "com.ryuqq.devbase.support.utils",
        "com.ryuqq.devbase.support.external.core",
        "com.ryuqq.devbase.storage.db.core",
        "com.ryuqq.devbase.storage.cache.core",
})

public class DevBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevBaseApplication.class, args);
    }

}
