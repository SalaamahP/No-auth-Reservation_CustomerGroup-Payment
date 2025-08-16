/*
Project:    Restaurant-management system (RMS)
Started:    22.04.25
Updated:    06.08.25

GitHub Repo
https://github.com/ammaar0x01/Project3_RMS
---


Responsibilities
-------------------------------------------------------------------------
Name and surname    | Classes 										   	|
-------------------------------------------------------------------------
Ammaar 			    | Employee, Order, OrderDetail     					|
Salaamah			| CustomerGroup, CustomerGroupPayment, Reservation 	|
Kyran 				| User, EmployeeSalary								|
Leslie				| Table, MenuItem									|
Esethu				| Expenses, EmployeeShift							|
-------------------------------------------------------------------------
*/

package com.restaurant.rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}

// NO AUTH USED YET //
