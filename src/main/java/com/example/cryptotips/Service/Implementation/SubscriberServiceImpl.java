package com.example.cryptotips.Service.Implementation;


import com.example.cryptotips.Model.DTO.PostDTO;
import com.example.cryptotips.Model.DTO.SubscriberDTO;
import com.example.cryptotips.Model.Exceptions.SubscriberNotFoundException;
import com.example.cryptotips.Model.MyPost;
import com.example.cryptotips.Model.Subscriber;
import com.example.cryptotips.Repository.SubscriberRepository;
import com.example.cryptotips.Service.SubscriberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository subscriberRepository;

    public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public List<Subscriber> findAll() {
        return subscriberRepository.findAll();
    }


    @Override
    public Subscriber findById(Long id) {
        return subscriberRepository.findById(id).orElseThrow(() -> new SubscriberNotFoundException(id));
    }

    @Override
    public Optional<Subscriber> create(String username) {
        Subscriber subscriber = new Subscriber(username);
        return Optional.of(subscriberRepository.save(subscriber));
    }


    @Override
    public Optional<Subscriber> addSubscriber(SubscriberDTO subscriberDTO) {
        Subscriber subscriber = new Subscriber(subscriberDTO.getUsername());
        return Optional.of(subscriberRepository.save(subscriber));
    }


    @Override
    public Optional<Subscriber> deleteSubscriber(Long id) {
        Subscriber subscriber = subscriberRepository.findById(id).orElseThrow(() -> new SubscriberNotFoundException(id));
        subscriberRepository.delete(subscriber);
        return Optional.of(subscriber);
    }
}
