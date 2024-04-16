package com.martishyn.medimate.messages;

import com.martishyn.medimate.bot.BotMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface MessageProcessor {
    BotMessage onUpdateReceived(Update update);
}
