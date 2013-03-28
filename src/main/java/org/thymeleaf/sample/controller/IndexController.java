package org.thymeleaf.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.sample.beans.User;

@Controller
public class IndexController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String view(Model model) {
		return "index";
	}

	@RequestMapping(value="/text", method=RequestMethod.GET)
	public String text(Model model) {
		String text = "hello";
		model.addAttribute("text", text);

		String escapedText = "hello&lt;";
		model.addAttribute("escapedText", escapedText);

		String unescapedText = "hello<";
		model.addAttribute("unescapedText", unescapedText);

		User user = new User();
		user.setName("taro");
		user.setImageUrl("taro_profile.jpg");
		user.setSex(0);
		model.addAttribute("user", user);

		return "text";
	}

	@RequestMapping(value="/iteration", method=RequestMethod.GET)
	public String iteration(Model model) {
		User user = new User();
		user.setName("taro");
		user.setImageUrl("taro_profile.jpg");
		user.setSex(0);

		User user2 = new User();
		user2.setName("hanako");
		user2.setImageUrl("hanako_profile.jpg");
		user2.setSex(1);

		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);

		model.addAttribute("userList", userList);

		Map<String, User> userMap = new HashMap<>();
		userMap.put("taro", user);
		userMap.put("hanako", user2);
		model.addAttribute("userMap", userMap);

		return "iteration";
	}

	@RequestMapping(value="/removing", method=RequestMethod.GET)
	public String removing(Model model) {
		User user = new User();
		user.setName("taro");
		user.setImageUrl("taro_profile.jpg");
		user.setSex(0);

		User user2 = new User();
		user2.setName("hanako");
		user2.setImageUrl("hanako_profile.jpg");
		user2.setSex(1);

		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);

		model.addAttribute("userList", userList);

		Map<String, User> userMap = new HashMap<>();
		userMap.put("taro", user);
		userMap.put("hanako", user2);
		model.addAttribute("userMap", userMap);
		return "removing";
	}

	@RequestMapping(value="/conditional", method=RequestMethod.GET)
	public String conditional(Model model) {
		User user = new User();
		user.setName("taro");
		user.setImageUrl("taro_profile.jpg");
		user.setSex(0);

		model.addAttribute("user", user);
		return "conditional";
	}

	@RequestMapping(value="/local", method=RequestMethod.GET)
	public String local(Model model) {
		return "local";
	}

	@RequestMapping(value="/including", method=RequestMethod.GET)
	public String include(Model model) {
		return "including";
	}

	@RequestMapping(value="/inline", method=RequestMethod.GET)
	public String inline(Model model) {
		String text = "hello";
		model.addAttribute("text", text);

		User user = new User();
		user.setName("taro");
		user.setImageUrl("taro_profile.jpg");
		user.setSex(0);
		model.addAttribute("user", user);

		User user2 = new User();
		user2.setName("hanako");
		user2.setImageUrl("hanako_profile.jpg");
		user2.setSex(1);

		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);

		model.addAttribute("userList", userList);
		return "inline";
	}

	@RequestMapping(value="/dialect", method=RequestMethod.GET)
	public String dialect(Model model) {
		return "dialect";
	}

	@RequestMapping(value="/example", method=RequestMethod.GET)
	public String example(Model model) {
		String text = "hello world";
		model.addAttribute("text", text);
		
		User user = new User();
		user.setName("taro");
		user.setImageUrl("taro_profile.jpg");
		user.setSex(0);

		User user2 = new User();
		user2.setName("hanako");
		user2.setImageUrl("hanako_profile.jpg");
		user2.setSex(1);

		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);

		model.addAttribute("userList", userList);

		Map<String, User> userMap = new HashMap<>();
		userMap.put("taro", user);
		userMap.put("hanako", user2);
		model.addAttribute("userMap", userMap);
		return "example";
	}
}
