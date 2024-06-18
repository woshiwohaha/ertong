package com.child.dao;

import com.child.model.DonateLog;
import com.child.model.DonateLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface DonateLogMapper {
	long countByExample(DonateLogExample example);
	int deleteByExample(DonateLogExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(DonateLog record);
	int insertSelective(DonateLog record);
	List<DonateLog> selectByExample(DonateLogExample example);
	DonateLog selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") DonateLog record, @Param("example") DonateLogExample example);
	int updateByExample(@Param("record") DonateLog record, @Param("example") DonateLogExample example);
	int updateByPrimaryKeySelective(DonateLog record);
	int updateByPrimaryKey(DonateLog record);
}
