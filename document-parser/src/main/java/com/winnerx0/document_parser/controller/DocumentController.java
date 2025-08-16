package com.winnerx0.document_parser.controller;

import com.winnerx0.document_parser.config.RabbitmqConfig;
import com.winnerx0.document_parser.model.DocumentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/document")
public class DocumentController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("send-document")
    public ResponseEntity<String> sendDocument(@Valid  @ModelAttribute DocumentRequest documentRequest){
        // sends the message to the exchange
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, "document", documentRequest.name());
        return ResponseEntity.ok("success");
    }
}
