package com.guet.match.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsEnrollmentRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmsEnrollmentRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andContestIdIsNull() {
            addCriterion("contest_id is null");
            return (Criteria) this;
        }

        public Criteria andContestIdIsNotNull() {
            addCriterion("contest_id is not null");
            return (Criteria) this;
        }

        public Criteria andContestIdEqualTo(Long value) {
            addCriterion("contest_id =", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdNotEqualTo(Long value) {
            addCriterion("contest_id <>", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdGreaterThan(Long value) {
            addCriterion("contest_id >", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contest_id >=", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdLessThan(Long value) {
            addCriterion("contest_id <", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdLessThanOrEqualTo(Long value) {
            addCriterion("contest_id <=", value, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdIn(List<Long> values) {
            addCriterion("contest_id in", values, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdNotIn(List<Long> values) {
            addCriterion("contest_id not in", values, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdBetween(Long value1, Long value2) {
            addCriterion("contest_id between", value1, value2, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestIdNotBetween(Long value1, Long value2) {
            addCriterion("contest_id not between", value1, value2, "contestId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdIsNull() {
            addCriterion("contest_group_id is null");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdIsNotNull() {
            addCriterion("contest_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdEqualTo(Long value) {
            addCriterion("contest_group_id =", value, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdNotEqualTo(Long value) {
            addCriterion("contest_group_id <>", value, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdGreaterThan(Long value) {
            addCriterion("contest_group_id >", value, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contest_group_id >=", value, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdLessThan(Long value) {
            addCriterion("contest_group_id <", value, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("contest_group_id <=", value, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdIn(List<Long> values) {
            addCriterion("contest_group_id in", values, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdNotIn(List<Long> values) {
            addCriterion("contest_group_id not in", values, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdBetween(Long value1, Long value2) {
            addCriterion("contest_group_id between", value1, value2, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andContestGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("contest_group_id not between", value1, value2, "contestGroupId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andMailAddressIsNull() {
            addCriterion("mail_address is null");
            return (Criteria) this;
        }

        public Criteria andMailAddressIsNotNull() {
            addCriterion("mail_address is not null");
            return (Criteria) this;
        }

        public Criteria andMailAddressEqualTo(String value) {
            addCriterion("mail_address =", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotEqualTo(String value) {
            addCriterion("mail_address <>", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressGreaterThan(String value) {
            addCriterion("mail_address >", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mail_address >=", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLessThan(String value) {
            addCriterion("mail_address <", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLessThanOrEqualTo(String value) {
            addCriterion("mail_address <=", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLike(String value) {
            addCriterion("mail_address like", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotLike(String value) {
            addCriterion("mail_address not like", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressIn(List<String> values) {
            addCriterion("mail_address in", values, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotIn(List<String> values) {
            addCriterion("mail_address not in", values, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressBetween(String value1, String value2) {
            addCriterion("mail_address between", value1, value2, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotBetween(String value1, String value2) {
            addCriterion("mail_address not between", value1, value2, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andContestantNumberIsNull() {
            addCriterion("contestant_number is null");
            return (Criteria) this;
        }

        public Criteria andContestantNumberIsNotNull() {
            addCriterion("contestant_number is not null");
            return (Criteria) this;
        }

        public Criteria andContestantNumberEqualTo(String value) {
            addCriterion("contestant_number =", value, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberNotEqualTo(String value) {
            addCriterion("contestant_number <>", value, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberGreaterThan(String value) {
            addCriterion("contestant_number >", value, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contestant_number >=", value, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberLessThan(String value) {
            addCriterion("contestant_number <", value, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberLessThanOrEqualTo(String value) {
            addCriterion("contestant_number <=", value, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberLike(String value) {
            addCriterion("contestant_number like", value, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberNotLike(String value) {
            addCriterion("contestant_number not like", value, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberIn(List<String> values) {
            addCriterion("contestant_number in", values, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberNotIn(List<String> values) {
            addCriterion("contestant_number not in", values, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberBetween(String value1, String value2) {
            addCriterion("contestant_number between", value1, value2, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantNumberNotBetween(String value1, String value2) {
            addCriterion("contestant_number not between", value1, value2, "contestantNumber");
            return (Criteria) this;
        }

        public Criteria andContestantStatusIsNull() {
            addCriterion("contestant_status is null");
            return (Criteria) this;
        }

        public Criteria andContestantStatusIsNotNull() {
            addCriterion("contestant_status is not null");
            return (Criteria) this;
        }

        public Criteria andContestantStatusEqualTo(String value) {
            addCriterion("contestant_status =", value, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusNotEqualTo(String value) {
            addCriterion("contestant_status <>", value, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusGreaterThan(String value) {
            addCriterion("contestant_status >", value, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusGreaterThanOrEqualTo(String value) {
            addCriterion("contestant_status >=", value, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusLessThan(String value) {
            addCriterion("contestant_status <", value, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusLessThanOrEqualTo(String value) {
            addCriterion("contestant_status <=", value, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusLike(String value) {
            addCriterion("contestant_status like", value, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusNotLike(String value) {
            addCriterion("contestant_status not like", value, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusIn(List<String> values) {
            addCriterion("contestant_status in", values, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusNotIn(List<String> values) {
            addCriterion("contestant_status not in", values, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusBetween(String value1, String value2) {
            addCriterion("contestant_status between", value1, value2, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantStatusNotBetween(String value1, String value2) {
            addCriterion("contestant_status not between", value1, value2, "contestantStatus");
            return (Criteria) this;
        }

        public Criteria andContestantRankIsNull() {
            addCriterion("contestant_rank is null");
            return (Criteria) this;
        }

        public Criteria andContestantRankIsNotNull() {
            addCriterion("contestant_rank is not null");
            return (Criteria) this;
        }

        public Criteria andContestantRankEqualTo(String value) {
            addCriterion("contestant_rank =", value, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankNotEqualTo(String value) {
            addCriterion("contestant_rank <>", value, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankGreaterThan(String value) {
            addCriterion("contestant_rank >", value, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankGreaterThanOrEqualTo(String value) {
            addCriterion("contestant_rank >=", value, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankLessThan(String value) {
            addCriterion("contestant_rank <", value, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankLessThanOrEqualTo(String value) {
            addCriterion("contestant_rank <=", value, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankLike(String value) {
            addCriterion("contestant_rank like", value, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankNotLike(String value) {
            addCriterion("contestant_rank not like", value, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankIn(List<String> values) {
            addCriterion("contestant_rank in", values, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankNotIn(List<String> values) {
            addCriterion("contestant_rank not in", values, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankBetween(String value1, String value2) {
            addCriterion("contestant_rank between", value1, value2, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantRankNotBetween(String value1, String value2) {
            addCriterion("contestant_rank not between", value1, value2, "contestantRank");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementIsNull() {
            addCriterion("contestant_achievement is null");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementIsNotNull() {
            addCriterion("contestant_achievement is not null");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementEqualTo(String value) {
            addCriterion("contestant_achievement =", value, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementNotEqualTo(String value) {
            addCriterion("contestant_achievement <>", value, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementGreaterThan(String value) {
            addCriterion("contestant_achievement >", value, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementGreaterThanOrEqualTo(String value) {
            addCriterion("contestant_achievement >=", value, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementLessThan(String value) {
            addCriterion("contestant_achievement <", value, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementLessThanOrEqualTo(String value) {
            addCriterion("contestant_achievement <=", value, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementLike(String value) {
            addCriterion("contestant_achievement like", value, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementNotLike(String value) {
            addCriterion("contestant_achievement not like", value, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementIn(List<String> values) {
            addCriterion("contestant_achievement in", values, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementNotIn(List<String> values) {
            addCriterion("contestant_achievement not in", values, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementBetween(String value1, String value2) {
            addCriterion("contestant_achievement between", value1, value2, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAchievementNotBetween(String value1, String value2) {
            addCriterion("contestant_achievement not between", value1, value2, "contestantAchievement");
            return (Criteria) this;
        }

        public Criteria andContestantAwardIsNull() {
            addCriterion("contestant_award is null");
            return (Criteria) this;
        }

        public Criteria andContestantAwardIsNotNull() {
            addCriterion("contestant_award is not null");
            return (Criteria) this;
        }

        public Criteria andContestantAwardEqualTo(String value) {
            addCriterion("contestant_award =", value, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardNotEqualTo(String value) {
            addCriterion("contestant_award <>", value, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardGreaterThan(String value) {
            addCriterion("contestant_award >", value, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardGreaterThanOrEqualTo(String value) {
            addCriterion("contestant_award >=", value, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardLessThan(String value) {
            addCriterion("contestant_award <", value, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardLessThanOrEqualTo(String value) {
            addCriterion("contestant_award <=", value, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardLike(String value) {
            addCriterion("contestant_award like", value, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardNotLike(String value) {
            addCriterion("contestant_award not like", value, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardIn(List<String> values) {
            addCriterion("contestant_award in", values, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardNotIn(List<String> values) {
            addCriterion("contestant_award not in", values, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardBetween(String value1, String value2) {
            addCriterion("contestant_award between", value1, value2, "contestantAward");
            return (Criteria) this;
        }

        public Criteria andContestantAwardNotBetween(String value1, String value2) {
            addCriterion("contestant_award not between", value1, value2, "contestantAward");
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