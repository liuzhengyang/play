package com.github.lzy.play.mapper;

import com.github.lzy.play.domain.Friend;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
public interface FriendMapper {
	@Select("SELECT * FROM friend where from_id = #{userId}")
	public List<Friend> friendList(@Param("userId") Long userId);
}
