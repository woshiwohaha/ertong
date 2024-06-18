package com.child.dao;

import com.child.model.NewsDis;
import com.child.model.NewsDisExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface NewsDisMapper {
	long countByExample(NewsDisExample example);
	int deleteByExample(NewsDisExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(NewsDis record);
	int insertSelective(NewsDis record);
	List<NewsDis> selectByExample(NewsDisExample example);
	NewsDis selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") NewsDis record, @Param("example") NewsDisExample example);
	int updateByExample(@Param("record") NewsDis record, @Param("example") NewsDisExample example);
	int updateByPrimaryKeySelective(NewsDis record);
	int updateByPrimaryKey(NewsDis record);
}
