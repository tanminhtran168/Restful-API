package com.hust.baseweb.controller;

import com.hust.baseweb.entities.payload.BillPayload;
import com.hust.baseweb.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("api/public/bills")
public class BillAPIController {
    private final BillService billService;

    @PostMapping
    public void upload(@RequestBody BillPayload billPayload) throws Exception {
        billService.save(billPayload);
    }
}

