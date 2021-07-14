package com.bootcamp.msbootcoin.web;

import com.bootcamp.msbootcoin.dto.BootcoinDTO;
import com.bootcamp.msbootcoin.service.BootcoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@RequestMapping("/bootcoin")
public class BootcoinController {

    @Autowired
    private BootcoinService service;

    @GetMapping
    public Mono<String> hello() {
        log.info("hello");
        return Mono.just("hello");
    }

    @PatchMapping
    public Mono<ResponseEntity<BootcoinDTO>> setBootcoinPrice(@RequestBody BootcoinDTO bootcoinDTO) {
        log.info("patching the bootcoin [{}]", bootcoinDTO);
        return service.patchBootcoin(bootcoinDTO)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.error(new HttpClientErrorException(HttpStatus.BAD_REQUEST)));
    }

}
