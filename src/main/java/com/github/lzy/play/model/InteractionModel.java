package com.github.lzy.play.model;

import com.github.lzy.play.enums.MessageType;
import lombok.Data;

/**
 * Description: 交互模型
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-27
 */
@Data
public class InteractionModel {
	private long timestamp;
	private MessageType type;
	private String payload;
}
