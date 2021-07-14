package com.bootcamp.msbootcoin.utils;

import com.bootcamp.msbootcoin.dto.BootcoinDTO;
import com.bootcamp.msbootcoin.entity.Bootcoin;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    private AppUtils() {
    }

    public static BootcoinDTO entityToDTO(Bootcoin bootcoin) {
        BootcoinDTO bootcoinDTO = new BootcoinDTO();
        BeanUtils.copyProperties(bootcoin, bootcoinDTO);
        return bootcoinDTO;
    }

    public static Bootcoin dtoToEntity(BootcoinDTO bootcoinDTO) {
        Bootcoin bootcoin = new Bootcoin();
        BeanUtils.copyProperties(bootcoinDTO, bootcoin);
        return bootcoin;
    }


}
