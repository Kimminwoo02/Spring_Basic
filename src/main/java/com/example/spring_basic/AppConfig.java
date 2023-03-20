package com.example.spring_basic;

import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.discount.FixDiscountPolicy;
import com.example.spring_basic.discount.RateDiscountPolicy;
import com.example.spring_basic.member.MemberRepository;
import com.example.spring_basic.member.MemberService;
import com.example.spring_basic.member.MemberServiceImpl;
import com.example.spring_basic.member.MemoryMemberRepository;
import com.example.spring_basic.order.OrderService;
import com.example.spring_basic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
