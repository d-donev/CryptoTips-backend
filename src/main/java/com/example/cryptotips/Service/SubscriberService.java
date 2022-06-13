package com.example.cryptotips.Service;

import com.example.cryptotips.Model.DTO.SubscriberDTO;
import com.example.cryptotips.Model.Subscriber;

import java.util.List;
import java.util.Optional;

public interface SubscriberService {

    List<Subscriber> findAll();

    Subscriber findById(Long id);

    Optional<Subscriber> create(String username);

    Optional<Subscriber> addSubscriber(SubscriberDTO subscriberDTO);

    Optional<Subscriber> deleteSubscriber(Long id);

}
