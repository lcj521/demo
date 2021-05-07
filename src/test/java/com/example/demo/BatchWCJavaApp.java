package com.example.demo;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * 批处理
 */
public class BatchWCJavaApp {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
       DataSource<String> fileText =  env.readTextFile("/Users/edz/Downloads/flinkBatch.txt");
            fileText.flatMap(new FlatMapFunction<String, Tuple2<String,Integer>>() {
                @Override
                public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                   String[] tokens =  s.toLowerCase().split("\t");
                    for (String token :tokens){
                        if (token.length()>0){
                            collector.collect(new Tuple2<String,Integer>(s,1));
                        }
                    }
                }
            }).groupBy(0).sum(1).print();






    }
}
