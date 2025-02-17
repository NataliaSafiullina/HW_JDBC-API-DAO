package ru.safiullina.HW_Hibernate_DAO_TwoTables.service;


import org.springframework.stereotype.Service;
import ru.safiullina.HW_Hibernate_DAO_TwoTables.dto.CustomerDto;
import ru.safiullina.HW_Hibernate_DAO_TwoTables.repository.DBRepository;

import java.util.List;

@Service
public class DBService {

    private final DBRepository repository;

    public DBService(DBRepository repository) {
        this.repository = repository;
    }

    public List<String> getProductName(CustomerDto customerDto){
        return repository.getProductName(customerDto.getName());
    }
}
