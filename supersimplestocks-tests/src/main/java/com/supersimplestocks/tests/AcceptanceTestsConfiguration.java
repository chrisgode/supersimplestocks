package com.supersimplestocks.tests;

import com.supersimplestocks.domain.DomainConfiguration;
import com.supersimplestocks.infra.InfrastructureConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DomainConfiguration.class, InfrastructureConfiguration.class})
@ComponentScan
public class AcceptanceTestsConfiguration {
}
