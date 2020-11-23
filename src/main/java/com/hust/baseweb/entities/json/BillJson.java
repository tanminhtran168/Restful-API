package com.hust.baseweb.entities.json;

import com.hust.baseweb.entities.data.Bill;
import com.hust.baseweb.entities.data.BillHasProduct;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BillJson {
    private Bill bill;
    private List<BillHasProduct> billHasProducts;
}
