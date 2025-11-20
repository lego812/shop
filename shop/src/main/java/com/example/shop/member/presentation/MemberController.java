package com.example.shop.controller;

import com.example.shop.common.ResponseEntity;
import com.example.shop.member.*;
import com.example.shop.member.application.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("${api.v1}/members")
//@RequiredArgsConstructor
public class MemberController {


    @Autowired
    private MemberService memberService;


    @Operation(
            summary="회원목록조회",
            description ="public.member 테이블에서 조회한다."
    )
    @GetMapping("/")
    public ResponseEntity<List<MemberResponse>> findAll(){
        return new ResponseEntity<>(HttpStatus.OK.value(),memberService.findAll(), memberService.count());
    }


    @Operation(
            summary="회원등록",
            description ="요청으로 받은 회원 정보를 public.member 테이블에 저장한다."
    )
    @PostMapping
    public ResponseEntity<Member> create(@RequestBody MemberRequest request){

        return new ResponseEntity<>(HttpStatus.OK.value(), memberService.create(request);, memberService.count());
    }

    @Operation(
            summary="회원수정",
            description ="요청으로 받은 회원 정보를 public.member 테이블에 수정한다."
    )

    @PutMapping("{id}")
    public ResponseEntity<Member> modify(@RequestBody MemberRequest request,@PathVariable String id){

        //TODO: ResponseEntity에 맞게 수정해야함.
        return new ResponseEntity<>(HttpStatus.OK.value(),memberService.modify(id, request), memberService.count());
    }


    @Operation(
            summary="회원삭제",
            description ="요청으로 받은 회원 정보를 public.member 테이블에 삭제한다."
    )
    @DeleteMapping("{id}")
    public ResponseEntity<Member> delete(@PathVariable String id){
        return new ResponseEntity<>(HttpStatus.OK.value(), memberService.delete(id),memberService.count());
    }

}

