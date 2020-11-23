package com.hust.baseweb.service;

import com.hust.baseweb.entities.json.BillJson;
import com.hust.baseweb.entities.payload.BillPayload;

public interface BillService {
    void save(BillPayload payload) throws Exception;

    BillJson findById(Integer billId) throws Exception;
}
