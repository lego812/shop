package com.example.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberResponse> findAll(){
        return memberRepository.findAll().stream()
                .map(m->new MemberResponse())
                .toList();
    }

    public List<MemberResponse> create(MemberRequest request){

        Member member = new Member(
                UUID.randomUUID(),
                request.email(),
                request.name(),
                request.password(),
                request.phone(),
                request.saltKey(),
                request.flag()
        );

        List<Member> createdMember= List.of(memberRepository.save(member));
        List<MemberResponse> memberResponses = member.stream()
                .map(m->new MemberResponse())
                .toList();

        return memberResponses;
    }

    public Member modify(String id, MemberRequest request){
       Member member= memberRepository.findById(UUID.fromString(id)).orElse(null);
       member.setEmail(request.email());
       member.setName(request.name());
       member.setPhone(request.phone());
       member.setSaltKey(request.saltKey());
       member.setFlag(request.flag());
       return member;
    }

    public Member delete(String id){

        Member member = memberRepository.findById(UUID.fromString(id)).orElse(null);
        memberRepository.deleteById(UUID.fromString(id));

        return member;
    }

    //현재 계정갯수 집계
    public Long count(){
        return memberRepository.count();
    }
}
