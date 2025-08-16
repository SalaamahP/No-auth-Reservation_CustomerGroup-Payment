package com.restaurant.rms.controllers;

import com.restaurant.rms.models.CustomerGroup;
import com.restaurant.rms.models.CustomerGroupPayment;
import com.restaurant.rms.models.DTO.CustomerGroupPaymentDTO;
import com.restaurant.rms.repository.CustomerGroupPaymentRepo;
import com.restaurant.rms.repository.CustomerGroupRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
//@RequestMapping("/payments")
public class CustomerGroupPaymentController {
    @Autowired
    private CustomerGroupPaymentRepo customerGroupPaymentRepo;

    @Autowired
    private CustomerGroupRepo customerGroupRepo;


    @GetMapping("payments/add")
    public String addPayment(Model model, @RequestParam int customerGroupId) {

        CustomerGroupPaymentDTO paymentDTO = new CustomerGroupPaymentDTO();
        paymentDTO.setCustomerGroupId(customerGroupId);
        model.addAttribute("customerGroupPaymentDTO", paymentDTO);
        return "customer/payments-add";
    }

    @PostMapping("payments/add")
    public String createPayment(@Valid @ModelAttribute CustomerGroupPaymentDTO paymentDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "customer/payments-add";
        }

        LocalDateTime currentDateTime = LocalDateTime.now();

        CustomerGroup customerGroup = customerGroupRepo.findById(paymentDTO.getCustomerGroupId()).orElseThrow();
        CustomerGroupPayment customerGroupPayment = new CustomerGroupPayment();
        customerGroupPayment.setCustomerGroup(customerGroup);

        customerGroupPayment.setPaymentDateTime(currentDateTime);
        customerGroupPayment.setPaymentAmount(paymentDTO.getPaymentAmount());
        customerGroupPayment.setPaymentTransactionType(paymentDTO.getPaymentTransactionType());
        customerGroupPaymentRepo.save(customerGroupPayment);

        return "redirect:/payments/list";

    }

    @GetMapping("payments/edit")
    public String editPayment(Model model, @RequestParam int paymentId) {
        CustomerGroupPayment payment = customerGroupPaymentRepo.findById(paymentId).orElseThrow();
        CustomerGroupPaymentDTO dto = new CustomerGroupPaymentDTO();

        dto.setPaymentId(payment.getPaymentId());
        dto.setCustomerGroupId(payment.getCustomerGroup().getCustomerGroupId());
        dto.setPaymentAmount(payment.getPaymentAmount());
        dto.setPaymentDateTime(payment.getPaymentDateTime());
        dto.setPaymentTransactionType(payment.getPaymentTransactionType());

        model.addAttribute("customerGroupPaymentDTO", dto);
        return "customer/payments-edit";

    }

    @PostMapping("payments/edit")
    public String updatePayment(@Valid @ModelAttribute CustomerGroupPaymentDTO paymentDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "customer/payments-edit";
        }
        CustomerGroupPayment updatedPayment = customerGroupPaymentRepo.findById(paymentDTO.getPaymentId()).orElseThrow();
        updatedPayment.setPaymentAmount(paymentDTO.getPaymentAmount());
        updatedPayment.setPaymentDateTime(paymentDTO.getPaymentDateTime());
        updatedPayment.setPaymentTransactionType(paymentDTO.getPaymentTransactionType());
        customerGroupPaymentRepo.save(updatedPayment);

        return "redirect:/payments/list";

    }

    @GetMapping("payments/delete")
    public String deletePayment(Model model, @RequestParam int paymentId) {

        try {
            CustomerGroupPayment deletedPayment = customerGroupPaymentRepo.findById(paymentId).orElseThrow();
            customerGroupPaymentRepo.delete(deletedPayment);

        }catch (Exception e){
            System.out.println("Error deleting payment" + e.getMessage());
        }
        return "redirect:/payments/list";

    }

    @GetMapping("payments/list")
    public String allPayments(Model model) {
        List<CustomerGroupPayment> payments = customerGroupPaymentRepo.findAll(Sort.by(Sort.Direction.ASC, "paymentDateTime"));
        model.addAttribute("payments", payments);
        return "customer/payments-list";

    }


}
