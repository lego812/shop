package com.example.shop.controller;

import com.example.shop.member.Member;
import com.example.shop.member.MemberRepository;
import com.example.shop.member.MemberRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("${api.v1}/members")
//@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;



//    public MemberController(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @GetMapping("/")
    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    @Operation(
            summary="회원등록",
            description ="요청으로 받은 회원 정보를 public.member 테이블에 저장한다."
    )
    @PostMapping
    public Member create(@RequestBody MemberRequest request){
        Member newMember = new Member(
                UUID.randomUUID(),
                request.email(),
                request.name(),
                request.password(),
                request.phone(),
                request.saltKey(),
                request.flag()

        );
        return memberRepository.save(newMember);
    }

    @Operation(
            summary="회원수정",
            description ="요청으로 받은 회원 정보를 public.member 테이블에 수정한다."
    )
    @PutMapping("/{id}")
    public Member modify(@RequestBody MemberRequest request,@PathVariable String id){

        Member modify = new Member(
                id,
                request.email(),
                request.name(),
                request.password(),
                request.phone(),
                request.saltKey(),
                request.flag()
        );
        return memberRepository.save(modify);
    }


    @Operation(
            summary="회원삭제",
            description ="요청으로 받은 회원 정보를 public.member 테이블에 삭제한다."
    )
    @DeleteMapping("{id}")
    public void update(@PathVariable String id){
        memberRepository.deleteById(UUID.fromString(id));
    }

}

