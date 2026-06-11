package com.example.demo.order;

import com.example.demo.member.Member;

public interface OrderService {

    Order createOrder(String itemName,Long memberId, int itemPrice);
}
