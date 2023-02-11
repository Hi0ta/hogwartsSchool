package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Value("${server.port}")
    private Integer port;

    @Override
    public Integer getPort() {
        return port;
    }
}