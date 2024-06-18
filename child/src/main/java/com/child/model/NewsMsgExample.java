package com.child.model;
import java.util.ArrayList;
import java.util.List;
public class NewsMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public NewsMsgExample() {
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
		public Criteria andNewsNameIsNull() {
			addCriterion("news_name is null");
			return (Criteria) this;
		}
		public Criteria andNewsNameIsNotNull(){
			addCriterion("news_name is not null");
			return (Criteria) this;
		}
		public Criteria andNewsNameEqualTo(String value) {
			addCriterion("news_name =", value, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameNotEqualTo(String value) {
			addCriterion("news_name <>", value, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameGreaterThan(String value) {
			addCriterion("news_name >", value, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameGreaterThanOrEqualTo(String value) {
			addCriterion("news_name >=", value, "NewsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameLessThan(String value) {
			addCriterion("news_name <", value, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameLessThanOrEqualTo(String value) {
			addCriterion("news_name <=", value, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameIn(List<String> values) {
			addCriterion("news_name in", values, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameNotIn(List<String> values) {
			addCriterion("news_name not in", values, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameBetween(String value1, String value2) {
			addCriterion("news_name between", value1, value2, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameNotBetween(String value1, String value2) {
			addCriterion("news_name not between", value1, value2, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameLike(String value) {
			addCriterion("news_name like", value, "newsName");
			return (Criteria) this;
		}
		public Criteria andNewsNameNotLike(String value) {
			addCriterion("news_name not like", value, "newsName");
			return (Criteria) this;
		}
		public Criteria andNoticeImgIsNull() {
			addCriterion("notice_img is null");
			return (Criteria) this;
		}
		public Criteria andNoticeImgIsNotNull(){
			addCriterion("notice_img is not null");
			return (Criteria) this;
		}
		public Criteria andNoticeImgEqualTo(String value) {
			addCriterion("notice_img =", value, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgNotEqualTo(String value) {
			addCriterion("notice_img <>", value, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgGreaterThan(String value) {
			addCriterion("notice_img >", value, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgGreaterThanOrEqualTo(String value) {
			addCriterion("notice_img >=", value, "NoticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgLessThan(String value) {
			addCriterion("notice_img <", value, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgLessThanOrEqualTo(String value) {
			addCriterion("notice_img <=", value, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgIn(List<String> values) {
			addCriterion("notice_img in", values, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgNotIn(List<String> values) {
			addCriterion("notice_img not in", values, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgBetween(String value1, String value2) {
			addCriterion("notice_img between", value1, value2, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgNotBetween(String value1, String value2) {
			addCriterion("notice_img not between", value1, value2, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgLike(String value) {
			addCriterion("notice_img like", value, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNoticeImgNotLike(String value) {
			addCriterion("notice_img not like", value, "noticeImg");
			return (Criteria) this;
		}
		public Criteria andNewsDetailIsNull() {
			addCriterion("news_detail is null");
			return (Criteria) this;
		}
		public Criteria andNewsDetailIsNotNull(){
			addCriterion("news_detail is not null");
			return (Criteria) this;
		}
		public Criteria andNewsDetailEqualTo(String value) {
			addCriterion("news_detail =", value, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailNotEqualTo(String value) {
			addCriterion("news_detail <>", value, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailGreaterThan(String value) {
			addCriterion("news_detail >", value, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailGreaterThanOrEqualTo(String value) {
			addCriterion("news_detail >=", value, "NewsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailLessThan(String value) {
			addCriterion("news_detail <", value, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailLessThanOrEqualTo(String value) {
			addCriterion("news_detail <=", value, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailIn(List<String> values) {
			addCriterion("news_detail in", values, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailNotIn(List<String> values) {
			addCriterion("news_detail not in", values, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailBetween(String value1, String value2) {
			addCriterion("news_detail between", value1, value2, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailNotBetween(String value1, String value2) {
			addCriterion("news_detail not between", value1, value2, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailLike(String value) {
			addCriterion("news_detail like", value, "newsDetail");
			return (Criteria) this;
		}
		public Criteria andNewsDetailNotLike(String value) {
			addCriterion("news_detail not like", value, "newsDetail");
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
