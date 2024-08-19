package com.bookStoreManagementSystemApp.controller;

import com.bookStoreManagementSystemApp.entity.Bill;
import com.bookStoreManagementSystemApp.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        List<Bill> bills = billService.getAllBills();
        return ResponseEntity.ok(bills);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        Bill bill = billService.getBillById(id);
        if (bill == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bill);
    }

    
    @PostMapping
    public ResponseEntity<Bill> createBill(@Validated @RequestBody Bill bill) {
        Bill createdBill = billService.saveOrUpdateBill(bill);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBill);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @Validated @RequestBody Bill billDetails) {
        Bill updatedBill = billService.updateBill(id, billDetails);
        if (updatedBill == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBill);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.noContent().build();
    }
}
