package br.com.dh.ecommerce.service;


import java.util.List;

public interface IecommerceService<T> {
    T searchById(Integer id);
    List<T> listAll();
}
