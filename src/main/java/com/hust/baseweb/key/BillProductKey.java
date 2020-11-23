package com.hust.baseweb.key;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class BillProductKey implements Serializable {
    private Integer billId;

    private Integer productId;
}
