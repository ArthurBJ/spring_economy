package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.forms.MessageForm;
import group907.baybikov.springwitch.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String chat(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("username", userDetails.getUser().getEmail());
        return "chat";
    }

    @MessageMapping("/chat")
    @SendTo("/chat/messages")
    public MessageForm getMessages(MessageForm message) {
        return message;
    }
}
