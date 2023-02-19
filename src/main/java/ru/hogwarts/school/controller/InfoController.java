package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.InfoServiceImpl;

@RestController
@RequestMapping("info/")
public class InfoController {

    private final InfoServiceImpl infoServiceImpl;

    public InfoController(InfoServiceImpl infoServiceImpl) {
        this.infoServiceImpl = infoServiceImpl;
    }

    @GetMapping("get-port")
    public ResponseEntity<Integer> getPort() {
        return ResponseEntity.ok(infoServiceImpl.getPort());
    }

    @GetMapping("fast-int")
    public ResponseEntity<Integer> getFastInteger() {
        return ResponseEntity.ok(infoServiceImpl.getFastInteger());
    }
}
