package com.example.inboxgmailapp;

public class Message {
    private String userProfile;
    private String username;
    private String messageContent;

    public Message(String username, String messageContent) {
        this.username = username;
        this.messageContent = messageContent;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return messageContent;
    }
}
