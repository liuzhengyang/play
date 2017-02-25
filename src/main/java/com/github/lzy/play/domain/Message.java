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
	private String content;
	private Date sendTime;
	private Long senderId;
	// 可能是发给用户的消息，就是用户id，若是群消息则是群id
	private Long receiverId;
	// 消息状态，0未读，1，已读，2，撤回，3，删除
	private int status;

}
