package com.github.lzy.play.service;

import com.github.lzy.play.model.FriendModel;

import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
public interface IFriendService {
	List<FriendModel> getFriends(Long userId);
}
