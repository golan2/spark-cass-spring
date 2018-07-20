package org.yy.sparkspring.controller;

import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yy.sparkdemo.job.MyStocksJob;
import org.yy.sparkdemo.model.WordCount;

import java.util.List;

@RestController
@Component
public class SparkQueriesController {

    private JavaSparkContext javaSparkContext;

    public SparkQueriesController(JavaSparkContext javaSparkContext) {
        this.javaSparkContext = javaSparkContext;
    }

    @RequestMapping(value="/api/stocks", method= RequestMethod.GET, produces="application/json")
    @ResponseBody
    List<WordCount> query () {
        return (new MyStocksJob()).execute(javaSparkContext);
    }
}
