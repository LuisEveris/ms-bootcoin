package com.bootcamp.msbootcoin.service;

import com.bootcamp.msbootcoin.dto.BootcoinDTO;
import com.bootcamp.msbootcoin.repository.BootcoinRepository;
import com.bootcamp.msbootcoin.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class BootcoinService {

    @Autowired
    private BootcoinRepository repository;


    public Mono<BootcoinDTO> patchBootcoin(BootcoinDTO bootcoinDTO) {
        log.debug("patchBootcoin() from bootcoin service, [{}]", bootcoinDTO);

        return repository.findById(bootcoinDTO.getId())
                .flatMap(b -> Mono.just(bootcoinDTO).map(AppUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(bootcoinDTO.getId())))
                .flatMap(repository::save)
                .map(AppUtils::entityToDTO);

    }
}
