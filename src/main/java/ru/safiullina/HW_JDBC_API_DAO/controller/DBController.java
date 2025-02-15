package ru.safiullina.HW_JDBC_API_DAO.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.safiullina.HW_JDBC_API_DAO.model.Customer;
import ru.safiullina.HW_JDBC_API_DAO.service.DBService;

import java.util.List;

@RestController
public class DBController {

    private final DBService service;

    public DBController(DBService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductNamesController(Customer customer){
        System.out.println(customer.getName());
        return service.getProductName(customer);
    }
}
