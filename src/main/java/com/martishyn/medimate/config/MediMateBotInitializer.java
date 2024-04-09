package com.martishyn.medimate.config;

import com.martishyn.medimate.bot.MediMateBot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@Slf4j
@RequiredArgsConstructor
public class MediMateBotInitializer {
    private final MediMateBot mediMateBot;

    @EventListener({ContextRefreshedEvent.class})
    public void initBot() {
        try {
            TelegramBotsApi botApi = new TelegramBotsApi(DefaultBotSession.class);
            botApi.registerBot(mediMateBot);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
