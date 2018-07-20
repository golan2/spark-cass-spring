package org.yy.sparkspring.bootstrap;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.yy.sparkspring.Root;

/**
 * Created by Files on 5/12/2018.
 */
@Configuration
@ComponentScan(basePackageClasses = Root.class)
public class SpringConfig {

    @Value("${spark.master}")
    String sparkMasterUrl;

    @Bean
    public JavaSparkContext javaSparkContext() {
//        log.info("Connecting to spark with master Url: {}, and cassandra host: {}",
//                sparkMasterUrl, cassandraHost);

        SparkConf conf = new SparkConf(true)
//                .set("spark.cassandra.connection.host", cassandraHost)
                .set("spark.submit.deployMode", "client");

        JavaSparkContext context = new JavaSparkContext(
                sparkMasterUrl,
                "SparkDemo",
                conf
        );
        context.addJar("D:\\y_ws\\spark-cass-spring\\spark-shared\\target\\spark-shared-1.0-SNAPSHOT.jar");

//        log.debug("SparkContext created");
        return context;
    }

}
