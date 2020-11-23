package com.hust.baseweb.controller;

import com.hust.baseweb.entities.data.BillHasProduct;
import com.hust.baseweb.repo.BillHasProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/public/bill-has-products")
public class BillHasProductAPIController {

    private final BillHasProductRepo repo;

}
