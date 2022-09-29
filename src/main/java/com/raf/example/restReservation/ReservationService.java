package com.raf.example.restReservation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.example.MainFrame;
import com.raf.example.dto.HotelDto;
import com.raf.example.tokenDecoder.TokenDecoder;
import okhttp3.*;

import javax.swing.*;
import java.io.IOException;

public class ReservationService {
    public static final String URL = "http://localhost:9081/api";
    //public static final String URL = "http://localhost:8084/reservation-service/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public void addNewHotel(HotelDto hotelDto) throws IOException  {
        String token = MainFrame.getInstance().getToken();

        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(hotelDto));
        Request request = new Request.Builder()
                .url(URL + "/hotels")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if(response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Hotel added successfully!");
        else
            throw new RuntimeException("Cannot add a new hotel!");
    }

    public void editHotel(HotelDto hotelDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        Long managerId = TokenDecoder.getId(token);


        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(hotelDto));

        Request request = new Request.Builder()
                .url(URL + "/hotels")
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Hotel updated successfully!");
        else
            throw new RuntimeException("Cannot update a hotel!");
    }
}
