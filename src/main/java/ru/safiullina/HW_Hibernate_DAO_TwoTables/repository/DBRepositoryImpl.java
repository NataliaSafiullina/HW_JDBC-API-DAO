package ru.safiullina.HW_Hibernate_DAO_TwoTables.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.safiullina.HW_Hibernate_DAO_TwoTables.entity.Customer;
import ru.safiullina.HW_Hibernate_DAO_TwoTables.entity.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Repository
public class DBRepositoryImpl implements DBRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<String> getProductName(String name) {

        if ((entityManager.createQuery("select count(*) from Customer", Long.class).getSingleResult() <= 0)
                && (entityManager.createQuery("select count(*) from Order", Long.class).getSingleResult() <= 0)) {
            addData();
        }

        String queryString = "select product_name " +
                "from Order " +
                "where lower(customer.name) = lower(:name)";

        Query<String> query = (Query<String>) entityManager.createQuery(queryString, String.class);
        query.setParameter("name", name);

        return query.list();

    }


    /**
     * Этот метод нужен для первоначального заполнения таблиц для теста исключительно
     */
    @Transactional
    private void addData() {

        System.out.println("Insert data");

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Natasha", "Wolf", 33, "+75555555555"));
        customers.add(new Customer("Natasha", "Rabbit", 24, "+75553337777"));
        customers.add(new Customer("John", "Impala", 30, "+75556664433"));
        customers.add(new Customer("James", "Hetfield", 61, "+04564567744"));
        customers.add(new Customer("Jared", "Leto", 53, "+01234567899"));
        customers.add(new Customer("Alexey", "Ivanov", 15, "+71472583315"));
        customers.add(new Customer("Alexey", "Petrov", 25, "+71472583325"));
        customers.add(new Customer("Alexey", "Sidorov", 45, "+71472583345"));

        List<String> products = new ArrayList<>();
        products.add("apple");
        products.add("bean");
        products.add("citron");
        products.add("drugs");
        products.add("elephant");
        products.add("flour");
        products.add("grape");
        products.add("halo pop");

        customers.forEach(entityManager::persist);

        for (int i = 1; i <= customers.size(); i++) {
            var customerDB = entityManager.find(Customer.class, i);
            System.out.println(customerDB);
            Order order = new Order(new Date(2025, 2, 11), products.get(i - 1), 2, customerDB);
            entityManager.persist(order);
        }
    }

}
