package ru.safiullina.HW_JDBC_API_DAO.repository;

import java.util.List;

public interface DBRepository {
    List<String> getProductName(String name);
}
