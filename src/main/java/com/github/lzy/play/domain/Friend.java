package com.github.lzy.play.domain;

import lombok.Data;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
@Data
public class Friend {
	private Long id;
	private Long fromId;
	private Long toId;
}
