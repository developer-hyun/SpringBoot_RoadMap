package com.example.demo.order;

public class Order {
    private String name;
    private Long memberId;
    private int price;

    public Order(String name, Long memberId, int price) {
        this.name = name;
        this.memberId = memberId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return name + " " + memberId + " " + price;

    }
}
