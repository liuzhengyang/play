package com.github.lzy.play.controller;

import com.github.lzy.play.domain.User;
import com.github.lzy.play.model.FriendModel;
import com.github.lzy.play.service.IFriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/")
@Controller
public class PageController {

	@Resource
	private IFriendService friendService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/talk")
	public String talk(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<FriendModel> friends = friendService.getFriends(user.getId());

		model.addAttribute("user", user);
		model.addAttribute("friends", friends);
		return "talk";
	}
}
