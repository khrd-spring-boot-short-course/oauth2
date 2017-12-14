package com.phearun.rest;

import com.phearun.model.Message;
import com.phearun.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/messages")
public class MessageRestController {

    private MessageRepository messageRepository;

    @Autowired
    public MessageRestController(MessageRepository messageRepository) {
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

    @PreAuthorize("#oauth2.hasScope('write')")
    @PostMapping
    public Message saveMessage(@RequestBody Message message){
        return messageRepository.save(message);
    }

}
