package com.benjdiya.monoapp.web;

import com.benjdiya.monoapp.dtos.NotificationDTO;
import com.benjdiya.monoapp.service.NotificationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import java.io.IOException;


import java.time.Duration;
import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    private final Sinks.Many<String> sink;

    public NotificationController() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }
    @CrossOrigin("*")
    @GetMapping(value = "/notification", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamNotifications() {

        return sink.asFlux().log()
                .mergeWith(Flux.interval(Duration.ofSeconds(5)).map(tick -> "ping"));

        // Return the Flux to subscribers

    }

    // Call this method whenever you want to send a notification
    @PostMapping("/triggerNotifications")
    public Sinks.EmitResult triggerNotifications(@RequestBody String message) {
        // Emit a new notification when an event occurs
       return sink.tryEmitNext(message);
    }
    public void triggerNotification(String message) {
        // Emit a new notification when an event occurs
       sink.tryEmitNext(message);
    }
    @GetMapping("/notifications/{id}")
    public List<NotificationDTO> notificationList(@PathVariable(name = "id") String id){
       return notificationService.notification_LIST(id);
    }
    @CrossOrigin
    @GetMapping("/welcome")
    public void notification(){
        sink.emitNext("Welcome back to our trusted Giveaways platform, sir.", Sinks.EmitFailureHandler.FAIL_FAST);
    }
}

