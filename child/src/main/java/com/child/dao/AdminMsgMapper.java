package com.child.dao;

import com.child.model.AdminMsg;
import com.child.model.AdminMsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface AdminMsgMapper {
	long countByExample(AdminMsgExample example);
	int deleteByExample(AdminMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(AdminMsg record);
	int insertSelective(AdminMsg record);
	List<AdminMsg> selectByExample(AdminMsgExample example);
	AdminMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") AdminMsg record, @Param("example") AdminMsgExample example);
	int updateByExample(@Param("record") AdminMsg record, @Param("example") AdminMsgExample example);
	int updateByPrimaryKeySelective(AdminMsg record);
	int updateByPrimaryKey(AdminMsg record);
}
