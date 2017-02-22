package com.github.lzy.play.mapper;

import com.github.lzy.play.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
@Mapper
public interface UserMapper {

	@Select("SELECT * FROM USER where id = #{id}")
	User getUserById(Long id);
}
