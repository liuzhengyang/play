package com.github.lzy.play.param;

import lombok.Data;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-24
 */
@Data
public class MessageParam {
	private long senderId;
	private long sendTime;
	private long receiverId;
	private String content;
}
