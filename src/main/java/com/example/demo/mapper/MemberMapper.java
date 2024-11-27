package com.example.demo.mapper;

import com.example.demo.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    // get member info
    MemberEntity getMemberById(int id);

    // register
    int registerMember(MemberEntity member);
}
