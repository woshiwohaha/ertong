package com.child.dao;

import com.child.model.JoinLog;
import com.child.model.JoinLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface JoinLogMapper {
	long countByExample(JoinLogExample example);
	int deleteByExample(JoinLogExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(JoinLog record);
	int insertSelective(JoinLog record);
	List<JoinLog> selectByExample(JoinLogExample example);
	JoinLog selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") JoinLog record, @Param("example") JoinLogExample example);
	int updateByExample(@Param("record") JoinLog record, @Param("example") JoinLogExample example);
	int updateByPrimaryKeySelective(JoinLog record);
	int updateByPrimaryKey(JoinLog record);
}
