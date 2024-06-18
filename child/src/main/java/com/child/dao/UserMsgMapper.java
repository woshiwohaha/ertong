package com.child.dao;

import com.child.model.UserMsg;
import com.child.model.UserMsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface UserMsgMapper {
	long countByExample(UserMsgExample example);
	int deleteByExample(UserMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(UserMsg record);
	int insertSelective(UserMsg record);
	List<UserMsg> selectByExample(UserMsgExample example);
	UserMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") UserMsg record, @Param("example") UserMsgExample example);
	int updateByExample(@Param("record") UserMsg record, @Param("example") UserMsgExample example);
	int updateByPrimaryKeySelective(UserMsg record);
	int updateByPrimaryKey(UserMsg record);
}
