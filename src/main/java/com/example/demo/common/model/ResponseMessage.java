package com.example.demo.common.model;

import java.time.LocalTime;
import lombok.Getter;

@Getter
public class ResponseMessage {

    private ResponseData responseData;
    private LocalTime localTime;

    public ResponseMessage(ResponseData responseData){
        this.responseData = responseData;
        this.localTime = LocalTime.now();
    }
}
