package com.raf.example.tokenDecoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.raf.example.dto.UserDto;
import com.raf.example.tokenDecoder.payloadWrapper.PayloadWrapper;

import java.util.Base64;

public class TokenDecoder {

    private static Base64.Decoder decoder = Base64.getUrlDecoder();

    public static UserDto decodeToken(String token){
        String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        return new UserDto(payloadWrapper.getId(),payloadWrapper.getRole(), payloadWrapper.getEmail());
    }

    public static Long getId(String token){
        String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        return payloadWrapper.getId();
    }
}