package com.martishyn.medimate.commands;

import com.martishyn.medimate.bot.BotMessage;
import com.martishyn.medimate.model.UserRequest;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandHandler {
    BotMessage handle(UserRequest request);

    boolean isApplicable(UserRequest request);

    default boolean isCommand(Message message) {
        return message.isCommand();
    }

    default boolean isParticularCommand(Message message, String commandName) {
        return message.getText().equals(commandName);
    }
}
