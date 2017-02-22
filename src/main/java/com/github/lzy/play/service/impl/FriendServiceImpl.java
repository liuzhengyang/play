package com.github.lzy.play.service.impl;

import com.github.lzy.play.domain.Friend;
import com.github.lzy.play.domain.User;
import com.github.lzy.play.mapper.FriendMapper;
import com.github.lzy.play.mapper.UserMapper;
import com.github.lzy.play.model.FriendModel;
import com.github.lzy.play.model.UserModel;
import com.github.lzy.play.service.IFriendService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
@Service
public class FriendServiceImpl implements IFriendService {
	@Resource
	private FriendMapper friendMapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public List<FriendModel> getFriends(Long userId) {
		List<Friend> friends = friendMapper.friendList(userId);
		List<FriendModel> friendModels = new ArrayList<>();

		if (CollectionUtils.isNotEmpty(friends)) {
			for (Friend friend : friends) {
				Long toId = friend.getToId();
				User userById = userMapper.getUserById(toId);
				FriendModel friendModel = new FriendModel();
				UserModel userModel = new UserModel();
				userModel.setId(userById.getId());
				userModel.setUsername(userById.getUsername());
				friendModel.setUserModel(userModel);
				friendModels.add(friendModel);
			}
		}
		return friendModels;
	}
}
