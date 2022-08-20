package com.codervibe.secondarymachinechat.controller;

import com.codervibe.secondarymachinechat.model.Chat;
import com.codervibe.secondarymachinechat.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
 * Created by Administrator on 2020/8/8  0008
 * DateTime:2020/08/08 16:50
 * Description:
 * Others:
 */

/**
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/chat")
public class ChatController {
    Logger log = LoggerFactory.getLogger(ChatController.class);

    @Resource
    private ChatService chatService;

    @PostMapping(value = "/answer")
    public Chat answer(@RequestBody @Validated Chat chat) {
        String question = chat.getQuestion();
        log.info("收到问题:{}", question);

        try {

            Chat resultChat = chatService.getAnswerbyquestion(chat);

            log.info("根据问题查询出来的回答为：{}", resultChat);
            chat.setAnswer(resultChat.getAnswer());
        } catch (NullPointerException e) {
            log.warn("问题在数据库中没有对应的回答导致报错");
            log.error("具体信息{}", e.getMessage());
            chat.setAnswer("主人您还没教我这个问题的答案呢，在我的数据库中并没有这个问题的答案");
        }
        log.info("{}", chat);
        return chat;
    }


}
