package com.raf.example.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.example.MainFrame;
import com.raf.example.dto.*;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class UserService {
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

        if (response.code() == 200) {
            String json = response.body().string();
            TokenResponseDto dto = objectMapper.readValue(json, TokenResponseDto.class);
            return dto.getToken();
        }
        throw new IOException();
    }

    public void registerClient(ClientCreateDto clientCreateDto) throws IOException {
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
            throw new IOException();
    }

    public void registerManager(ManagerCreateDto managerCreateDto) throws IOException {
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
            throw new IOException();
    }

    public void updateManager(ManagerDto managerDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(managerDto));

        Request request = new Request.Builder()
                .url(URL + "/UserProfileConfiguration/updateManager")
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            System.out.println("here");
        else
            throw new IOException();
    }
    public void updateClient(ClientDto clientDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(clientDto));

        Request request = new Request.Builder()
                .url(URL + "/UserProfileConfiguration/updateClient")
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            System.out.println("here");
        else
            throw new IOException();
    }
    public void updateAdmin(UserDto userDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(userDto));

        Request request = new Request.Builder()
                .url(URL + "/UserProfileConfiguration/updateAdmin")
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            System.out.println("here");
        else
            throw new IOException();
    }
    public List<UserDto> getAllUsers() throws IOException{
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users")
                .addHeader("authorization", "token " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new IOException();
    }

    public UserDto getUserById(String userId) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/" + userId)
                .addHeader("authorization", "token " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return objectMapper.readValue(response.body().string(), UserDto.class);
        else
            throw new IOException();

    }

    public List<ClientDto> getAllClients() throws IOException{
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/clients")
                .addHeader("authorization", "token " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new IOException();
    }

    public List<ManagerDto> getAllManagers() throws IOException{
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/managers")
                .addHeader("authorization", "token " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new IOException();
    }

    public void blockUser(String userId) throws IOException{
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(userId));

        Request request = new Request.Builder()
                .url(URL + "/users/block")
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.code() == 200)
            System.out.println("User has been blocked!");
        else
            throw new IOException();
    }

    public void unblockUser(String userId) throws IOException{
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(userId));

        Request request = new Request.Builder()
                .url(URL + "/users/unblock")
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.code() == 200)
            System.out.println("User has been given the access!");
        else
            throw new IOException();
    }

    public void rankConfiguration(RankDto rankDto) throws IOException{
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(rankDto));

        Request request = new Request.Builder()
                .url(URL + "/rank")
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.code() == 200)
            System.out.println("Rank changed successfully!");
        else
            throw new IOException();
    }
    public void addRank(RankDto rankDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(rankDto));

        Request request = new Request.Builder()
                .url(URL + "/rank")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            System.out.println("Rank created successfully!");
        else
            throw new IOException();
    }
    public void addAllRanks(List<RankDto> ranksDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(ranksDto));

        Request request = new Request.Builder()
                .url(URL + "/rank/all")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            System.out.println("All ranks created successfully!");
        else
            throw new IOException();
    }
}
