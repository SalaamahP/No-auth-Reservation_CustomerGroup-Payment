package com.restaurant.rms.models.DTO;

//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotEmpty;
//import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class ExpenseDTO {
//    @NotEmpty(message = "The Expense name is required")
    private String expenseName;

//    @NotEmpty(message = "The Expense Date is required")
    private LocalDateTime expenseDate;

//    @Min(0)
    private Double expenseAmount;

//    private MultipartFile imageFile;
    // -----------------------------

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

//    public MultipartFile getImageFile() {
//        return imageFile;
//    }

//    public void setImageFile(MultipartFile imageFile) {
//        this.imageFile = imageFile;
//    }
}
