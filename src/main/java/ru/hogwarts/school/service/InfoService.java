package ru.hogwarts.school.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class InfoService {
//    @Value("${ru-hogwarts-school-service.url}")
//    private String urlStr;
//
//    @Value("${ru-hogwarts-school-service.api-key}")
//    private String apiKey;

    URL url = new URL("http://localhost:8080");

    public InfoService() throws MalformedURLException {}

    public Integer getPort(){return url.getPort();}

}
