package com.example.shixun.service;

import com.example.shixun.mapper.MessageMapper;
import com.example.shixun.pojo.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    @Resource
    MessageMapper messageMapper;

    @Override
    public List<Message> queryMessage() {
        return messageMapper.queryMessage();
    }

    @Override
    public int addMessage(Message message) {
        return messageMapper.addMessage(message);
    }

    @Override
    public int deleteMessage(String id) {
        return messageMapper.deleteMessage(id);
    }

    @Override
    public Message queryMessageById(String id) {
        return messageMapper.queryMessageById(id);
    }

    @Override
    public int updateMessage(Message message) {
        return messageMapper.updateMessage(message);
    }

    @Override
    public List<Message> queryByMessage(String content) {
        return messageMapper.queryByMessage(content);
    }


}