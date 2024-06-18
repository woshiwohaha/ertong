package com.child.dao;

import com.child.model.ActMsg;
import com.child.model.ActMsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ActMsgMapper {
	long countByExample(ActMsgExample example);
	int deleteByExample(ActMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(ActMsg record);
	int insertSelective(ActMsg record);
	List<ActMsg> selectByExample(ActMsgExample example);
	ActMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") ActMsg record, @Param("example") ActMsgExample example);
	int updateByExample(@Param("record") ActMsg record, @Param("example") ActMsgExample example);
	int updateByPrimaryKeySelective(ActMsg record);
	int updateByPrimaryKey(ActMsg record);
}
