package com.example.cryptotips.Controller;



import com.example.cryptotips.Model.DTO.PostDTO;
import com.example.cryptotips.Model.DTO.SubscriberDTO;
import com.example.cryptotips.Model.MyPost;
import com.example.cryptotips.Model.Subscriber;
import com.example.cryptotips.Service.SubscriberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class SubscriberRestController {

    private final SubscriberService subscriberService;

    public SubscriberRestController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping("/subscribers")
    public List<Subscriber> getAllSubscribers() {
        return subscriberService.findAll();
    }

    @PostMapping("/subscribers/add/{username}")
    public ResponseEntity<Subscriber> createNewSubscriber(@PathVariable String username) {
        return subscriberService.create(username)
                .map(subscriber -> ResponseEntity.ok().body(subscriber))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/subscribers/delete/{id}")
    public ResponseEntity<Subscriber> deleteSubscriber(@PathVariable Long id) {
        return subscriberService.deleteSubscriber(id)
                .map(subscriber -> ResponseEntity.ok().body(subscriber))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
