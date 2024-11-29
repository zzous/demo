package com.example.demo.controller;

import com.example.demo.config.GeneralException;
import com.example.demo.dto.LoginResultDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.MemberEntity;
import com.example.demo.enumeration.ResultCodeEnum;
import com.example.demo.service.MemberService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/member/info")
    public ResponseDto<MemberDto> getMemberInfo(@RequestBody MemberDto.MemberRequestDto req) {
        MemberDto toDto = MemberDto.of(memberService.getMemberById(req.getId()));
        return ResponseDto.of(ResultCodeEnum.getEnum(200).getCode()
                ,ResultCodeEnum.getEnum(200).getMessage()
                ,toDto);
    }
    @PostMapping("/member/register")
    public ResponseDto<MemberDto> registerMember(@RequestBody MemberDto.MemberRequestDto req) {
        // 요청 데이터를 사용하여 새로운 멤버를 등록
        int id = memberService.registerMember(MemberDto.toEntity(req));
        MemberDto dto = MemberDto.of(memberService.getMemberById(id));
        // 성공 응답 생성
        return ResponseDto.of(
                ResultCodeEnum.getEnum(200).getCode(), // 성공 코드
                ResultCodeEnum.getEnum(200).getMessage(),
                dto
        );
    }
    @GetMapping("/member/list")
    public ResponseDto<List<MemberDto>> getMemberList() {
        // 멤버 리스트 조회
        return ResponseDto.of(
                ResultCodeEnum.getEnum(200).getCode(), // 성공 코드
                ResultCodeEnum.getEnum(200).getMessage(),
                MemberDto.ofList(memberService.getMemberList())
        );
    }

    @PostMapping("/member/login")
    public ResponseDto<LoginResultDto> loginMember(@RequestBody MemberDto.MemberLoginRequestDto req) {
        /**
         * memberService 객체를 통해 사용자의 ID를 기준으로 데이터베이스에서 회원 정보를 조회
         * 조회된 결과는 MemberEntity라는 엔티티(객체)로 반환
         * 만약 ID에 해당하는 회원이 없다면 null이 반환
         */
        MemberEntity entity =
                Optional.ofNullable(memberService.getMemberById(req.getId()))
                       .filter(e -> e.getPassword().equals(req.getPassword()))
                       .orElseThrow(() -> new GeneralException(ResultCodeEnum.LoginFAILED));
        String token = JwtUtil.generateToken(MemberDto.of(entity));
        return ResponseDto.of(
                ResultCodeEnum.SUCCESS.getCode()
                , ResultCodeEnum.SUCCESS.getMessage()
                , LoginResultDto.builder()
                        .token(token)
                        .expiration(JwtUtil.getExpireDate(token))
                        .member(MemberDto.of(entity))
                        .build());
    }

}
