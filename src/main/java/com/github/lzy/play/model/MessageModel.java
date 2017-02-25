package com.github.lzy.play.model;

import lombok.Data;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-24
 */
@Data
public class MessageModel {
	private Long messageId;
	private Long senderId;
	private Long receiverId;
	private String sendUserName;
	private String content;
	private long sendTimeMillis;
}
