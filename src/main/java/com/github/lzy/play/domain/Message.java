package com.github.lzy.play.domain;

import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
@Data
public class Message {
	private Long id;
	private Long content;
	private Date sendTime;
	private Long fromUserId;
	// 可能是发给用户的消息，就是用户id，若是群消息则是群id
	private Long toId;

}
