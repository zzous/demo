package com.example.demo.service;

import com.example.demo.entity.MemberEntity;
import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;
    public MemberEntity getMemberById(int id){
        return memberMapper.getMemberById(id);
    }
    // register
    public int registerMember(MemberEntity member){
        return memberMapper.registerMember(member);
    }
    // update
    public int updateMember(MemberEntity member){
        return memberMapper.updateMember(member);
    }
    // delete
    public int deleteMember(int id) {
        return memberMapper.deleteMember(id);
    }
    // member list
    public List<MemberEntity> getMemberList() {
        return List.of(memberMapper.getMemberList());
    }
}
