package com.example.shixun.service;

import com.example.shixun.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MessageService {
    List<Message> queryMessage();
    int addMessage(Message message);
    int deleteMessage(String id);
    Message queryMessageById(String id);
    int updateMessage(Message message);
    List<Message> queryByMessage(String content);
}
