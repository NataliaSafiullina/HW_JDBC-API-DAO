package ru.safiullina.HW_JDBC_API_DAO.service;


import org.springframework.stereotype.Service;
import ru.safiullina.HW_JDBC_API_DAO.model.Customer;
import ru.safiullina.HW_JDBC_API_DAO.repository.DBRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBService {

    private final DBRepository repository;

    public DBService(DBRepository repository) {
        this.repository = repository;
    }

    public List<String> getProductName(Customer customer){
        return repository.getProductName(customer.getName());
    }
}
