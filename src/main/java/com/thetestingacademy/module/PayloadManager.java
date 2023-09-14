package com.thetestingacademy.module;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thetestingacademy.payload.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PayloadManager {
    // Java to JSON
    // Create a Payload

    ObjectMapper objectMapper;
    createUpdatePayload cup, cup1;
    Bookingdates bd, bd1;

    zippoPayloadINMain zpin;

    Auth auth;

    public String createAuth() throws JsonProcessingException {
        auth = new Auth();
        auth.setUsername("abc@test.com");
        auth.setPassword("Test@123");
        objectMapper = new ObjectMapper();
        String convertedJSONPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(auth);
        return convertedJSONPayload;
    }

    public String createPayload() throws JsonProcessingException {

        cup = new createUpdatePayload();
        bd = new Bookingdates();
        bd.setCheckin("2023-07-05");
        bd.setCheckout("2019-01-01");
        cup.setFirstname("Sanjay");
        cup.setLastname("Kumar");
        cup.setTotalprice("23423.234");
        cup.setDepositpaid(true);
        cup.setBookingdates(bd);
        cup.setAdditionalneeds("Breakfast");

        // Convert from jackson object to json or String - Deserialization
        objectMapper = new ObjectMapper();
        String convertedJSONPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cup);
        return convertedJSONPayload;
//        System.out.println(convertedJSON);

//        // From String to Jackson object - Serialization
//        createUpdatePayload cup1 = objectMapper.readValue(payload,createUpdatePayload.class);
//        System.out.println(cup1.getFirstname());

    }

    public String updatePayload() throws JsonProcessingException {
        cup1 = new createUpdatePayload();
        bd1 = new Bookingdates();
        bd1.setCheckin("2023-07-06");
        bd1.setCheckout("2022-02-03");
        cup1.setFirstname("Darsh");
        cup1.setLastname("Sah");
        cup1.setTotalprice("1234.1234");
        cup1.setDepositpaid(false);
        cup1.setBookingdates(bd1);
        cup1.setAdditionalneeds("Pizza");

        // Convert from jackson object to json or String - Deserialization
        objectMapper = new ObjectMapper();
        String convertedJSONPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cup1);
        return convertedJSONPayload;
    }

    public String createZippoPayload() throws JsonProcessingException {
        List<Place> places = new ArrayList<>();
        zpin = new zippoPayloadINMain();
        zpin.setCountry("India");
        zpin.setPostcode(110001);
        zpin.setCountryAbb("IN");
        zpin.setPlaces(places);

        Place place1 = new Place();
        place1.setPlaceName("Janpath");
        place1.setLongitude(77.2167);
        place1.setLatitude(28.6333);
        place1.setState("New Delhi");
        place1.setStateAbb("DL");
        places.add(place1);

        Place place2 = new Place();
        place2.setPlaceName("Rail Bhawan");
        place2.setLongitude(77.2167);
        place2.setLatitude(28.6333);
        place2.setState("New Delhi");
        place2.setStateAbb("DL");
        places.add(place2);

        Place place3 = new Place();
        place3.setPlaceName("Connaught Place");
        place3.setLongitude(77.2167);
        place3.setLatitude(28.6333);
        place3.setState("New Delhi");
        place3.setStateAbb("DL");
        places.add(place3);

        Place place4 = new Place();
        place4.setPlaceName("Sansadiya Soudha");
        place4.setLongitude(77.2167);
        place4.setLatitude(28.6333);
        place4.setState("New Delhi");
        place4.setStateAbb("DL");
        places.add(place4);

        Place place5 = new Place();
        place5.setPlaceName("Sectt North");
        place5.setLongitude(77.2167);
        place5.setLatitude(28.6333);
        place5.setState("New Delhi");
        place5.setStateAbb("DL");
        places.add(place5);

        Place place6 = new Place();
        place6.setPlaceName("Constitution House");
        place6.setLongitude(77.2167);
        place6.setLatitude(28.6333);
        place6.setState("New Delhi");
        place6.setStateAbb("DL");
        places.add(place6);

        Place place7 = new Place();
        place7.setPlaceName("Eastern Court");
        place7.setLongitude(77.2167);
        place7.setLatitude(28.6333);
        place7.setState("New Delhi");
        place7.setStateAbb("DL");
        places.add(place7);

        Place place8 = new Place();
        place8.setPlaceName("Supreme Court");
        place8.setLongitude(77.2167);
        place8.setLatitude(28.6333);
        place8.setState("New Delhi");
        place8.setStateAbb("DL");
        places.add(place8);

        Place place9 = new Place();
        place9.setPlaceName("Parliament House");
        place9.setLongitude(77.2167);
        place9.setLatitude(28.6333);
        place9.setState("New Delhi");
        place9.setStateAbb("DL");
        places.add(place9);

        Place place10 = new Place();
        place10.setPlaceName("Parliament Street H O");
        place10.setLongitude(77.2167);
        place10.setLatitude(28.6333);
        place10.setState("New Delhi");
        place10.setStateAbb("DL");
        places.add(place10);

        Place place11 = new Place();
        place11.setPlaceName("Laxminarain Mandir");
        place11.setLongitude(77.2167);
        place11.setLatitude(28.6333);
        place11.setState("New Delhi");
        place11.setStateAbb("DL");
        places.add(place11);

        Place place12 = new Place();
        place12.setPlaceName("New Delhi G P O");
        place12.setLongitude(77.2167);
        place12.setLatitude(28.6333);
        place12.setState("New Delhi");
        place12.setStateAbb("DL");
        places.add(place12);

        Place place13 = new Place();
        place13.setPlaceName("Krishi Bhawan");
        place13.setLongitude(77.2167);
        place13.setLatitude(28.6333);
        place13.setState("New Delhi");
        place13.setStateAbb("DL");
        places.add(place13);

        Place place14 = new Place();
        place14.setPlaceName("Lady Harding Medical College");
        place14.setLongitude(77.2167);
        place14.setLatitude(28.6333);
        place14.setState("New Delhi");
        place14.setStateAbb("DL");
        places.add(place14);

        Place place15 = new Place();
        place15.setPlaceName("Election Commission");
        place15.setLongitude(77.2167);
        place15.setLatitude(28.6333);
        place15.setState("New Delhi");
        place15.setStateAbb("DL");
        places.add(place15);

        Place place16 = new Place();
        place16.setPlaceName("North Avenue");
        place16.setLongitude(77.2167);
        place16.setLatitude(28.6333);
        place16.setState("New Delhi");
        place16.setStateAbb("DL");
        places.add(place16);

        Place place17 = new Place();
        place17.setPlaceName("Pragati Maidan");
        place17.setLongitude(77.2167);
        place17.setLatitude(28.6333);
        place17.setState("New Delhi");
        place17.setStateAbb("DL");
        places.add(place17);

        Place place18 = new Place();
        place18.setPlaceName("Patiala House");
        place18.setLongitude(77.2167);
        place18.setLatitude(28.6333);
        place18.setState("New Delhi");
        place18.setStateAbb("DL");
        places.add(place18);

        Place place19 = new Place();
        place19.setPlaceName("Shastri Bhawan");
        place19.setLongitude(77.2167);
        place19.setLatitude(28.6333);
        place19.setState("New Delhi");
        place19.setStateAbb("DL");
        places.add(place19);


        objectMapper = new ObjectMapper();
        String zippoINPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(zpin);
        return zippoINPayload;
    }


}
