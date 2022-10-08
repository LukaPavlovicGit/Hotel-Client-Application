package com.raf.example.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.example.MainFrame;
import com.raf.example.dto.NotificationTypesListDto;
import com.raf.example.dto.NotificationTypeDto;
import com.raf.example.dto.SentNotificationDto;
import com.raf.example.dto.SentNotificationListDto;
import okhttp3.*;

import java.io.IOException;
import java.util.List;


public class NotificationService {

    public static final String URL = "http://localhost:8082/api";
    //public static final String URL = "http://localhost:8084/email-service/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<SentNotificationDto> getSentNotifications() throws IOException {
        String token = MainFrame.getInstance().getToken();
        Request request = new Request.Builder()
                .url(URL + "/notifications/all")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.code() == 200)
            return objectMapper.readValue(json, List.class);
        else
            throw new IOException();
    }

    public SentNotificationListDto getNotificationsByCurrentUserEmail() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();
        Request request = new Request.Builder()
                .url(URL + "/notifications/allByEmail")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.code() == 200)
            return objectMapper.readValue(json, SentNotificationListDto.class);
        else
            throw new IOException();
    }

    public NotificationTypesListDto getAllNotificationTypes() throws IOException{
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String token = MainFrame.getInstance().getToken();
        Request request = new Request.Builder()
                .url(URL + "/notifications/all/type")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.code() == 200)
            return  objectMapper.readValue(json, NotificationTypesListDto.class);
        else
            throw new IOException();
    }

    public void changeNotificationType(NotificationTypeDto notificationTypeDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(notificationTypeDto));

        Request request = new Request.Builder()
                .url(URL + "/notifications/update")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        response.body().close();

        if (response.code() == 200)
            System.out.println("Notification type changed successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.code() == 200)
            System.out.println("Notification type deleted successfully!");
        else
            throw new IOException();
    }

}
