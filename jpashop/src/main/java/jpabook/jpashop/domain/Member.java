package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "user")
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty //무조건 값이 있어야함
    private String name;

    @Embedded  //내장타입
    private Address address;

    @OneToMany(mappedBy = "member")  //읽기 전용
    private List<Order> orders = new ArrayList<>();




}
