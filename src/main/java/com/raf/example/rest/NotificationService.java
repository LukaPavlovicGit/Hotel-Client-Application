package com.raf.example.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.example.MainFrame;
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
                .url(URL + "/notifications/allSent")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new RuntimeException("Error getting all sent notifications");
    }

    public List<SentEmailDto> getAllNotificationsByEmail(String email) throws IOException {
        String token = MainFrame.getInstance().getToken();
        Request request = new Request.Builder()
                .url(URL + "/notifications/allSent/"+email)
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new RuntimeException("Error getting all sent notifications by email!");
    }

    public List<EmailNotificationDto> getAllNotificationTypes() throws IOException{
        String token = MainFrame.getInstance().getToken();
        Request request = new Request.Builder()
                .url(URL + "/notifications/type")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200)
            return  objectMapper.readValue(response.body().string(), List.class);
        else
            throw new RuntimeException("Error getting all notifications types!");
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
            throw new RuntimeException("Error while changing notification type!");
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
            throw new RuntimeException("Error while deleting notification type");
    }

}
