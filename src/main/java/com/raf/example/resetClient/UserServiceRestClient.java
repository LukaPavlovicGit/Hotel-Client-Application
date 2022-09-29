package com.raf.example.resetClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.example.dto.ClientCreateDto;
import com.raf.example.dto.ManagerCreateDto;
import com.raf.example.dto.TokenRequestDto;
import com.raf.example.dto.TokenResponseDto;
import okhttp3.*;

import java.io.IOException;

public class UserServiceRestClient {
    //public static final String URL = "http://localhost:8084/user-service/api";
    public static final String URL = "http://localhost:8080/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public String login(TokenRequestDto tokenRequestDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(tokenRequestDto));

        Request request = new Request.Builder()
                .url(URL + "/users/login")
                .post(body)
                .build();

        Call call = client.newCall(request);

        Response response = call.execute();
        System.out.println(request.toString());
        if (response.code() == 200) {
            String json = response.body().string();
            TokenResponseDto dto = objectMapper.readValue(json, TokenResponseDto.class);
            return dto.getToken();
        }

        throw new RuntimeException("Invalid username or password");
    }

    public void registerClient(ClientCreateDto clientCreateDto) throws RuntimeException, IOException {

        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(clientCreateDto));

        Request request = new Request.Builder()
                .url(URL + "/users/registration/client")
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            System.out.println("Registration successful!");
        else
            throw new RuntimeException("Username or email already in use");
    }

    public void registerManager(ManagerCreateDto managerCreateDto) throws RuntimeException, IOException {

        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(managerCreateDto));

        Request request = new Request.Builder()
                .url(URL + "/users/registration/manager")
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            System.out.println("Registration successful!");
        else
            throw new RuntimeException("Username or email already in use");
    }
}
