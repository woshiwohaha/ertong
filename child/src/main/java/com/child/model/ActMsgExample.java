package com.child.model;
import java.util.ArrayList;
import java.util.List;
public class ActMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public ActMsgExample() {
		oredCriteria = new ArrayList<>();
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	public boolean isDistinct() {
		return distinct;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPageRows() {
		return pageRows;
	}
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;
		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}
		public boolean isValid() {
			return criteria.size() > 0;
		}
		public List<Criterion> getAllCriteria() {
			return criteria;
		}
		public List<Criterion> getCriteria() {
			return criteria;
		}
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}
		public Criteria andIdIsNotNull(){
			addCriterion("id is not null");
			return (Criteria) this;
		}
		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "Id");
			return (Criteria) this;
		}
		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdLike(Integer value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotLike(Integer value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}
		public Criteria andActNameIsNull() {
			addCriterion("act_name is null");
			return (Criteria) this;
		}
		public Criteria andActNameIsNotNull(){
			addCriterion("act_name is not null");
			return (Criteria) this;
		}
		public Criteria andActNameEqualTo(String value) {
			addCriterion("act_name =", value, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameNotEqualTo(String value) {
			addCriterion("act_name <>", value, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameGreaterThan(String value) {
			addCriterion("act_name >", value, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameGreaterThanOrEqualTo(String value) {
			addCriterion("act_name >=", value, "ActName");
			return (Criteria) this;
		}
		public Criteria andActNameLessThan(String value) {
			addCriterion("act_name <", value, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameLessThanOrEqualTo(String value) {
			addCriterion("act_name <=", value, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameIn(List<String> values) {
			addCriterion("act_name in", values, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameNotIn(List<String> values) {
			addCriterion("act_name not in", values, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameBetween(String value1, String value2) {
			addCriterion("act_name between", value1, value2, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameNotBetween(String value1, String value2) {
			addCriterion("act_name not between", value1, value2, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameLike(String value) {
			addCriterion("act_name like", value, "actName");
			return (Criteria) this;
		}
		public Criteria andActNameNotLike(String value) {
			addCriterion("act_name not like", value, "actName");
			return (Criteria) this;
		}
		public Criteria andActTimeIsNull() {
			addCriterion("act_time is null");
			return (Criteria) this;
		}
		public Criteria andActTimeIsNotNull(){
			addCriterion("act_time is not null");
			return (Criteria) this;
		}
		public Criteria andActTimeEqualTo(String value) {
			addCriterion("act_time =", value, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeNotEqualTo(String value) {
			addCriterion("act_time <>", value, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeGreaterThan(String value) {
			addCriterion("act_time >", value, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeGreaterThanOrEqualTo(String value) {
			addCriterion("act_time >=", value, "ActTime");
			return (Criteria) this;
		}
		public Criteria andActTimeLessThan(String value) {
			addCriterion("act_time <", value, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeLessThanOrEqualTo(String value) {
			addCriterion("act_time <=", value, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeIn(List<String> values) {
			addCriterion("act_time in", values, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeNotIn(List<String> values) {
			addCriterion("act_time not in", values, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeBetween(String value1, String value2) {
			addCriterion("act_time between", value1, value2, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeNotBetween(String value1, String value2) {
			addCriterion("act_time not between", value1, value2, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeLike(String value) {
			addCriterion("act_time like", value, "actTime");
			return (Criteria) this;
		}
		public Criteria andActTimeNotLike(String value) {
			addCriterion("act_time not like", value, "actTime");
			return (Criteria) this;
		}
		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}
		public Criteria andAddressIsNotNull(){
			addCriterion("address is not null");
			return (Criteria) this;
		}
		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "Address");
			return (Criteria) this;
		}
		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}
		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}
		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}
		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}
		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}
		public Criteria andActImgIsNull() {
			addCriterion("act_img is null");
			return (Criteria) this;
		}
		public Criteria andActImgIsNotNull(){
			addCriterion("act_img is not null");
			return (Criteria) this;
		}
		public Criteria andActImgEqualTo(String value) {
			addCriterion("act_img =", value, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgNotEqualTo(String value) {
			addCriterion("act_img <>", value, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgGreaterThan(String value) {
			addCriterion("act_img >", value, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgGreaterThanOrEqualTo(String value) {
			addCriterion("act_img >=", value, "ActImg");
			return (Criteria) this;
		}
		public Criteria andActImgLessThan(String value) {
			addCriterion("act_img <", value, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgLessThanOrEqualTo(String value) {
			addCriterion("act_img <=", value, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgIn(List<String> values) {
			addCriterion("act_img in", values, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgNotIn(List<String> values) {
			addCriterion("act_img not in", values, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgBetween(String value1, String value2) {
			addCriterion("act_img between", value1, value2, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgNotBetween(String value1, String value2) {
			addCriterion("act_img not between", value1, value2, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgLike(String value) {
			addCriterion("act_img like", value, "actImg");
			return (Criteria) this;
		}
		public Criteria andActImgNotLike(String value) {
			addCriterion("act_img not like", value, "actImg");
			return (Criteria) this;
		}
		public Criteria andContactMsgIsNull() {
			addCriterion("contact_msg is null");
			return (Criteria) this;
		}
		public Criteria andContactMsgIsNotNull(){
			addCriterion("contact_msg is not null");
			return (Criteria) this;
		}
		public Criteria andContactMsgEqualTo(String value) {
			addCriterion("contact_msg =", value, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgNotEqualTo(String value) {
			addCriterion("contact_msg <>", value, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgGreaterThan(String value) {
			addCriterion("contact_msg >", value, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgGreaterThanOrEqualTo(String value) {
			addCriterion("contact_msg >=", value, "ContactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgLessThan(String value) {
			addCriterion("contact_msg <", value, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgLessThanOrEqualTo(String value) {
			addCriterion("contact_msg <=", value, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgIn(List<String> values) {
			addCriterion("contact_msg in", values, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgNotIn(List<String> values) {
			addCriterion("contact_msg not in", values, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgBetween(String value1, String value2) {
			addCriterion("contact_msg between", value1, value2, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgNotBetween(String value1, String value2) {
			addCriterion("contact_msg not between", value1, value2, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgLike(String value) {
			addCriterion("contact_msg like", value, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andContactMsgNotLike(String value) {
			addCriterion("contact_msg not like", value, "contactMsg");
			return (Criteria) this;
		}
		public Criteria andJoinNumIsNull() {
			addCriterion("join_num is null");
			return (Criteria) this;
		}
		public Criteria andJoinNumIsNotNull(){
			addCriterion("join_num is not null");
			return (Criteria) this;
		}
		public Criteria andJoinNumEqualTo(Integer value) {
			addCriterion("join_num =", value, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumNotEqualTo(Integer value) {
			addCriterion("join_num <>", value, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumGreaterThan(Integer value) {
			addCriterion("join_num >", value, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("join_num >=", value, "JoinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumLessThan(Integer value) {
			addCriterion("join_num <", value, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumLessThanOrEqualTo(Integer value) {
			addCriterion("join_num <=", value, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumIn(List<Integer> values) {
			addCriterion("join_num in", values, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumNotIn(List<Integer> values) {
			addCriterion("join_num not in", values, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumBetween(Integer value1, Integer value2) {
			addCriterion("join_num between", value1, value2, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumNotBetween(Integer value1, Integer value2) {
			addCriterion("join_num not between", value1, value2, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumLike(Integer value) {
			addCriterion("join_num like", value, "joinNum");
			return (Criteria) this;
		}
		public Criteria andJoinNumNotLike(Integer value) {
			addCriterion("join_num not like", value, "joinNum");
			return (Criteria) this;
		}
		public Criteria andActDetailIsNull() {
			addCriterion("act_detail is null");
			return (Criteria) this;
		}
		public Criteria andActDetailIsNotNull(){
			addCriterion("act_detail is not null");
			return (Criteria) this;
		}
		public Criteria andActDetailEqualTo(String value) {
			addCriterion("act_detail =", value, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailNotEqualTo(String value) {
			addCriterion("act_detail <>", value, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailGreaterThan(String value) {
			addCriterion("act_detail >", value, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailGreaterThanOrEqualTo(String value) {
			addCriterion("act_detail >=", value, "ActDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailLessThan(String value) {
			addCriterion("act_detail <", value, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailLessThanOrEqualTo(String value) {
			addCriterion("act_detail <=", value, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailIn(List<String> values) {
			addCriterion("act_detail in", values, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailNotIn(List<String> values) {
			addCriterion("act_detail not in", values, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailBetween(String value1, String value2) {
			addCriterion("act_detail between", value1, value2, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailNotBetween(String value1, String value2) {
			addCriterion("act_detail not between", value1, value2, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailLike(String value) {
			addCriterion("act_detail like", value, "actDetail");
			return (Criteria) this;
		}
		public Criteria andActDetailNotLike(String value) {
			addCriterion("act_detail not like", value, "actDetail");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNotNull(){
			addCriterion("create_time is not null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeEqualTo(String value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotEqualTo(String value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThan(String value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("create_time >=", value, "CreateTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThan(String value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIn(List<String> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotIn(List<String> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeBetween(String value1, String value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotBetween(String value1, String value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLike(String value) {
			addCriterion("create_time like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotLike(String value) {
			addCriterion("create_time not like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andActStatusIsNull() {
			addCriterion("act_status is null");
			return (Criteria) this;
		}
		public Criteria andActStatusIsNotNull(){
			addCriterion("act_status is not null");
			return (Criteria) this;
		}
		public Criteria andActStatusEqualTo(Integer value) {
			addCriterion("act_status =", value, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusNotEqualTo(Integer value) {
			addCriterion("act_status <>", value, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusGreaterThan(Integer value) {
			addCriterion("act_status >", value, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("act_status >=", value, "ActStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusLessThan(Integer value) {
			addCriterion("act_status <", value, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusLessThanOrEqualTo(Integer value) {
			addCriterion("act_status <=", value, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusIn(List<Integer> values) {
			addCriterion("act_status in", values, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusNotIn(List<Integer> values) {
			addCriterion("act_status not in", values, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusBetween(Integer value1, Integer value2) {
			addCriterion("act_status between", value1, value2, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("act_status not between", value1, value2, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusLike(Integer value) {
			addCriterion("act_status like", value, "actStatus");
			return (Criteria) this;
		}
		public Criteria andActStatusNotLike(Integer value) {
			addCriterion("act_status not like", value, "actStatus");
			return (Criteria) this;
		}
		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}
		public Criteria andUserIdIsNotNull(){
			addCriterion("user_id is not null");
			return (Criteria) this;
		}
		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "UserId");
			return (Criteria) this;
		}
		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdLike(Integer value) {
			addCriterion("user_id like", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotLike(Integer value) {
			addCriterion("user_id not like", value, "userId");
			return (Criteria) this;
		}
	}
	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;
		public String getCondition() {
			return condition;
		}
		public Object getValue() {
			return value;
		}
		public Object getSecondValue() {
			return secondValue;
		}
		public boolean isNoValue() {
			return noValue;
		}
		public boolean isSingleValue() {
			return singleValue;
		}
		public boolean isBetweenValue() {
			return betweenValue;
		}
		public boolean isListValue() {
			return listValue;
		}
		public String getTypeHandler() {
			return typeHandler;
		}
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}
