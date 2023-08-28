package com.example.shoesecommerce.service;

import com.example.shoesecommerce.model.Shoe;
import com.example.shoesecommerce.repository.ShoeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeServiceImpl implements ShoeService {
    @Autowired
    private ShoeRepository shoeRepository;

    @Override
    public Shoe addShoe(Shoe shoe) {
        return shoeRepository.save(shoe);
    }

    @Override
    public void deleteShoe(Long id) {
        shoeRepository.deleteById(id);
    }

    @Override
    public Shoe updateShoe(Long id, Shoe updatedShoe) {
        Shoe existingShoe = shoeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shoe not found with id: " + id));

        existingShoe.setSeason(updatedShoe.getSeason());
        existingShoe.setBrand(updatedShoe.getBrand());
        existingShoe.setCategory(updatedShoe.getCategory());
        existingShoe.setPrice(updatedShoe.getPrice());
        existingShoe.setColor(updatedShoe.getColor());

        return shoeRepository.save(existingShoe);
    }

    @Override
    public List<Shoe> searchShoes(String season, String brand, String category, Double price) {
        return shoeRepository.findBySeasonOrBrandOrCategoryOrPriceOrderByPriceAsc(
                season, brand, category, price);
    }
}

