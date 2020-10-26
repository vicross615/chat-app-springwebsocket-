package controller;

import model.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
import storage.UserRepo;

@RestController
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message)  {
        System.out.println("Handling sent message-- " + message + "--to"+ to);
        boolean isExist = UserRepo.getInstance().getUsers().contains(to);

        if(isExist) {
            simpMessagingTemplate.convertAndSend("/topic/messages/"+to, message);
        }
    }
}
