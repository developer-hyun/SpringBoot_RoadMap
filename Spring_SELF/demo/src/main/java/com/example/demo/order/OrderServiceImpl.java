package com.example.demo.order;

import com.example.demo.db.MemoryRepository;
import com.example.demo.discount.discountPolicy;
import com.example.demo.member.Member;

public class OrderServiceImpl implements OrderService{

    MemoryRepository memoryRepository;
    discountPolicy discountPolicyA;
    public OrderServiceImpl(MemoryRepository memoryRepository,discountPolicy discountPolicyA) {
        this.memoryRepository = memoryRepository;
        this.discountPolicyA = discountPolicyA;
    }

    @Override
    public Order createOrder(String itemName, Long memberId, int itemPrice) {
        Member member = memoryRepository.findmember(memberId);
        int discountPrice = itemPrice - discountPolicyA.discountPrice(member,itemPrice);


        return new Order(itemName,memberId,discountPrice);

    }
}
