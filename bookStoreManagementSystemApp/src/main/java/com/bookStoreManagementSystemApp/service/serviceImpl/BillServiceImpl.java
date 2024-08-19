package com.bookStoreManagementSystemApp.service.serviceImpl;


import com.bookStoreManagementSystemApp.dto.BillDTO;
import com.bookStoreManagementSystemApp.entity.Bill;
import com.bookStoreManagementSystemApp.repository.BillRepository;
import com.bookStoreManagementSystemApp.service.BillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BillDTO createBill(BillDTO billDTO) {
        Bill bill = modelMapper.map(billDTO, Bill.class);
        Bill savedBill = billRepository.save(bill);
        return modelMapper.map(savedBill, BillDTO.class);
    }

    @Override
    public BillDTO getBillById(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id " + id));
        return modelMapper.map(bill, BillDTO.class);
    }

    @Override
    public List<BillDTO> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        return bills.stream()
                .map(bill -> modelMapper.map(bill, BillDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BillDTO updateBill(Long id, BillDTO billDTO) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id " + id));

        bill.setCustomer(billDTO.getCustomer());
        bill.setBooks(billDTO.getBooks());
        bill.setTotalAmount(billDTO.getTotalAmount());
        bill.setBillDate(billDTO.getBillDate());

        Bill updatedBill = billRepository.save(bill);
        return modelMapper.map(updatedBill, BillDTO.class);
    }

    @Override
    public void deleteBill(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id " + id));
        billRepository.delete(bill);
    }
}
