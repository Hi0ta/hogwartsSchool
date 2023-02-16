package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class InfoServiceImpl implements InfoService {
    @Value("${server.port}")
    private Integer port;

    @Override
    public Integer getPort() {
        return port;
    }

    @Override
    public Integer getFastInteger() {
       // int sum = Stream.iterate(1, a -> a +1) .limit(1_000_000).mapToInt(Integer::intValue).sum();
        int sum = 1;
        for (int b = 2; b < 1_000_001; b++){
          //  int a = 1;
            sum = sum + b;
        }
        return sum;
    }


}