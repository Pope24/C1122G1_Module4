package com.product_management.repository.impl;

import com.product_management.model.Product;
import com.product_management.repository.IProductRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products = new HashMap<>();
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        String query = "select p from Product as p";
        TypedQuery<Product> queryProduct = entityManager.createQuery(query, Product.class);
        return queryProduct.getResultList();
    }

    @Override
    public void saveProduct(Product product) {
        Session session;
        try {
            session = sessionFactory.openSession();
            session.save(product);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product productPrevious = getProductById(id);
            productPrevious.setNameProduct(product.getNameProduct());
            productPrevious.setDescriptionProduct(product.getDescriptionProduct());
            productPrevious.setPriceProduct(product.getPriceProduct());
            productPrevious.setManufacturer(product.getManufacturer());
            session.saveOrUpdate(productPrevious);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            Product product = getProductById(id);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int id) {
        String query = "select p from Product as p where p.id = :id";
        TypedQuery<Product> queryProduct = entityManager.createQuery(query, Product.class);
        queryProduct.setParameter("id", id);
        return queryProduct.getSingleResult();
    }
}
