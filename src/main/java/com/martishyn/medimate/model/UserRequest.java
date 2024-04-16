package com.martishyn.medimate.model;

import lombok.Builder;
import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.Update;

@Data
@Builder
public class UserRequest {
    private final Update update;
    private final Long chatId;
}
