package com.hust.baseweb.entities.data;

import com.hust.baseweb.key.BillProductKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bill_has_product", schema = "backend_class")
public class BillHasProduct {
    @EmbeddedId
    private BillProductKey id;
    private int amount;
    private double price;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

}
