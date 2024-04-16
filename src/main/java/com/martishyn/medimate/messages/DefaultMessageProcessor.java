package com.martishyn.medimate.messages;

import com.martishyn.medimate.bot.BotMessage;
import com.martishyn.medimate.commands.CommandHandler;
import com.martishyn.medimate.exceptions.NoSuchHandlerFoundException;
import com.martishyn.medimate.model.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultMessageProcessor implements MessageProcessor {
    private final List<CommandHandler> commandHandlerList;

    @Override
    public BotMessage onUpdateReceived(Update update) {
            long chatId = update.getMessage().getChatId();
            UserRequest userRequest = UserRequest
                    .builder()
                    .chatId(chatId)
                    .update(update)
                    .build();
            return commandHandlerList.stream()
                    .filter(commandHandler -> commandHandler.isApplicable(userRequest))
                    .findFirst()
                    .map(x -> x.handle(userRequest))
                    .orElseThrow(NoSuchHandlerFoundException::new);
    }
}
