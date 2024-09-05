package com.example.openmarket.demo.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerDao;

    public SellerDto createSeller(SellerDto sellerDTO) {
        Seller seller = new Seller();
        seller.setName(sellerDTO.getName());
        seller.setEmail(sellerDTO.getEmail());
        seller.setPhoneNumber(sellerDTO.getPhoneNumber());
        Seller savedSeller = sellerDao.save(seller);
        return new SellerDto(savedSeller.getId(), savedSeller.getName(), savedSeller.getEmail(), savedSeller.getPhoneNumber());
    }

    public List<SellerDto> getAllSellers() {
        return sellerDao.findAll().stream()
                .map(seller -> new SellerDto(seller.getId(), seller.getName(), seller.getEmail(), seller.getPhoneNumber()))
                .toList();
    }

    public SellerDto getSellerById(int id) {
        Optional<Seller> seller = sellerDao.findById(id);
        return seller.map(s -> new SellerDto(s.getId(), s.getName(), s.getEmail(), s.getPhoneNumber())).orElse(null);
    }

    public void deleteSeller(int id) {
        sellerDao.deleteById(id);
    }
}
