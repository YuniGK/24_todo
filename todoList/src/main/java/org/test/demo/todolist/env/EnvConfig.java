package org.test.demo.todolist.env;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:properties/env.properties")
public class EnvConfig {
}
