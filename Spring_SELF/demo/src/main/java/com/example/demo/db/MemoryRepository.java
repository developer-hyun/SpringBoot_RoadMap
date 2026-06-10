package com.example.demo.db;

import com.example.demo.member.Member;

public interface MemoryRepository {

    void join(Member member);
    Member findmember(Long memberId);
}
