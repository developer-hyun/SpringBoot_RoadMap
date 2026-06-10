package com.example.demo.db;

import com.example.demo.member.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryRepositoryImpl implements MemoryRepository{

    public static Map<Long , Member> db = new HashMap<>();

    @Override
    public void join(Member member) {
        db.put(member.getId(), member);
    }

    @Override
    public Member findmember(Long memberId) {
        return db.get(memberId);
    }
}
