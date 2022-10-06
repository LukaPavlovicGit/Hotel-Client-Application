package com.raf.example.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.example.MainFrame;
import com.raf.example.dto.AllNotificationTypesListDto;
import com.raf.example.dto.EmailNotificationDto;
import com.raf.example.dto.SentEmailDto;
import okhttp3.*;

import java.io.IOException;
import java.util.List;


public class NotificationService {

    public static final String URL = "http://localhost:8082/api";
    //public static final String URL = "http://localhost:8084/email-service/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<SentEmailDto> getAllNotifications() throws IOException {
        String token = MainFrame.getInstance().getToken();
        Request request = new Request.Builder()
                .url(URL + "/notifications/all")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new RuntimeException();
    }

    public List<SentEmailDto> getAllNotificationsByCurrentUserEmail() throws IOException {
        String token = MainFrame.getInstance().getToken();
        Request request = new Request.Builder()
                .url(URL + "/notifications/allByEmail")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new RuntimeException();
    }

    public AllNotificationTypesListDto getAllNotificationTypes() throws IOException{

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String token = MainFrame.getInstance().getToken();
        Request request = new Request.Builder()
                .url(URL + "/notifications/all/type")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return  objectMapper.readValue(response.body().string(), AllNotificationTypesListDto.class);
        else
            throw new RuntimeException();
    }

    public void changeNotificationType(EmailNotificationDto emailNotificationDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(emailNotificationDto));

        Request request = new Request.Builder()
                .url(URL + "/notifications/update")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.code() == 200)
            System.out.println("Notification type changed successfully!");
        else
            throw new RuntimeException();
    }

    public void deleteNotificationType(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();
        Request request = new Request.Builder()
                .url(URL + "/email/type/" + id)
                .addHeader("authorization", "token " + token)
                .delete()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.code() == 200)
            System.out.println("Notification type deleted successfully!");
        else
            throw new RuntimeException();
    }

}
