package com.phearun.rest;

import com.phearun.model.Message;
import com.phearun.repository.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/public/messages")
public class PublicMessageRestController {

    private MessageRepository messageRepository;

    public PublicMessageRestController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @RequestMapping
    public Collection<Message> getMessage(){
        return messageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Message findMessageById(@PathVariable Integer id){
        return messageRepository.findOne(id);
    }
}
