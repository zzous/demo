package com.example.demo.dto;

import com.example.demo.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MemberDto {
    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String dateOfBirth;
    private String gender;
    private String occupation;
    private String maritalStatus;
    private String education;

    @Builder
    public MemberDto(int id, String name, String password, String email, String phone, String address, String city, String state, String zipcode, String dateOfBirth, String gender, String occupation, String maritalStatus, String education) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.occupation = occupation;
        this.maritalStatus = maritalStatus;
        this.education = education;
    }

    public static MemberDto of(MemberEntity memberEntity) {
        return MemberDto.builder()
                .id(memberEntity.getId())
                .name(memberEntity.getName())
                .password(memberEntity.getPassword())
                .email(memberEntity.getEmail())
                .phone(memberEntity.getPhone())
                .address(memberEntity.getAddress())
                .city(memberEntity.getCity())
                .state(memberEntity.getState())
                .zipcode(memberEntity.getZipcode())
                .dateOfBirth(memberEntity.getDateOfBirth())
                .gender(memberEntity.getGender())
                .occupation(memberEntity.getOccupation())
                .maritalStatus(memberEntity.getMaritalStatus())
                .education(memberEntity.getEducation())
                .build();
    }
    public static MemberEntity toEntity(MemberDto.MemberRequestDto memberDto) {
        return MemberEntity.builder()
                .id(memberDto.getId())
                .name(memberDto.getName())
                .password(memberDto.getPassword())
                .email(memberDto.getEmail())
                .phone(memberDto.getPhone())
                .address(memberDto.getAddress())
                .city(memberDto.getCity())
                .state(memberDto.getState())
                .zipcode(memberDto.getZipcode())
                .dateOfBirth(memberDto.getDateOfBirth())
                .gender(memberDto.getGender())
                .occupation(memberDto.getOccupation())
                .maritalStatus(memberDto.getMaritalStatus())
                .education(memberDto.getEducation())
                .build();
    }

    public static List<MemberDto> ofList(List<MemberEntity> memberEntities) {
        return memberEntities.stream()
                .map(MemberDto::of)
                .collect(Collectors.toList());
    }

    @Getter
    public static class MemberRequestDto {
        private int id;
        private String name;
        private String password;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String state;
        private String zipcode;
        private String dateOfBirth;
        private String gender;
        private String occupation;
        private String maritalStatus;
        private String education;
    }
}
