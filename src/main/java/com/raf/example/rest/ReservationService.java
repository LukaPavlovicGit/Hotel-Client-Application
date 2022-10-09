package com.raf.example.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
        response.body().close();

        if(response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Hotel added successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Hotel updated successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Hotel deleted successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room added successfully!");
        else
            throw new IOException();
    }

    public void updateRoom(RoomDto roomDto) throws IOException{ // DODAJ RUTU ZA UPDATE
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(roomDto));


        Request request = new Request.Builder()
                .url(URL + "/rooms")
                .addHeader("authorization", "token " + token)
                .put(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        response.body().close();

        if(response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room updated successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room type added successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "All room types made successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room type updated successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Room type deleted successfully!");
        else
            throw new IOException();
    }

    public AvailableRoomsListDto getAvailableRooms(AvailableRoomsFilterDto availableRoomsFilterDto) throws IOException{
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        HttpUrl.Builder httpBuilder = HttpUrl.parse(URL + "/rooms").newBuilder();
        httpBuilder.addQueryParameter("hotelName", availableRoomsFilterDto.getHotelName());
        httpBuilder.addQueryParameter("city", availableRoomsFilterDto.getCity());
        httpBuilder.addQueryParameter("startDate", String.valueOf(availableRoomsFilterDto.getStartDate()));
        httpBuilder.addQueryParameter("endDate", String.valueOf(availableRoomsFilterDto.getEndDate()));
        httpBuilder.addQueryParameter("sort", availableRoomsFilterDto.getSort());

        Request request = new Request.Builder()
                .url(httpBuilder.build())
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, AvailableRoomsListDto.class);
        else
            throw new IOException();
    }

    public void createReservation(ReservationDto reservationDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(reservationDto));

        Request request = new Request.Builder()
                .url(URL + "/reservations")
                .addHeader("authorization", "token " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Reservation made successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Reservation canceled successfully!");
        else
            throw new IOException();
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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Review added successfully!");
        else
            throw new IOException();

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
        response.body().close();

        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Review updated successfully!");
        else
            throw new IOException();

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
        response.body().close();


        if (response.isSuccessful())
            JOptionPane.showMessageDialog(null, "Review removed!");
        else
            throw new IOException();

    }

    public ReviewsListDto getAllReviews(String hotelName, String city) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful()) {
            //if(json.isEmpty()) return new ReviewsListDto();
            return objectMapper.readValue(json, ReviewsListDto.class);
        }
        else
            throw new IOException();
    }

    public ReservationsListDto getAllReservations() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/reservations")
                .addHeader("authorization", "token " + token)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.code() == 200)
            return objectMapper.readValue(json, ReservationsListDto.class);
        else
            throw new IOException();

    }

    public BestHotelsListDto getTopRatedHotels() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();
        List reviews;

        Request request = new Request.Builder()
                .url(URL + "/hotels")
                .addHeader("authorization", "token " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, BestHotelsListDto.class);
        else
            throw new IOException();
    }
}
