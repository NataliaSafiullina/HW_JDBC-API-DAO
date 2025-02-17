package ru.safiullina.HW_Hibernate_DAO_TwoTables.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.safiullina.HW_Hibernate_DAO_TwoTables.dto.CustomerDto;
import ru.safiullina.HW_Hibernate_DAO_TwoTables.service.DBService;

import java.util.List;

@RestController
public class DBController {

    private final DBService service;

    public DBController(DBService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductNamesController(CustomerDto customerDto){
        System.out.println(customerDto.getName());
        return service.getProductName(customerDto);
    }
}
