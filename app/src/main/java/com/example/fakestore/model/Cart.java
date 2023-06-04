package com.example.fakestore.model;

import com.example.fakestore.CartProduct;

import java.util.List;

public class Cart {
   private Integer id;
   private Integer userId;
   private List<CartProduct> products;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getUserId() {
      return userId;
   }

   public void setUserId(Integer userId) {
      this.userId = userId;
   }

   public List<CartProduct> getProducts() {
      return products;
   }

   public void setProducts(List<CartProduct> products) {
      this.products = products;
   }
}
