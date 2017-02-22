package com.github.lzy.play.controller;

import com.github.lzy.play.domain.Friend;
import com.github.lzy.play.domain.User;
import com.github.lzy.play.mapper.FriendMapper;
import com.github.lzy.play.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


	@Resource
	private UserMapper userMapper;
	@Resource
	private FriendMapper friendMapper;

	@RequestMapping("/login")
	public Object login(String username, String password, Model model, HttpSession session) {
		LOGGER.info("Username {}, password {}", username, password);
		User user = userMapper.getUserByUsernameAndPassword(username, password);

		session.setAttribute("user", user);
		return "redirect:/talk";
	}

	@RequestMapping("/friends")
	@ResponseBody
	public Object getFriends(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Friend> friends = friendMapper.friendList(user.getId());
		return friends;
	}
}
