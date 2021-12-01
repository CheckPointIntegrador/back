package br.com.dh.ecommerce.service;

import br.com.dh.ecommerce.persistence.repository.ProdutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService{

    @Autowired
    private ProdutRepository produtRepository;
}
