package com.hust.baseweb.entities.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInBill {
    private Integer productId;
    private int amount;
}
