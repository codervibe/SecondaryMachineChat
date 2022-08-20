package com.codervibe.secondarymachinechat.service;

import com.codervibe.secondarymachinechat.model.Chat;

/**
 * @author Administrator
 */
public interface ChatService {
    /**
     * 根据问题进行回答
     * @param chat
     * @return Chat chat
     */
    Chat getAnswerbyquestion(Chat chat);
}
