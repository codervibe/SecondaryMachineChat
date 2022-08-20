package com.codervibe.secondarymachinechat.Mapper;

import com.codervibe.secondarymachinechat.model.Chat;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 */
@Mapper
public interface ChatMapper {
    /**
     * 根据问题进行回答
     * @param chat
     * @return Chat chat
     */
    Chat  getAnswerbyquestion(Chat chat);
}
