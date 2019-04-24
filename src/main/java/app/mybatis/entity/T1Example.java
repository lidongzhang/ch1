package app.mybatis.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class T1Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t1
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t1
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t1
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public T1Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t1
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t1
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(Integer value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(Integer value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(Integer value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<Integer> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andC1IsNull() {
            addCriterion("c1 is null");
            return (Criteria) this;
        }

        public Criteria andC1IsNotNull() {
            addCriterion("c1 is not null");
            return (Criteria) this;
        }

        public Criteria andC1EqualTo(String value) {
            addCriterion("c1 =", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotEqualTo(String value) {
            addCriterion("c1 <>", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThan(String value) {
            addCriterion("c1 >", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThanOrEqualTo(String value) {
            addCriterion("c1 >=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThan(String value) {
            addCriterion("c1 <", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThanOrEqualTo(String value) {
            addCriterion("c1 <=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Like(String value) {
            addCriterion("c1 like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotLike(String value) {
            addCriterion("c1 not like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1In(List<String> values) {
            addCriterion("c1 in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotIn(List<String> values) {
            addCriterion("c1 not in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Between(String value1, String value2) {
            addCriterion("c1 between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotBetween(String value1, String value2) {
            addCriterion("c1 not between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC2IsNull() {
            addCriterion("c2 is null");
            return (Criteria) this;
        }

        public Criteria andC2IsNotNull() {
            addCriterion("c2 is not null");
            return (Criteria) this;
        }

        public Criteria andC2EqualTo(Integer value) {
            addCriterion("c2 =", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotEqualTo(Integer value) {
            addCriterion("c2 <>", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThan(Integer value) {
            addCriterion("c2 >", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThanOrEqualTo(Integer value) {
            addCriterion("c2 >=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThan(Integer value) {
            addCriterion("c2 <", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThanOrEqualTo(Integer value) {
            addCriterion("c2 <=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2In(List<Integer> values) {
            addCriterion("c2 in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotIn(List<Integer> values) {
            addCriterion("c2 not in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Between(Integer value1, Integer value2) {
            addCriterion("c2 between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotBetween(Integer value1, Integer value2) {
            addCriterion("c2 not between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC3IsNull() {
            addCriterion("c3 is null");
            return (Criteria) this;
        }

        public Criteria andC3IsNotNull() {
            addCriterion("c3 is not null");
            return (Criteria) this;
        }

        public Criteria andC3EqualTo(BigDecimal value) {
            addCriterion("c3 =", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotEqualTo(BigDecimal value) {
            addCriterion("c3 <>", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThan(BigDecimal value) {
            addCriterion("c3 >", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("c3 >=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThan(BigDecimal value) {
            addCriterion("c3 <", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("c3 <=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3In(List<BigDecimal> values) {
            addCriterion("c3 in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotIn(List<BigDecimal> values) {
            addCriterion("c3 not in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("c3 between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("c3 not between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC4IsNull() {
            addCriterion("c4 is null");
            return (Criteria) this;
        }

        public Criteria andC4IsNotNull() {
            addCriterion("c4 is not null");
            return (Criteria) this;
        }

        public Criteria andC4EqualTo(Date value) {
            addCriterion("c4 =", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotEqualTo(Date value) {
            addCriterion("c4 <>", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThan(Date value) {
            addCriterion("c4 >", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThanOrEqualTo(Date value) {
            addCriterion("c4 >=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThan(Date value) {
            addCriterion("c4 <", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThanOrEqualTo(Date value) {
            addCriterion("c4 <=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4In(List<Date> values) {
            addCriterion("c4 in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotIn(List<Date> values) {
            addCriterion("c4 not in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4Between(Date value1, Date value2) {
            addCriterion("c4 between", value1, value2, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotBetween(Date value1, Date value2) {
            addCriterion("c4 not between", value1, value2, "c4");
            return (Criteria) this;
        }

        public Criteria andC6IsNull() {
            addCriterion("c6 is null");
            return (Criteria) this;
        }

        public Criteria andC6IsNotNull() {
            addCriterion("c6 is not null");
            return (Criteria) this;
        }

        public Criteria andC6EqualTo(Date value) {
            addCriterionForJDBCDate("c6 =", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6NotEqualTo(Date value) {
            addCriterionForJDBCDate("c6 <>", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6GreaterThan(Date value) {
            addCriterionForJDBCDate("c6 >", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("c6 >=", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6LessThan(Date value) {
            addCriterionForJDBCDate("c6 <", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("c6 <=", value, "c6");
            return (Criteria) this;
        }

        public Criteria andC6In(List<Date> values) {
            addCriterionForJDBCDate("c6 in", values, "c6");
            return (Criteria) this;
        }

        public Criteria andC6NotIn(List<Date> values) {
            addCriterionForJDBCDate("c6 not in", values, "c6");
            return (Criteria) this;
        }

        public Criteria andC6Between(Date value1, Date value2) {
            addCriterionForJDBCDate("c6 between", value1, value2, "c6");
            return (Criteria) this;
        }

        public Criteria andC6NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("c6 not between", value1, value2, "c6");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t1
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t1
     *
     * @mbg.generated
     */
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