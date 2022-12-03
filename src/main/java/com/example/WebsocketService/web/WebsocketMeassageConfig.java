package com.example.WebsocketService.web;

//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.converter.DefaultContentTypeResolver;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.converter.MessageConverter;
//import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

//import com.example.chitchat.interceptor.WebSocketChannelInterceptor;
//import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSocketMessageBroker
@Slf4j
public class WebsocketMeassageConfig implements WebSocketMessageBrokerConfigurer {
	
//	Logger logger = LoggerFactory.getLogger(ChatchatApplication.class);
	
	
//	private String brokerHost = "0.0.0.0";
//	private int brokerPort = 61613;//5672;//61613;//15672;//61613;
//	private String brokerUser = "guest";//"system";
//	private String brokerPass = "guest";//"manager";
	@Value("${rabbitmq.host}")
	private String brokerHost;
	
	@Value("${rabbitmq.port}")
	private int brokerPort;//5672;//61613;//15672;//61613;
	
	@Value("${rabbitmq.username}")
	private String brokerUser;//"system";
	
	@Value("${rabbitmq.password}")
	private String brokerPass;//"manager";
	
//	@Autowired
//    WebSocketChannelInterceptor channelInterceptor;
//	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		logger.info("called registerStompEndpoints()");
//		registry.addEndpoint("/chat");
//		registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
		
		
		registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
        registry.addEndpoint("/ws");
		
//		registry.addEndpoint("/chat").withSockJS();
	}
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		config.setApplicationDestinationPrefixes("/app");
//		config.enableSimpleBroker("/chatroom","/user");
//		config.setUserDestinationPrefix("/user");
		registry.enableStompBrokerRelay("/topic/", "/queue/")
        .setRelayHost(brokerHost)
        .setRelayPort(brokerPort)
        .setClientLogin(brokerUser)
        .setClientPasscode(brokerPass);

		registry.setApplicationDestinationPrefixes("/app");
	}
	
	
//	@Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(channelInterceptor);
//    }
	
}
