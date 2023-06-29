package com.example.shixun.mapper;

import com.example.shixun.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MessageMapper {

    List<Message> queryMessage();

    int addMessage(Message message);

    int deleteMessage(String id);
    Message queryMessageById(String id);
    int updateMessage(Message message);

    List<Message> queryByMessage(String content);
}
