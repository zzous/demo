package com.example.demo.dto;

import com.example.demo.enumeration.ResultCodeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of") // Constructor with required parameters
public class ResponseDto<T> { // T is the type of data that can be returned in the response
    private final int resultCode;
    private final String resultMessage;
    private final T data;
}
