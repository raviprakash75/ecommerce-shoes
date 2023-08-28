package com.example.shoesecommerce.repository;

import com.example.shoesecommerce.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {
    List<Shoe> findBySeason(String season);
    List<Shoe> findByBrand(String brand);
    List<Shoe> findByCategory(String category);
    List<Shoe> findByPriceOrderByPriceAsc(double price);

    List<Shoe> findBySeasonOrBrandOrCategoryOrPriceOrderByPriceAsc(
            String season, String brand, String category, double price);

    // Additional methods for searching by color and date
    List<Shoe> findByColor(String color);
    List<Shoe> findByOrderByDateDesc();
}