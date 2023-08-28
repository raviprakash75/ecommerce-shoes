package com.example.shoesecommerce.service;

import com.example.shoesecommerce.model.Shoe;

import java.util.List;

public interface ShoeService {
    Shoe addShoe(Shoe shoe);
    void deleteShoe(Long id);
    Shoe updateShoe(Long id, Shoe shoe);
    List<Shoe> searchShoes(String season, String brand, String category, Double price);
}
