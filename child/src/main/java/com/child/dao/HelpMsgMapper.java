package com.child.dao;

import com.child.model.HelpMsg;
import com.child.model.HelpMsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface HelpMsgMapper {
	long countByExample(HelpMsgExample example);
	int deleteByExample(HelpMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(HelpMsg record);
	int insertSelective(HelpMsg record);
	List<HelpMsg> selectByExample(HelpMsgExample example);
	HelpMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") HelpMsg record, @Param("example") HelpMsgExample example);
	int updateByExample(@Param("record") HelpMsg record, @Param("example") HelpMsgExample example);
	int updateByPrimaryKeySelective(HelpMsg record);
	int updateByPrimaryKey(HelpMsg record);
}
