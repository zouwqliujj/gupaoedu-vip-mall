package com.gupaoedu.vip.mall;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableElasticsearchRepositories(basePackages = "com.gupaoedu.vip.mall.search.mapper")
public class MallSearchApplication {
}
