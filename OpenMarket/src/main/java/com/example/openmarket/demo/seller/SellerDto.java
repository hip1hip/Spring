package com.example.openmarket.demo.seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellerDto {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
}
