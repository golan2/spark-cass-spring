package org.yy.sparkdemo.job;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.yy.sparkdemo.model.WordCount;
import scala.Serializable;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class MyStocksJob implements Serializable {

    private static final long serialVersionUID = -4758215165527277913L;

    public List<WordCount> execute(JavaSparkContext sparkContext) {
       return sparkContext.textFile("D:\\DATA\\Desktop\\yy.txt")
                 .flatMap(s -> Arrays.asList(s.split(" ")).iterator()              )
               .mapToPair(word -> new Tuple2<>(word, 1))
               .reduceByKey((a, b) -> a + b)
               .map(tuple -> new WordCount(tuple._1, tuple._2))
               .sortBy(new SortByCount(), false, 2)
               .collect();
    }

    private class SortByCount implements Serializable, Function<WordCount, Integer> {

        private static final long serialVersionUID = 5347033859550280385L;

        @Override
        public Integer call(WordCount v1) throws Exception {
            return v1.getCount();
        }
    }


}
