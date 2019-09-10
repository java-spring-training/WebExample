package example.repository;

import example.domain.ProductRepository;
import example.domain.entities.object.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Products> getAll() {

        // call api trả ra object response

        // factory thành domain và gửi về service


        // trong package repository có chứa 2 loai object để gọi resttemplate
        // object response của api
        // object request của api

        return null;
    }
}

