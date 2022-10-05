package com.raf.example.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.example.MainFrame;
import com.raf.example.dto.*;
import okhttp3.*;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservationService {
    public static final String URL = "http://localhost:9081/api";
    //public static final String URL = "http://localhost:8084/reservation-service/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public ReservationService(){
        Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);
    }

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
            throw new RuntimeException();
    }

    public void updateHotel(HotelDto hotelDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
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
            throw new RuntimeException();
    }

    public void deleteHotel() throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/hotels")
                .addHeader("authorization", "token " + token)
                .delete()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Hotel deleted successfully!");
        else
            throw new RuntimeException();
    }


    public void addRoom(RoomDto roomDto) throws IOException{
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(roomDto));

        Request request = new Request.Builder()
                .url(URL + "/rooms")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room added successfully!");
        else
            throw new RuntimeException();
    }

    public void editRoom(RoomDto roomDto) throws IOException{ // DODAJ RUTU ZA UPDATE
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(roomDto));

        Request request = new Request.Builder()
                .url(URL + "/rooms")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if(response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room added successfully!");
        else
            throw new RuntimeException();
    }

    public void addRoomType(RoomTypeDto roomTypeDto) throws IOException{
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(roomTypeDto));

        Request request = new Request.Builder()
                .url(URL + "/roomTypes")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room type added successfully!");
        else
            throw new RuntimeException();
    }

    public void addAllRoomTypes(List<RoomTypeDto> roomTypeDtos) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(roomTypeDtos));

        Request request = new Request.Builder()
                .url(URL + "/roomTypes/all")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "All room types made successfully!");
        else
            throw new RuntimeException();
    }

    public void updateRoomType(RoomTypeDto roomTypeDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(roomTypeDto));

        Request request = new Request.Builder()
                .url(URL + "/roomTypes")
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room type updated successfully!");
        else
            throw new RuntimeException();
    }

    public void deleteRoomType(String id) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(id));

        Request request = new Request.Builder()
                .url(URL + "/roomTypes")
                .addHeader("authorization", "token " + token)
                .delete(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room type deleted successfully!");
        else
            throw new RuntimeException();
    }

    public List getAvailableRooms(AvailableRoomsFilterDto availableRoomsFilterDto) throws IOException{
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(availableRoomsFilterDto));
        List availableRooms;

        Request request = new Request.Builder()
                .url(URL + "/rooms")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new RuntimeException();
    }

    public void createReservation(String roomId, String startDate, String endDate) throws IOException {
        String token = MainFrame.getInstance().getToken();

        HttpUrl.Builder httpBuilder = HttpUrl.parse(URL + "/reservations").newBuilder();
        httpBuilder.addQueryParameter("roomId", roomId); // na ruti na prihvata Interger nteger !!!!!!
        httpBuilder.addQueryParameter("startDate", startDate);  // na ruti na prihvata Date !!!!!!
        httpBuilder.addQueryParameter("endDate", endDate);  // na ruti na prihvata Date !!!!!!

        Request request = new Request.Builder()
                .url(httpBuilder.build())
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Reservation made successfully!");
        else
            throw new RuntimeException();
    }

    public void deleteReservation(String reservationId) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, reservationId);

        Request request = new Request.Builder()
                .url(URL + "/reservations/" + reservationId)
                .addHeader("authorization", "token " + token)
                .delete(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Reservation canceled!");
        else
            throw new RuntimeException();
    }

    public void addReview(ReviewDto reviewDto) throws IOException{
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(reviewDto));

        Request request = new Request.Builder()
                .url(URL + "/reviews")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Review added successfully!");
        else
            throw new RuntimeException();

    }
    public void updateReview(String id, ReviewDto reviewDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(reviewDto));

        Request request = new Request.Builder()
                .url(URL + "/reviews/" + id)
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Review updated successfully!");
        else
            throw new RuntimeException();

    }
    public void deleteReview(String reviewId) throws IOException {
        String token = MainFrame.getInstance().getToken();

        HttpUrl.Builder httpBuilder = HttpUrl.parse(URL + "/reviews").newBuilder();
        httpBuilder.addQueryParameter("reviewId", reviewId);

        Request request = new Request.Builder()
                .url(httpBuilder.build())
                .addHeader("authorization", "token " + token)
                .delete()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Review removed!");
        else
            throw new RuntimeException();

    }

    public List getAllReviews(String hotelName, String city) throws IOException {
        List reviews;
        String token = MainFrame.getInstance().getToken();

        HttpUrl.Builder httpBuilder = HttpUrl.parse(URL + "/reviews/all").newBuilder();
        httpBuilder.addQueryParameter("hotelName", hotelName);
        httpBuilder.addQueryParameter("city", city);

        Request request = new Request.Builder()
                .url(httpBuilder.build())
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new RuntimeException();
    }

    public List getAllReservations() throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/reservations")
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

    public List getTopRatedHotels() throws IOException {
        String token = MainFrame.getInstance().getToken();
        List reviews;

        Request request = new Request.Builder()
                .url(URL + "/reviews")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful())
            return objectMapper.readValue(response.body().string(), List.class);
        else
            throw new RuntimeException();
    }
}
