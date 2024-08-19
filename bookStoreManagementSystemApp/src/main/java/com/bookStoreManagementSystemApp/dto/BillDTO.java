package com.bookStoreManagementSystemApp.dto;

/*(Data Transfer Object) that you can use in your Book Store Management System application. 
DTOs are typically used to transfer data between different layers of an application, such as
between the controller and service layers, and to customize the data format for specific operations.
*/

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BillDTO {

    private Long id;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotNull(message = "Total amount cannot be null")
    private BigDecimal totalAmount;

    @NotNull(message = "Bill date cannot be null")
    private LocalDateTime billDate;

    // Getters and setters
    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }
}
