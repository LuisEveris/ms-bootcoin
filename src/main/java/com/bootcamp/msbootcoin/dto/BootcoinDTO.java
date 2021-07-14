package com.bootcamp.msbootcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootcoinDTO {
    private Integer id;
    private Double buy;
    private Double sell;
}
