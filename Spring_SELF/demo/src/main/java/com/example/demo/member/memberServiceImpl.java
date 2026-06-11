package com.example.demo.member;

import com.example.demo.db.MemoryRepository;
import com.sun.source.tree.BreakTree;
import com.sun.source.tree.MemberReferenceTree;

public class memberServiceImpl implements MemberService{


    private final MemoryRepository memoryRepository;

    public memberServiceImpl(MemoryRepository memoryRepository) {

        this.memoryRepository = memoryRepository;
    }

    @Override
    public void join(Member member) {
        memoryRepository.join(member);
    }

    @Override
    public Member findMember(Long memberId) {

        return memoryRepository.findmember(memberId);
    }

}
