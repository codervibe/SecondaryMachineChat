package com.codervibe.secondarymachinechat.service.Impl;

import com.codervibe.secondarymachinechat.Mapper.ChatMapper;
import com.codervibe.secondarymachinechat.model.Chat;
import com.codervibe.secondarymachinechat.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 */
@Service("ChatService")
@Transactional
public class ChatServiceImpl implements ChatService {

  Logger log = LoggerFactory.getLogger(ChatService.class);

  @Autowired
  private ChatMapper chatMapper;

  @Override
  public Chat getAnswerbyquestion(Chat chat) {
    Chat resultChat = chatMapper.getAnswerbyquestion(chat);
    if (!resultChat.equals(null)) {

      return resultChat;
    }
    resultChat.setAnswer("问题不存在");
    return resultChat;
  }
}
