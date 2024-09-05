package com.example.openmarket.demo.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @PostMapping("")
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerService.saveBuyer(buyer);
    }

    @GetMapping("")
    public List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    @GetMapping("/{id}")
    public Buyer getBuyer(@PathVariable int id) {
        return buyerService.getBuyerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable int id) {
        buyerService.deleteBuyer(id);
    }
}