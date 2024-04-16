package com.martishyn.medimate.bot;

import com.martishyn.medimate.config.MediMateBotConfig;
import com.martishyn.medimate.messages.DefaultMessageProcessor;
import com.martishyn.medimate.messages.MessageProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Slf4j
public class MediMateBot extends TelegramLongPollingBot {
    private final MediMateBotConfig mediMateBotConfig;
    private final MessageProcessor messageProcessor;

    public MediMateBot(MediMateBotConfig mediMateBotConfig, MessageProcessor messageProcessor) {
        super(mediMateBotConfig.getMediMateBotToken());
        this.mediMateBotConfig = mediMateBotConfig;
        this.messageProcessor = messageProcessor;
    }

    @Override
    public void onUpdateReceived(Update update) {
        var message = messageProcessor.onUpdateReceived(update);
        message.send(this);
    }

    @Override
    public String getBotUsername() {
        return mediMateBotConfig.getMediMateBotName();
    }
}