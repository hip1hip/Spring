package com.example.openmarket.demo.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer getBuyerById(int id) {
        return buyerRepository.findById(id).orElse(null);
    }

    public void deleteBuyer(int id) {
        buyerRepository.deleteById(id);
    }
}
