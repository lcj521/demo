package com.example.demo;

import com.example.demo.utils.User;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;
import org.assertj.core.groups.Tuple;

import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * 使用Java API来开发Flink的实时处理应用程序
 * wc统计的数据源自socket
 */
public class StreamingWcJavaApp {


    public static void main(String[] args) throws  Exception{

        int port ;
        try {
           ParameterTool parameterTool =  ParameterTool.fromArgs(args);
            port = parameterTool.getInt("port");
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("端口没有设置，使用默认端口9999");
            port = 9999;
        }


//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        DataStreamSource<String> text = env.socketTextStream("42.192.51.175",port);
//        text.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
//            @Override
//            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
//                String[] tokens = s.toLowerCase().split(",");
//                for (String token : tokens){
//                    collector.collect(new Tuple2<String,Integer>(token,1));
//                }
//            }
//        }).keyBy(0).timeWindow(Time.seconds(5)).sum(1).print();
//        env.execute("111111111111");
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
       DataStreamSource<User> list = env.fromCollection(Arrays.asList(
               new User("1","张三","23","男","2020-11-12"),
               new User("2","李四","22","女","2020-12-12"),
               new User("3","王五","23","女","2020-03-12"),
               new User("4","赵六","45","女","2020-02-12")));

//        SingleOutputStreamOperator<Object> result = list.map(new MapFunction<User, Object>() {
//            @Override
//            public Object map(User value) throws Exception {
//                int age = Integer.parseInt(value.getAge())*2;
//                return new User(value.getId(),value.getName(),String.valueOf(age),value.getGender(),value.getCreate_date());
//            }
//        });

//       SingleOutputStreamOperator<User> result =  list.filter(new FilterFunction<User>() {
//            @Override
//            public boolean filter(User value) throws Exception {
//                return value.getAge().contains("23");
//            }
//        });
//
//
//        System.out.println(result.toString());

        list.print();
        env.execute();

    }

}
