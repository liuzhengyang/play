package com.github.lzy.play.enums;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-27
 */
public enum MessageType {
	MSG_LIST("msg_list"),
	SEND_MSG("send_msg"),
	;
	private String type;

	MessageType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
