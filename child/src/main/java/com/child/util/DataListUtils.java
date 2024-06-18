package com.child.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*
数据列表解释器，键值对列举说明工具，例如性别字段：1表示男，2表示女
*
*/
public class DataListUtils {
	public static void main(String[] args) {
	}
	/**
	**获取登录角色列表
	*/
	public static List<Map<String,Object>> getLoginTypeList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","admin"));
		list.add(getMap("2","user"));
		return list;
	}
	/**
	**获取act_status数据列表
	*/
	public static List<Map<String,Object>> getActStatusList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","通过"));
		list.add(getMap("2","不通过"));
		list.add(getMap("3","待审核"));
		return list;
	}
	public static String getActStatusNameById(String id){//根据act_status的key值获取名称
		List<Map<String,Object>> list = getActStatusList();
		return getNameById(id,list);
	}
	/**
	**获取sex数据列表
	*/
	public static List<Map<String,Object>> getSexList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","男"));
		list.add(getMap("2","女"));
		return list;
	}
	public static String getSexNameById(String id){//根据sex的key值获取名称
		List<Map<String,Object>> list = getSexList();
		return getNameById(id,list);
	}
	public static String getNameById(String id,List<Map<String,Object>> list){
		if(id==null){
			return null;
		}
		if(id.endsWith(",")){
			id = id.substring(0,id.length()-1);
		}
		String[] idsplit = id.split(",");
		String rs = "";
		for(String tmp:idsplit){
			for(Map<String,Object> map:list){
				if(map.get("id").toString().equals(tmp)){
					rs+=map.get("name").toString()+",";
				}
			}
		}
		if(rs.endsWith(",")){
			rs = rs.substring(0,rs.length()-1);
		}
		return rs;
	}
	private static Map<String,Object> getMap(String id,String name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("name", name);
		return map;
	}
}
