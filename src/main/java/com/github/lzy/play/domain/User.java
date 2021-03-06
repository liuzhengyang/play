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
public class User {
	private Long id;
	private String name;
	private String username;
	private String password;
	private Date registerTime;
	private Date modifyTime;
}
