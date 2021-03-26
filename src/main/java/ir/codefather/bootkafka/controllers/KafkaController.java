package ir.codefather.bootkafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ir.codefather.bootkafka.kafka.Producer;

@RestController
public class KafkaController {
    @Autowired
    private Producer producer;

    @GetMapping("/publish/{message}")
    public String publish(@PathVariable String message) {
        producer.sendMessage(message);

        return "Message has been produced";
    }
}
