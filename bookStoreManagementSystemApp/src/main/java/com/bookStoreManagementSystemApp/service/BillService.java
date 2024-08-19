package com.bookStoreManagementSystemApp.service;

import com.bookStoreManagementSystemApp.dto.BillDTO;
import com.bookStoreManagementSystemApp.entity.Bill;

import java.util.List;

public interface BillService {
    BillDTO createBill(BillDTO billDTO);
    BillDTO getBillById(Long id);
    List<BillDTO> getAllBills();
    BillDTO updateBill(Long id, BillDTO billDTO);
    void deleteBill(Long id);
}
