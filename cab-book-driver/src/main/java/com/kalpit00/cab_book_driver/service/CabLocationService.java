package com.kalpit00.cab_book_driver.service;

import org.springframework.stereotype.Service;

@Service
public class CabLocationService {
    public boolean updateLocation(String location) {
        System.out.println("Send coordinate using Kafka here");
        return true;
    }

}
