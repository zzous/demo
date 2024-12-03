package com.example.demo.mapper;

import com.example.demo.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    // get member info
    MemberEntity getMemberById(int id);

    // register
    int registerMember(MemberEntity member);
    // update member info
    int updateMember(MemberEntity member);
    // delete member
    int deleteMember(int id);

    // member list
    MemberEntity[] getMemberList();
}
