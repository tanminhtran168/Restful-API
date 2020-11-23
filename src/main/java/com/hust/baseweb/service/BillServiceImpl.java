package com.hust.baseweb.service;

import com.hust.baseweb.entities.data.Bill;
import com.hust.baseweb.entities.data.BillHasProduct;
import com.hust.baseweb.entities.data.ProductEntity;
import com.hust.baseweb.entities.json.BillJson;
import com.hust.baseweb.entities.payload.BillPayload;
import com.hust.baseweb.entities.payload.ProductInBill;
import com.hust.baseweb.key.BillProductKey;
import com.hust.baseweb.repo.BillHasProductRepo;
import com.hust.baseweb.repo.BillRepo;
import com.hust.baseweb.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {
    
    private BillRepo billRepo;
    private ProductRepo productRepo;
    private BillHasProductRepo billHasProductRepo;


    @Override
    @Transactional
    public void save(BillPayload payload) throws Exception {
        payload.getBill().setCreated(new Date());
        payload.getBill().setDeleted(false);
        //save bill
        Bill newBill = billRepo.save(payload.getBill());
        double totalMoney = 0;

        for (ProductInBill productInBill : payload.getProductsInBill()) {
            BillHasProduct billHasProduct = new BillHasProduct();

            //set embedded id
            BillProductKey key = new BillProductKey();
            key.setBillId(newBill.getId());
            key.setProductId(productInBill.getProductId());
            billHasProduct.setId(key);

            //set amount
            billHasProduct.setAmount(productInBill.getAmount());

            //set price
            ProductEntity product = productRepo.findById(productInBill.getProductId()).get();
            billHasProduct.setPrice(product.getPrice());

            //set product
            billHasProduct.setProduct(product);

            //update total money
            totalMoney += product.getPrice() * productInBill.getAmount();

            billHasProductRepo.save(billHasProduct);
        }
        newBill.setTotalMoney(totalMoney);
        billRepo.save(newBill);
    }

    @Override
    public BillJson findById(Integer billId) throws Exception {
        //get bill
        Bill bill = billRepo.findByIdAndDeletedFalse(billId);
        //get billHasProduct
        if (bill != null) {
            List<BillHasProduct> billHasProducts = billHasProductRepo.findById_BillId(billId);
            return BillJson.builder().bill(bill).billHasProducts(billHasProducts).build();
        } else throw new Exception("bill not found!");
    }
}
