package com.martishyn.medimate.commands.impl;

import com.martishyn.medimate.bot.BotMessage;
import com.martishyn.medimate.bot.TextBotMessage;
import com.martishyn.medimate.commands.CommandHandler;
import com.martishyn.medimate.model.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommandHandler implements CommandHandler {

    @Override
    public BotMessage handle(UserRequest request) {
        var chatId = request.getChatId();
        var startMessage = SendMessage.builder()
                .chatId(chatId)
                .text("Вітаємо в нашому чат боті! Ви можете запитати в мене що вас турбує "
                        + "і може я зможу вам щось порекомендувати і показати де це можна " +
                        "придбати!\n" + "Але пам'ятайте що я використовую ChatGPT і краще " +
                        "консультації з лікарем нічого не існує :)")
                .build();
        return TextBotMessage.builder()
                .message(startMessage)
                .build();
    }

    @Override
    public boolean isApplicable(UserRequest request) {
        var message = request.getUpdate().getMessage();
        return isCommand(message) && isParticularCommand(message, "/start");
    }
}