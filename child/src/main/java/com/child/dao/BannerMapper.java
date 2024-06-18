package com.child.dao;

import com.child.model.Banner;
import com.child.model.BannerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface BannerMapper {
	long countByExample(BannerExample example);
	int deleteByExample(BannerExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Banner record);
	int insertSelective(Banner record);
	List<Banner> selectByExample(BannerExample example);
	Banner selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);
	int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);
	int updateByPrimaryKeySelective(Banner record);
	int updateByPrimaryKey(Banner record);
}
