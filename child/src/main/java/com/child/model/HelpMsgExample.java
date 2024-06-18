package com.child.model;
import java.util.ArrayList;
import java.util.List;
public class HelpMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public HelpMsgExample() {
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
		public Criteria andHnameIsNull() {
			addCriterion("hname is null");
			return (Criteria) this;
		}
		public Criteria andHnameIsNotNull(){
			addCriterion("hname is not null");
			return (Criteria) this;
		}
		public Criteria andHnameEqualTo(String value) {
			addCriterion("hname =", value, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameNotEqualTo(String value) {
			addCriterion("hname <>", value, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameGreaterThan(String value) {
			addCriterion("hname >", value, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameGreaterThanOrEqualTo(String value) {
			addCriterion("hname >=", value, "Hname");
			return (Criteria) this;
		}
		public Criteria andHnameLessThan(String value) {
			addCriterion("hname <", value, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameLessThanOrEqualTo(String value) {
			addCriterion("hname <=", value, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameIn(List<String> values) {
			addCriterion("hname in", values, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameNotIn(List<String> values) {
			addCriterion("hname not in", values, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameBetween(String value1, String value2) {
			addCriterion("hname between", value1, value2, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameNotBetween(String value1, String value2) {
			addCriterion("hname not between", value1, value2, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameLike(String value) {
			addCriterion("hname like", value, "hname");
			return (Criteria) this;
		}
		public Criteria andHnameNotLike(String value) {
			addCriterion("hname not like", value, "hname");
			return (Criteria) this;
		}
		public Criteria andHageIsNull() {
			addCriterion("hage is null");
			return (Criteria) this;
		}
		public Criteria andHageIsNotNull(){
			addCriterion("hage is not null");
			return (Criteria) this;
		}
		public Criteria andHageEqualTo(Integer value) {
			addCriterion("hage =", value, "hage");
			return (Criteria) this;
		}
		public Criteria andHageNotEqualTo(Integer value) {
			addCriterion("hage <>", value, "hage");
			return (Criteria) this;
		}
		public Criteria andHageGreaterThan(Integer value) {
			addCriterion("hage >", value, "hage");
			return (Criteria) this;
		}
		public Criteria andHageGreaterThanOrEqualTo(Integer value) {
			addCriterion("hage >=", value, "Hage");
			return (Criteria) this;
		}
		public Criteria andHageLessThan(Integer value) {
			addCriterion("hage <", value, "hage");
			return (Criteria) this;
		}
		public Criteria andHageLessThanOrEqualTo(Integer value) {
			addCriterion("hage <=", value, "hage");
			return (Criteria) this;
		}
		public Criteria andHageIn(List<Integer> values) {
			addCriterion("hage in", values, "hage");
			return (Criteria) this;
		}
		public Criteria andHageNotIn(List<Integer> values) {
			addCriterion("hage not in", values, "hage");
			return (Criteria) this;
		}
		public Criteria andHageBetween(Integer value1, Integer value2) {
			addCriterion("hage between", value1, value2, "hage");
			return (Criteria) this;
		}
		public Criteria andHageNotBetween(Integer value1, Integer value2) {
			addCriterion("hage not between", value1, value2, "hage");
			return (Criteria) this;
		}
		public Criteria andHageLike(Integer value) {
			addCriterion("hage like", value, "hage");
			return (Criteria) this;
		}
		public Criteria andHageNotLike(Integer value) {
			addCriterion("hage not like", value, "hage");
			return (Criteria) this;
		}
		public Criteria andHzpIsNull() {
			addCriterion("hzp is null");
			return (Criteria) this;
		}
		public Criteria andHzpIsNotNull(){
			addCriterion("hzp is not null");
			return (Criteria) this;
		}
		public Criteria andHzpEqualTo(String value) {
			addCriterion("hzp =", value, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpNotEqualTo(String value) {
			addCriterion("hzp <>", value, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpGreaterThan(String value) {
			addCriterion("hzp >", value, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpGreaterThanOrEqualTo(String value) {
			addCriterion("hzp >=", value, "Hzp");
			return (Criteria) this;
		}
		public Criteria andHzpLessThan(String value) {
			addCriterion("hzp <", value, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpLessThanOrEqualTo(String value) {
			addCriterion("hzp <=", value, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpIn(List<String> values) {
			addCriterion("hzp in", values, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpNotIn(List<String> values) {
			addCriterion("hzp not in", values, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpBetween(String value1, String value2) {
			addCriterion("hzp between", value1, value2, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpNotBetween(String value1, String value2) {
			addCriterion("hzp not between", value1, value2, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpLike(String value) {
			addCriterion("hzp like", value, "hzp");
			return (Criteria) this;
		}
		public Criteria andHzpNotLike(String value) {
			addCriterion("hzp not like", value, "hzp");
			return (Criteria) this;
		}
		public Criteria andHsexIsNull() {
			addCriterion("hsex is null");
			return (Criteria) this;
		}
		public Criteria andHsexIsNotNull(){
			addCriterion("hsex is not null");
			return (Criteria) this;
		}
		public Criteria andHsexEqualTo(Integer value) {
			addCriterion("hsex =", value, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexNotEqualTo(Integer value) {
			addCriterion("hsex <>", value, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexGreaterThan(Integer value) {
			addCriterion("hsex >", value, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexGreaterThanOrEqualTo(Integer value) {
			addCriterion("hsex >=", value, "Hsex");
			return (Criteria) this;
		}
		public Criteria andHsexLessThan(Integer value) {
			addCriterion("hsex <", value, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexLessThanOrEqualTo(Integer value) {
			addCriterion("hsex <=", value, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexIn(List<Integer> values) {
			addCriterion("hsex in", values, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexNotIn(List<Integer> values) {
			addCriterion("hsex not in", values, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexBetween(Integer value1, Integer value2) {
			addCriterion("hsex between", value1, value2, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexNotBetween(Integer value1, Integer value2) {
			addCriterion("hsex not between", value1, value2, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexLike(Integer value) {
			addCriterion("hsex like", value, "hsex");
			return (Criteria) this;
		}
		public Criteria andHsexNotLike(Integer value) {
			addCriterion("hsex not like", value, "hsex");
			return (Criteria) this;
		}
		public Criteria andHcelIsNull() {
			addCriterion("hcel is null");
			return (Criteria) this;
		}
		public Criteria andHcelIsNotNull(){
			addCriterion("hcel is not null");
			return (Criteria) this;
		}
		public Criteria andHcelEqualTo(String value) {
			addCriterion("hcel =", value, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelNotEqualTo(String value) {
			addCriterion("hcel <>", value, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelGreaterThan(String value) {
			addCriterion("hcel >", value, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelGreaterThanOrEqualTo(String value) {
			addCriterion("hcel >=", value, "Hcel");
			return (Criteria) this;
		}
		public Criteria andHcelLessThan(String value) {
			addCriterion("hcel <", value, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelLessThanOrEqualTo(String value) {
			addCriterion("hcel <=", value, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelIn(List<String> values) {
			addCriterion("hcel in", values, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelNotIn(List<String> values) {
			addCriterion("hcel not in", values, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelBetween(String value1, String value2) {
			addCriterion("hcel between", value1, value2, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelNotBetween(String value1, String value2) {
			addCriterion("hcel not between", value1, value2, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelLike(String value) {
			addCriterion("hcel like", value, "hcel");
			return (Criteria) this;
		}
		public Criteria andHcelNotLike(String value) {
			addCriterion("hcel not like", value, "hcel");
			return (Criteria) this;
		}
		public Criteria andHelpIntroIsNull() {
			addCriterion("help_intro is null");
			return (Criteria) this;
		}
		public Criteria andHelpIntroIsNotNull(){
			addCriterion("help_intro is not null");
			return (Criteria) this;
		}
		public Criteria andHelpIntroEqualTo(String value) {
			addCriterion("help_intro =", value, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroNotEqualTo(String value) {
			addCriterion("help_intro <>", value, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroGreaterThan(String value) {
			addCriterion("help_intro >", value, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroGreaterThanOrEqualTo(String value) {
			addCriterion("help_intro >=", value, "HelpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroLessThan(String value) {
			addCriterion("help_intro <", value, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroLessThanOrEqualTo(String value) {
			addCriterion("help_intro <=", value, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroIn(List<String> values) {
			addCriterion("help_intro in", values, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroNotIn(List<String> values) {
			addCriterion("help_intro not in", values, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroBetween(String value1, String value2) {
			addCriterion("help_intro between", value1, value2, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroNotBetween(String value1, String value2) {
			addCriterion("help_intro not between", value1, value2, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroLike(String value) {
			addCriterion("help_intro like", value, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andHelpIntroNotLike(String value) {
			addCriterion("help_intro not like", value, "helpIntro");
			return (Criteria) this;
		}
		public Criteria andAmountIsNull() {
			addCriterion("amount is null");
			return (Criteria) this;
		}
		public Criteria andAmountIsNotNull(){
			addCriterion("amount is not null");
			return (Criteria) this;
		}
		public Criteria andAmountEqualTo(Integer value) {
			addCriterion("amount =", value, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountNotEqualTo(Integer value) {
			addCriterion("amount <>", value, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountGreaterThan(Integer value) {
			addCriterion("amount >", value, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
			addCriterion("amount >=", value, "Amount");
			return (Criteria) this;
		}
		public Criteria andAmountLessThan(Integer value) {
			addCriterion("amount <", value, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountLessThanOrEqualTo(Integer value) {
			addCriterion("amount <=", value, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountIn(List<Integer> values) {
			addCriterion("amount in", values, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountNotIn(List<Integer> values) {
			addCriterion("amount not in", values, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountBetween(Integer value1, Integer value2) {
			addCriterion("amount between", value1, value2, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountNotBetween(Integer value1, Integer value2) {
			addCriterion("amount not between", value1, value2, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountLike(Integer value) {
			addCriterion("amount like", value, "amount");
			return (Criteria) this;
		}
		public Criteria andAmountNotLike(Integer value) {
			addCriterion("amount not like", value, "amount");
			return (Criteria) this;
		}
		public Criteria andCreateDateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}
		public Criteria andCreateDateIsNotNull(){
			addCriterion("create_date is not null");
			return (Criteria) this;
		}
		public Criteria andCreateDateEqualTo(String value) {
			addCriterion("create_date =", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotEqualTo(String value) {
			addCriterion("create_date <>", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateGreaterThan(String value) {
			addCriterion("create_date >", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
			addCriterion("create_date >=", value, "CreateDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLessThan(String value) {
			addCriterion("create_date <", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLessThanOrEqualTo(String value) {
			addCriterion("create_date <=", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateIn(List<String> values) {
			addCriterion("create_date in", values, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotIn(List<String> values) {
			addCriterion("create_date not in", values, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateBetween(String value1, String value2) {
			addCriterion("create_date between", value1, value2, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotBetween(String value1, String value2) {
			addCriterion("create_date not between", value1, value2, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLike(String value) {
			addCriterion("create_date like", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotLike(String value) {
			addCriterion("create_date not like", value, "createDate");
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
