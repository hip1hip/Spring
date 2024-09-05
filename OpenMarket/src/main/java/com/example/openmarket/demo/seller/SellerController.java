package com.example.openmarket.demo.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public SellerDto createSeller(@RequestBody SellerDto sellerDto) {
        return sellerService.createSeller(sellerDto);
    }

    @GetMapping
    public List<SellerDto> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public SellerDto getSellerById(@PathVariable int id) {
        return sellerService.getSellerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable int id) {
        sellerService.deleteSeller(id);
    }
}
