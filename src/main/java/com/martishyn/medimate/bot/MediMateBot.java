package com.martishyn.medimate.bot;

import com.martishyn.medimate.config.MediMateBotConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class MediMateBot extends TelegramLongPollingBot {
    private final MediMateBotConfig mediMateBotConfig;

    public MediMateBot(MediMateBotConfig mediMateBotConfig) {
        super(mediMateBotConfig.getMediMateBotToken());
        this.mediMateBotConfig = mediMateBotConfig;
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return mediMateBotConfig.getMediMateBotName();
    }

}
