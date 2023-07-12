package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)    //ORDINAL로 하면 데이터가 추가,수정,삭제 되는 순간 데이터가 꼬이기때문에 ENUM타입은 STRING으로
    private DeliveryStatus status;  //READY, COMP
}
