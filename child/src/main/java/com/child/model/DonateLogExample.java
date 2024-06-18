package com.child.model;
import java.util.ArrayList;
import java.util.List;
public class DonateLogExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public DonateLogExample() {
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
		public Criteria andHidIsNull() {
			addCriterion("hid is null");
			return (Criteria) this;
		}
		public Criteria andHidIsNotNull(){
			addCriterion("hid is not null");
			return (Criteria) this;
		}
		public Criteria andHidEqualTo(Integer value) {
			addCriterion("hid =", value, "hid");
			return (Criteria) this;
		}
		public Criteria andHidNotEqualTo(Integer value) {
			addCriterion("hid <>", value, "hid");
			return (Criteria) this;
		}
		public Criteria andHidGreaterThan(Integer value) {
			addCriterion("hid >", value, "hid");
			return (Criteria) this;
		}
		public Criteria andHidGreaterThanOrEqualTo(Integer value) {
			addCriterion("hid >=", value, "Hid");
			return (Criteria) this;
		}
		public Criteria andHidLessThan(Integer value) {
			addCriterion("hid <", value, "hid");
			return (Criteria) this;
		}
		public Criteria andHidLessThanOrEqualTo(Integer value) {
			addCriterion("hid <=", value, "hid");
			return (Criteria) this;
		}
		public Criteria andHidIn(List<Integer> values) {
			addCriterion("hid in", values, "hid");
			return (Criteria) this;
		}
		public Criteria andHidNotIn(List<Integer> values) {
			addCriterion("hid not in", values, "hid");
			return (Criteria) this;
		}
		public Criteria andHidBetween(Integer value1, Integer value2) {
			addCriterion("hid between", value1, value2, "hid");
			return (Criteria) this;
		}
		public Criteria andHidNotBetween(Integer value1, Integer value2) {
			addCriterion("hid not between", value1, value2, "hid");
			return (Criteria) this;
		}
		public Criteria andHidLike(Integer value) {
			addCriterion("hid like", value, "hid");
			return (Criteria) this;
		}
		public Criteria andHidNotLike(Integer value) {
			addCriterion("hid not like", value, "hid");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsIsNull() {
			addCriterion("donate_goods is null");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsIsNotNull(){
			addCriterion("donate_goods is not null");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsEqualTo(String value) {
			addCriterion("donate_goods =", value, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsNotEqualTo(String value) {
			addCriterion("donate_goods <>", value, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsGreaterThan(String value) {
			addCriterion("donate_goods >", value, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsGreaterThanOrEqualTo(String value) {
			addCriterion("donate_goods >=", value, "DonateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsLessThan(String value) {
			addCriterion("donate_goods <", value, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsLessThanOrEqualTo(String value) {
			addCriterion("donate_goods <=", value, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsIn(List<String> values) {
			addCriterion("donate_goods in", values, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsNotIn(List<String> values) {
			addCriterion("donate_goods not in", values, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsBetween(String value1, String value2) {
			addCriterion("donate_goods between", value1, value2, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsNotBetween(String value1, String value2) {
			addCriterion("donate_goods not between", value1, value2, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsLike(String value) {
			addCriterion("donate_goods like", value, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateGoodsNotLike(String value) {
			addCriterion("donate_goods not like", value, "donateGoods");
			return (Criteria) this;
		}
		public Criteria andDonateAmountIsNull() {
			addCriterion("donate_amount is null");
			return (Criteria) this;
		}
		public Criteria andDonateAmountIsNotNull(){
			addCriterion("donate_amount is not null");
			return (Criteria) this;
		}
		public Criteria andDonateAmountEqualTo(String value) {
			addCriterion("donate_amount =", value, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountNotEqualTo(String value) {
			addCriterion("donate_amount <>", value, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountGreaterThan(String value) {
			addCriterion("donate_amount >", value, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountGreaterThanOrEqualTo(String value) {
			addCriterion("donate_amount >=", value, "DonateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountLessThan(String value) {
			addCriterion("donate_amount <", value, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountLessThanOrEqualTo(String value) {
			addCriterion("donate_amount <=", value, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountIn(List<String> values) {
			addCriterion("donate_amount in", values, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountNotIn(List<String> values) {
			addCriterion("donate_amount not in", values, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountBetween(String value1, String value2) {
			addCriterion("donate_amount between", value1, value2, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountNotBetween(String value1, String value2) {
			addCriterion("donate_amount not between", value1, value2, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountLike(String value) {
			addCriterion("donate_amount like", value, "donateAmount");
			return (Criteria) this;
		}
		public Criteria andDonateAmountNotLike(String value) {
			addCriterion("donate_amount not like", value, "donateAmount");
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
