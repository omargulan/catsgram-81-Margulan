package com.practice.catsgram81.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.practice.catsgram81.model.Product;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    static List<Product> products = List.of(
            new Product("Яблоко", 450),
            new Product("Банан", 700),
            new Product("Морковь", 300),
            new Product("Помидор", 600),
            new Product("Апельсин", 800),
            new Product("Огурец", 400),
            new Product("Виноград", 1200),
            new Product("Картофель", 200),
            new Product("Говядина", 4500),
            new Product("Курица", 2000),
            new Product("Свинина", 3000),
            new Product("Молоко", 500),
            new Product("Сыр", 1500),
            new Product("Йогурт", 800)
    );

    //    /products - получить все товары
    //    /products?from=700 - получить все товары от 700
    //    /products?to=1200 - получить все товары до 1200
    //    /products?from=700&to=1200 - получить все товары от 700 до 1200

    @GetMapping("/products")
    public List<Product> findAll(@RequestParam(required = false) Integer from, @RequestParam(required = false) Integer to) {
        List<Product> findListProducts = new ArrayList<>();
        if (from != null && to != null) {
            for (Product product : products) {
                if (product.getPrice() >= from && product.getPrice() <= to) {
                    findListProducts.add(product);
                }

            }
        } else if (from != null) {
            for (Product product : products) {
                if (product.getPrice() >= from) {
                    findListProducts.add(product);
                }
            }
        } else if(to !=null){
            for (Product product : products) {
                if (product.getPrice() <= to) {
                    findListProducts.add(product);
                }
            }
        }else {
            return products;
        }
        return findListProducts;
    }


}