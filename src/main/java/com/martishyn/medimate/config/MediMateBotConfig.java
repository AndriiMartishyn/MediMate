package com.martishyn.medimate.config;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@RequiredArgsConstructor
public class MediMateBotConfig {
    @Value("${medimate_bot_name}")
    private String mediMateBotName;

    @Value("${medimate_token_id}")
    private String mediMateBotToken;
}
