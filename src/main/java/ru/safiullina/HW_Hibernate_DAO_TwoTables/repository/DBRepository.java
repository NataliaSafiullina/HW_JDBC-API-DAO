package ru.safiullina.HW_Hibernate_DAO_TwoTables.repository;

import java.util.List;

public interface DBRepository {
    List<String> getProductName(String name);
}
