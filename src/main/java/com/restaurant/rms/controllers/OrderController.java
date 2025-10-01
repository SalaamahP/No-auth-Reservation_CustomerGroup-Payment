package com.restaurant.rms.controllers;

import com.restaurant.rms.models.DTO.OrderDTO;
import com.restaurant.rms.models.Order;
import com.restaurant.rms.repository.OrderRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ORDER
 * <br>
 * */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepo orderRepo;
    // --------------------------------------------

    // GET ALL
    @RequestMapping("")
    public String getAllOrders(Model model){
        List<Order> orders = orderRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("orders", orders);
        return "order/orders";
    }
    // --------------------------------------------

    // ADD
    @GetMapping("/add")
    public String showAddPage(Model model) {
        System.out.println("***ORDER. Attempting to add to database...");
        OrderDTO orderDTO = new OrderDTO();
        model.addAttribute("orderDTO", orderDTO);
        return "order/orders-add";
    }

    @PostMapping("/add")
    public String addOrder(
            @Valid @ModelAttribute OrderDTO orderDTO,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "order/orders-add";
        }

        // creating the object
        System.out.println("\n***ORDER. Trying to add data...");
        LocalDateTime now = LocalDateTime.now(); // order time-stamp
        Order order = new Order(
                now,
                Double.valueOf(orderDTO.getEstimatedWaitTime()),
                Double.valueOf(orderDTO.getTotalPrice()),
                orderDTO.getStatus()
        );

        // saving to database
        this.orderRepo.save(order);
        System.out.println("\n***Order-object \n(" + order + ") \nadded successfully***");

        // re-directing
        return "redirect:/orders";
    }
    // --------------------------------------------


    // EDIT
    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id) {
        System.out.println("\n***ORDER. EDIT. Getting...");

        try {
            Order order = orderRepo.findById(id).get();
            OrderDTO orderDTO = new OrderDTO();

            orderDTO.setStatus(order.getStatus());
            orderDTO.setEstimatedWaitTime(order.getEstimatedWaitTime());
            orderDTO.setTotalPrice(order.getTotalPrice());

            model.addAttribute("order", order);
            model.addAttribute("orderDTO", orderDTO);
        }
        catch (Exception ex) {
            System.out.println("Exception" + ex.getMessage());
            return "redirect:/order";
        }
        return "order/orders-edit";
    }

    // Editing an existing record
    @PostMapping("/edit")
    public String editOrder(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute OrderDTO orderDTO,
            BindingResult result
    ) {
        System.out.println("\n***ORDER. EDIT. Putting...");

        try {
            Order order = orderRepo.findById(id).get();
            model.addAttribute("orderDTO", order);

            if (result.hasErrors()) {
                return "order/orders-edit";
            }

            // updating other details
            order.setStatus(orderDTO.getStatus());
            order.setEstimatedWaitTime(orderDTO.getEstimatedWaitTime());
            order.setTotalPrice(orderDTO.getTotalPrice());

            orderRepo.save(order);
            System.out.println("\n***ORDER. \nUpdated ORDER successfully");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/orders";
    }
    // --------------------------------------------


    // DELETE
    // NOTE/IDEA:
    // modify this or create a new method to mark an order as complete
    // instead of deleting it
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam int id) {
        try {
            Order order = orderRepo.findById(id).get();

            // delete from database
            orderRepo.delete(order);
            System.out.println("\n***ORDER. \nSuccessful deletion of:");
            System.out.println(order);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/orders";
    }
    // --------------------------------------------


    // primarily for waiters and kitchen-staff
    @RequestMapping("/simple-mode")
    public String ordersOnly(){
        return "order/orders-only";
    }

    @RequestMapping("/simple-mode/add")
    public String ordersOnyAdd(){
        return "order/orders-only-add";
    }
    // --------------------------------------------

}
