package com.github.lzy.play.service;

import com.github.lzy.play.model.UserModel;

import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
public interface IUserService {
	UserModel getUserById(Long userId);

	List<UserModel> getUsersByIdList(List<Long> userIds);
}
