package com.bootcamp.msbootcoin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("bootcoin")
public class Bootcoin {
    @Id
    private Integer id;
    private Double buy;
    private Double sell;
}
