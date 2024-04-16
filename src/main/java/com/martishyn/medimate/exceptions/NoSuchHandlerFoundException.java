package com.martishyn.medimate.exceptions;

import com.martishyn.medimate.bot.BotMessage;

public class NoSuchHandlerFoundException extends RuntimeException{
    public NoSuchHandlerFoundException() {
    }

    public NoSuchHandlerFoundException(BotMessage botMessage) {
    }
}
