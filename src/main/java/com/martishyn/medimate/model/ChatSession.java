package com.martishyn.medimate.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatSession {
    private Long chatId;
    private String text;
}
