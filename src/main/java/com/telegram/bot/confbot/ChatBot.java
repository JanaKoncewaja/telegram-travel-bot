package com.telegram.bot.confbot;

import com.telegram.bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@PropertySource("classpath:telegram.properties")
public class ChatBot extends TelegramLongPollingBot {


    private CityService cityService;
    private final Logger logger;

    @Autowired
    public ChatBot(CityService cityService,@Qualifier("chatBotLogger") Logger logger) {
        this.cityService = cityService;
        this.logger = logger;
    }

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update!=null) {
            String message = update.getMessage().getText();
            sendMsg(update.getMessage().getChatId().toString(), message);
        }
    }

    public synchronized void sendMsg(String chatId, String userMessage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(cityService.searchMessageByCityName(userMessage));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
           logger.log(Level.WARNING,"Sending response failed");
        }

    }


}


