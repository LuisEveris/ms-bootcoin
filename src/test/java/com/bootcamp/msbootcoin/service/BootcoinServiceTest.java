package com.bootcamp.msbootcoin.service;

import com.bootcamp.msbootcoin.dto.BootcoinDTO;
import com.bootcamp.msbootcoin.entity.Bootcoin;
import com.bootcamp.msbootcoin.repository.BootcoinRepository;
import com.bootcamp.msbootcoin.utils.AppUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class BootcoinServiceTest {

    @MockBean
    BootcoinRepository repository;

    @InjectMocks
    private BootcoinService service;

    @Test
    void patchBootcoin() {
        BootcoinDTO bootcoinDTO = new BootcoinDTO(1, 3.0, 4.0);

        Mockito.when(repository.findById(bootcoinDTO.getId()))
                .thenReturn(Mono.just(bootcoinDTO).map(AppUtils::dtoToEntity));

        Mockito.when(repository.save(AppUtils.dtoToEntity(bootcoinDTO)))
                .thenReturn(Mono.just(bootcoinDTO).map(AppUtils::dtoToEntity));

        Mono<BootcoinDTO> bootcoinDTOMono = service.patchBootcoin(bootcoinDTO);

        StepVerifier.create(bootcoinDTOMono)
                .expectNext(bootcoinDTO).verifyComplete();
    }
}