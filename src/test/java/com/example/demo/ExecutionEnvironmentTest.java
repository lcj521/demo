package com.example.demo;

import com.example.demo.utils.User;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;

public class ExecutionEnvironmentTest {

    public static void main(String[] args) {

//        ExecutionEnvironment environment =  ExecutionEnvironment.getExecutionEnvironment();
//        DataSource<String> input  = environment.readTextFile("/Users/edz/Downloads/WS_APP_PAY_SDK_BASE_2.0/readme.txt");
//        input.flatMap(FlatMapFunction<>)

        User user = new User();
        user.setGender("男");




    }
}
