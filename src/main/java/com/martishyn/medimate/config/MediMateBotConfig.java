package com.martishyn.medimate.config;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Configuration
@Getter
@Setter
@RequiredArgsConstructor
public class MediMateBotConfig {
    @Value("${medimate_bot_name}")
    private String mediMateBotName;

    @Value("${medimate_token_id}")
    private String mediMateBotToken;

    @Bean
    public SendMessage getSendMessageBean(){
        return new SendMessage();
    }
}
