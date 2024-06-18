package com.child.model;
import java.util.ArrayList;
import java.util.List;
public class JoinLogExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public JoinLogExample() {
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
		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}
		public Criteria andUidIsNotNull(){
			addCriterion("uid is not null");
			return (Criteria) this;
		}
		public Criteria andUidEqualTo(Integer value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotEqualTo(Integer value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidGreaterThan(Integer value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("uid >=", value, "Uid");
			return (Criteria) this;
		}
		public Criteria andUidLessThan(Integer value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidLessThanOrEqualTo(Integer value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidIn(List<Integer> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotIn(List<Integer> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}
		public Criteria andUidBetween(Integer value1, Integer value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotBetween(Integer value1, Integer value2) {
			addCriterion("uid not between", value1, value2, "uid");
			return (Criteria) this;
		}
		public Criteria andUidLike(Integer value) {
			addCriterion("uid like", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotLike(Integer value) {
			addCriterion("uid not like", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUrealNameIsNull() {
			addCriterion("ureal_name is null");
			return (Criteria) this;
		}
		public Criteria andUrealNameIsNotNull(){
			addCriterion("ureal_name is not null");
			return (Criteria) this;
		}
		public Criteria andUrealNameEqualTo(String value) {
			addCriterion("ureal_name =", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameNotEqualTo(String value) {
			addCriterion("ureal_name <>", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameGreaterThan(String value) {
			addCriterion("ureal_name >", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameGreaterThanOrEqualTo(String value) {
			addCriterion("ureal_name >=", value, "UrealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameLessThan(String value) {
			addCriterion("ureal_name <", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameLessThanOrEqualTo(String value) {
			addCriterion("ureal_name <=", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameIn(List<String> values) {
			addCriterion("ureal_name in", values, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameNotIn(List<String> values) {
			addCriterion("ureal_name not in", values, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameBetween(String value1, String value2) {
			addCriterion("ureal_name between", value1, value2, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameNotBetween(String value1, String value2) {
			addCriterion("ureal_name not between", value1, value2, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameLike(String value) {
			addCriterion("ureal_name like", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUrealNameNotLike(String value) {
			addCriterion("ureal_name not like", value, "urealName");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneIsNull() {
			addCriterion("ucel_phone is null");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneIsNotNull(){
			addCriterion("ucel_phone is not null");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneEqualTo(String value) {
			addCriterion("ucel_phone =", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneNotEqualTo(String value) {
			addCriterion("ucel_phone <>", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneGreaterThan(String value) {
			addCriterion("ucel_phone >", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("ucel_phone >=", value, "UcelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneLessThan(String value) {
			addCriterion("ucel_phone <", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneLessThanOrEqualTo(String value) {
			addCriterion("ucel_phone <=", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneIn(List<String> values) {
			addCriterion("ucel_phone in", values, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneNotIn(List<String> values) {
			addCriterion("ucel_phone not in", values, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneBetween(String value1, String value2) {
			addCriterion("ucel_phone between", value1, value2, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneNotBetween(String value1, String value2) {
			addCriterion("ucel_phone not between", value1, value2, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneLike(String value) {
			addCriterion("ucel_phone like", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andUcelPhoneNotLike(String value) {
			addCriterion("ucel_phone not like", value, "ucelPhone");
			return (Criteria) this;
		}
		public Criteria andAidIsNull() {
			addCriterion("aid is null");
			return (Criteria) this;
		}
		public Criteria andAidIsNotNull(){
			addCriterion("aid is not null");
			return (Criteria) this;
		}
		public Criteria andAidEqualTo(Integer value) {
			addCriterion("aid =", value, "aid");
			return (Criteria) this;
		}
		public Criteria andAidNotEqualTo(Integer value) {
			addCriterion("aid <>", value, "aid");
			return (Criteria) this;
		}
		public Criteria andAidGreaterThan(Integer value) {
			addCriterion("aid >", value, "aid");
			return (Criteria) this;
		}
		public Criteria andAidGreaterThanOrEqualTo(Integer value) {
			addCriterion("aid >=", value, "Aid");
			return (Criteria) this;
		}
		public Criteria andAidLessThan(Integer value) {
			addCriterion("aid <", value, "aid");
			return (Criteria) this;
		}
		public Criteria andAidLessThanOrEqualTo(Integer value) {
			addCriterion("aid <=", value, "aid");
			return (Criteria) this;
		}
		public Criteria andAidIn(List<Integer> values) {
			addCriterion("aid in", values, "aid");
			return (Criteria) this;
		}
		public Criteria andAidNotIn(List<Integer> values) {
			addCriterion("aid not in", values, "aid");
			return (Criteria) this;
		}
		public Criteria andAidBetween(Integer value1, Integer value2) {
			addCriterion("aid between", value1, value2, "aid");
			return (Criteria) this;
		}
		public Criteria andAidNotBetween(Integer value1, Integer value2) {
			addCriterion("aid not between", value1, value2, "aid");
			return (Criteria) this;
		}
		public Criteria andAidLike(Integer value) {
			addCriterion("aid like", value, "aid");
			return (Criteria) this;
		}
		public Criteria andAidNotLike(Integer value) {
			addCriterion("aid not like", value, "aid");
			return (Criteria) this;
		}
		public Criteria andAactTimeIsNull() {
			addCriterion("aact_time is null");
			return (Criteria) this;
		}
		public Criteria andAactTimeIsNotNull(){
			addCriterion("aact_time is not null");
			return (Criteria) this;
		}
		public Criteria andAactTimeEqualTo(String value) {
			addCriterion("aact_time =", value, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeNotEqualTo(String value) {
			addCriterion("aact_time <>", value, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeGreaterThan(String value) {
			addCriterion("aact_time >", value, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeGreaterThanOrEqualTo(String value) {
			addCriterion("aact_time >=", value, "AactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeLessThan(String value) {
			addCriterion("aact_time <", value, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeLessThanOrEqualTo(String value) {
			addCriterion("aact_time <=", value, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeIn(List<String> values) {
			addCriterion("aact_time in", values, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeNotIn(List<String> values) {
			addCriterion("aact_time not in", values, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeBetween(String value1, String value2) {
			addCriterion("aact_time between", value1, value2, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeNotBetween(String value1, String value2) {
			addCriterion("aact_time not between", value1, value2, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeLike(String value) {
			addCriterion("aact_time like", value, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAactTimeNotLike(String value) {
			addCriterion("aact_time not like", value, "aactTime");
			return (Criteria) this;
		}
		public Criteria andAaddressIsNull() {
			addCriterion("aaddress is null");
			return (Criteria) this;
		}
		public Criteria andAaddressIsNotNull(){
			addCriterion("aaddress is not null");
			return (Criteria) this;
		}
		public Criteria andAaddressEqualTo(String value) {
			addCriterion("aaddress =", value, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressNotEqualTo(String value) {
			addCriterion("aaddress <>", value, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressGreaterThan(String value) {
			addCriterion("aaddress >", value, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressGreaterThanOrEqualTo(String value) {
			addCriterion("aaddress >=", value, "Aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressLessThan(String value) {
			addCriterion("aaddress <", value, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressLessThanOrEqualTo(String value) {
			addCriterion("aaddress <=", value, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressIn(List<String> values) {
			addCriterion("aaddress in", values, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressNotIn(List<String> values) {
			addCriterion("aaddress not in", values, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressBetween(String value1, String value2) {
			addCriterion("aaddress between", value1, value2, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressNotBetween(String value1, String value2) {
			addCriterion("aaddress not between", value1, value2, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressLike(String value) {
			addCriterion("aaddress like", value, "aaddress");
			return (Criteria) this;
		}
		public Criteria andAaddressNotLike(String value) {
			addCriterion("aaddress not like", value, "aaddress");
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
