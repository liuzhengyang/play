package com.github.lzy.play.service;

import com.github.lzy.play.domain.Message;

import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-24
 */
public interface IMessageService {
	void sendMessage(Message message);
	List<Message> getMessageList(Long userId);
}
