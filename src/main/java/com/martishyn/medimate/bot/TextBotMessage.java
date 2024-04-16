package com.martishyn.medimate.bot;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Builder
@RequiredArgsConstructor
@Component
public class TextBotMessage implements BotMessage{
    private final SendMessage message;

    @Override
    public void send(MediMateBot bot) {
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
