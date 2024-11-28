package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.enumeration.ResultCodeEnum;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/api/member/info")
    public ResponseDto<MemberDto> getMemberInfo(@RequestBody MemberDto.MemberRequestDto req) {
        MemberDto toDto = MemberDto.of(memberService.getMemberById(req.getId()));
        return ResponseDto.of(String.valueOf(ResultCodeEnum.getEnum(200).getCode())
                ,ResultCodeEnum.getEnum(200).getMessage()
                ,toDto);
    }
    @PostMapping("/api/member/register")
    public ResponseDto<MemberDto> registerMember(@RequestBody MemberDto.MemberRequestDto req) {
        // 요청 데이터를 사용하여 새로운 멤버를 등록
        int id = memberService.registerMember(MemberDto.toEntity(req));
        MemberDto dto = MemberDto.of(memberService.getMemberById(id));
        // 성공 응답 생성
        return ResponseDto.of(
                String.valueOf(ResultCodeEnum.getEnum(200).getCode()), // 성공 코드
                ResultCodeEnum.getEnum(200).getMessage(),
                dto
        );
    }
    @GetMapping("/api/member/list")
    public ResponseDto<List<MemberDto>> getMemberList() {
        // 멤버 리스트 조회
        return ResponseDto.of(
                String.valueOf(ResultCodeEnum.getEnum(200).getCode()), // 성공 코드
                ResultCodeEnum.getEnum(200).getMessage(),
                MemberDto.ofList(memberService.getMemberList())
        );
    }

}
