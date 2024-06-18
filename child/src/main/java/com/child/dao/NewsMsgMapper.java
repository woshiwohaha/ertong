package com.child.dao;

import com.child.model.NewsMsg;
import com.child.model.NewsMsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface NewsMsgMapper {
	long countByExample(NewsMsgExample example);
	int deleteByExample(NewsMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(NewsMsg record);
	int insertSelective(NewsMsg record);
	List<NewsMsg> selectByExample(NewsMsgExample example);
	NewsMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") NewsMsg record, @Param("example") NewsMsgExample example);
	int updateByExample(@Param("record") NewsMsg record, @Param("example") NewsMsgExample example);
	int updateByPrimaryKeySelective(NewsMsg record);
	int updateByPrimaryKey(NewsMsg record);
}
