package com.example.WebsocketService.controller;

//import javax.jms.JMSException;
//import javax.jms.Message;

//import org.apache.activemq.command.ActiveMQTopic;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

//import com.example.chitchat.interceptor.CustomMessageSender;
//import com.example.chitchat.model.CustomMessage;
//import com.example.chitchat.service.ActiveMQService;

@Controller
public class ChatController {

//	@MessageMapping("/chat")
//	@SendTo("/topic/messages")
//	public OutputMessage sendMessage(InputMessage message) {
//		String time = new SimpleDateFormat("HH:mm").format(new Date());
//		return new OutputMessage(message.getFrom(), message.getText(), time);
//	}
//	Logger logger = LoggerFactory.getLogger(ChatchatApplication.class);
	
//	@Autowired
//	private SimpMessagingTemplate simpMessagingTemplate;
//	
//	@Autowired
//	private ActiveMQService activeMQService;
	
//	@Autowired
//	private MessageConverter messageConverter;
	
//	@Autowired
//	private JmsTemplate jmsTemplate;
	
//	@MessageMapping("/message")
//	@SendTo("/chatroom/public")
//    public CustomMessage receiveMessage(@Payload CustomMessage message){
//		System.out.println("receiveMessage - "+message);
//        return message;
//    }
	
	@MessageMapping("/message/{topic}")
	@SendTo("/topic/{topic}")
    public String receiveMessage(@Payload String message){
		System.out.println("Calling publicMessage");
        return message;
    }
	
	@MessageMapping("/private-message/{queue}")
	@SendTo("/queue/{queue}")
    public String privateMessage(@Payload String message){
		System.out.println("Calling privateMessage");
//		System.out.println("message.getDestination() - "+message.getDestination());
//        simpMessagingTemplate.convertAndSendToUser(message.getDestination(),"/private",message);
//        System.out.println("recMessage - "+message.toString());
        return message;
    }
	
//	@MessageMapping("/message")
////	@SendTo("/chatroom/public")
//	public String receiveMessage(@Payload String message){
////		System.out.println("receiveMessage - "+message);
//		String customMessage = null;
//		try {
////			CustomMessageSender customMessageSender = new CustomMessageSender();
//			activeMQService.createTopicAndSendMessage(message, "VirtualTopic.GROUPCHAT");
////			customMessage = activeMQService.subscribeAndgetMessage("Consumer.myConsumer1.VirtualTopic.GROUPCHAT");
////			System.out.println("RECEIVED MESSAGE");
////			System.out.println(customMessage);
//			simpMessagingTemplate.convertAndSend("/chatroom/public", customMessage);
////			simpMessagingTemplate.convertAndSend("Consumer.myConsumer2.VirtualTopic.GROUPCHAT", message);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//      return message;
//  }
//	

//	@MessageMapping("/messsage")
//    public CustomMessage testMessage(@Payload CustomMessage message){
//		System.out.println("testMessage - "+message);
//		try {
//			CustomMessageSender customMessageSender = new CustomMessageSender();
//			customMessageSender.sendMessage(message, "VirtualTopic.GROUPCHAT");
//		} catch (JMSException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
//        return message;
//    }

	
//	@MessageMapping("/private-message")
//    public CustomMessage recMessage(@Payload CustomMessage message){
//		System.out.println("message.getDestination() - "+message.getDestination());
//        simpMessagingTemplate.convertAndSendToUser(message.getDestination(),"/private",message);
//        System.out.println("recMessage - "+message.toString());
//        return message;
//    }
}
