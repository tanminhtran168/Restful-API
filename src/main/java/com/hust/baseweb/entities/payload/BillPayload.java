package com.hust.baseweb.entities.payload;

import com.hust.baseweb.entities.data.Bill;
import lombok.Data;

import java.util.List;

@Data
public class BillPayload {
    private Bill bill;
    private List<ProductInBill> productsInBill;
}
