package com.example.shoesecommerce.Controller;

import com.example.shoesecommerce.model.Shoe;
import com.example.shoesecommerce.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoeController {
    @Autowired
    private ShoeService shoeService;

    @PostMapping
    public ResponseEntity<Shoe> addShoe(@RequestBody Shoe shoe) {
        Shoe savedShoe = shoeService.addShoe(shoe);
        return ResponseEntity.ok(savedShoe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoe(@PathVariable Long id) {
        shoeService.deleteShoe(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shoe> updateShoe(@PathVariable Long id, @RequestBody Shoe shoe) {
        Shoe updatedShoe = shoeService.updateShoe(id, shoe);
        return ResponseEntity.ok(updatedShoe);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Shoe>> searchShoes(
            @RequestParam(required = false) String season,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double price) {
        List<Shoe> shoes = shoeService.searchShoes(season, brand, category, price);
        return ResponseEntity.ok(shoes);
    }
}
