package com.guet.match.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsContestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmsContestExample() {
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

        public Criteria andOrganizerIdIsNull() {
            addCriterion("organizer_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdIsNotNull() {
            addCriterion("organizer_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdEqualTo(Long value) {
            addCriterion("organizer_id =", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdNotEqualTo(Long value) {
            addCriterion("organizer_id <>", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdGreaterThan(Long value) {
            addCriterion("organizer_id >", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("organizer_id >=", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdLessThan(Long value) {
            addCriterion("organizer_id <", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdLessThanOrEqualTo(Long value) {
            addCriterion("organizer_id <=", value, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdIn(List<Long> values) {
            addCriterion("organizer_id in", values, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdNotIn(List<Long> values) {
            addCriterion("organizer_id not in", values, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdBetween(Long value1, Long value2) {
            addCriterion("organizer_id between", value1, value2, "organizerId");
            return (Criteria) this;
        }

        public Criteria andOrganizerIdNotBetween(Long value1, Long value2) {
            addCriterion("organizer_id not between", value1, value2, "organizerId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andBannerIsNull() {
            addCriterion("banner is null");
            return (Criteria) this;
        }

        public Criteria andBannerIsNotNull() {
            addCriterion("banner is not null");
            return (Criteria) this;
        }

        public Criteria andBannerEqualTo(String value) {
            addCriterion("banner =", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotEqualTo(String value) {
            addCriterion("banner <>", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThan(String value) {
            addCriterion("banner >", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerGreaterThanOrEqualTo(String value) {
            addCriterion("banner >=", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerLessThan(String value) {
            addCriterion("banner <", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerLessThanOrEqualTo(String value) {
            addCriterion("banner <=", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerLike(String value) {
            addCriterion("banner like", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotLike(String value) {
            addCriterion("banner not like", value, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerIn(List<String> values) {
            addCriterion("banner in", values, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotIn(List<String> values) {
            addCriterion("banner not in", values, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerBetween(String value1, String value2) {
            addCriterion("banner between", value1, value2, "banner");
            return (Criteria) this;
        }

        public Criteria andBannerNotBetween(String value1, String value2) {
            addCriterion("banner not between", value1, value2, "banner");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeIsNull() {
            addCriterion("open_enrollment_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeIsNotNull() {
            addCriterion("open_enrollment_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeEqualTo(Date value) {
            addCriterion("open_enrollment_time =", value, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeNotEqualTo(Date value) {
            addCriterion("open_enrollment_time <>", value, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeGreaterThan(Date value) {
            addCriterion("open_enrollment_time >", value, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_enrollment_time >=", value, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeLessThan(Date value) {
            addCriterion("open_enrollment_time <", value, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_enrollment_time <=", value, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeIn(List<Date> values) {
            addCriterion("open_enrollment_time in", values, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeNotIn(List<Date> values) {
            addCriterion("open_enrollment_time not in", values, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeBetween(Date value1, Date value2) {
            addCriterion("open_enrollment_time between", value1, value2, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andOpenEnrollmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_enrollment_time not between", value1, value2, "openEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeIsNull() {
            addCriterion("close_enrollment_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeIsNotNull() {
            addCriterion("close_enrollment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeEqualTo(Date value) {
            addCriterion("close_enrollment_time =", value, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeNotEqualTo(Date value) {
            addCriterion("close_enrollment_time <>", value, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeGreaterThan(Date value) {
            addCriterion("close_enrollment_time >", value, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("close_enrollment_time >=", value, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeLessThan(Date value) {
            addCriterion("close_enrollment_time <", value, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("close_enrollment_time <=", value, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeIn(List<Date> values) {
            addCriterion("close_enrollment_time in", values, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeNotIn(List<Date> values) {
            addCriterion("close_enrollment_time not in", values, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeBetween(Date value1, Date value2) {
            addCriterion("close_enrollment_time between", value1, value2, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andCloseEnrollmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("close_enrollment_time not between", value1, value2, "closeEnrollmentTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeIsNull() {
            addCriterion("contest_time is null");
            return (Criteria) this;
        }

        public Criteria andContestTimeIsNotNull() {
            addCriterion("contest_time is not null");
            return (Criteria) this;
        }

        public Criteria andContestTimeEqualTo(Date value) {
            addCriterion("contest_time =", value, "contestTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeNotEqualTo(Date value) {
            addCriterion("contest_time <>", value, "contestTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeGreaterThan(Date value) {
            addCriterion("contest_time >", value, "contestTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("contest_time >=", value, "contestTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeLessThan(Date value) {
            addCriterion("contest_time <", value, "contestTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeLessThanOrEqualTo(Date value) {
            addCriterion("contest_time <=", value, "contestTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeIn(List<Date> values) {
            addCriterion("contest_time in", values, "contestTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeNotIn(List<Date> values) {
            addCriterion("contest_time not in", values, "contestTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeBetween(Date value1, Date value2) {
            addCriterion("contest_time between", value1, value2, "contestTime");
            return (Criteria) this;
        }

        public Criteria andContestTimeNotBetween(Date value1, Date value2) {
            addCriterion("contest_time not between", value1, value2, "contestTime");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdIsNull() {
            addCriterion("last_check_id is null");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdIsNotNull() {
            addCriterion("last_check_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdEqualTo(Long value) {
            addCriterion("last_check_id =", value, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdNotEqualTo(Long value) {
            addCriterion("last_check_id <>", value, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdGreaterThan(Long value) {
            addCriterion("last_check_id >", value, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdGreaterThanOrEqualTo(Long value) {
            addCriterion("last_check_id >=", value, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdLessThan(Long value) {
            addCriterion("last_check_id <", value, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdLessThanOrEqualTo(Long value) {
            addCriterion("last_check_id <=", value, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdIn(List<Long> values) {
            addCriterion("last_check_id in", values, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdNotIn(List<Long> values) {
            addCriterion("last_check_id not in", values, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdBetween(Long value1, Long value2) {
            addCriterion("last_check_id between", value1, value2, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckIdNotBetween(Long value1, Long value2) {
            addCriterion("last_check_id not between", value1, value2, "lastCheckId");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeIsNull() {
            addCriterion("last_check_time is null");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeIsNotNull() {
            addCriterion("last_check_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeEqualTo(Date value) {
            addCriterion("last_check_time =", value, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeNotEqualTo(Date value) {
            addCriterion("last_check_time <>", value, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeGreaterThan(Date value) {
            addCriterion("last_check_time >", value, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_check_time >=", value, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeLessThan(Date value) {
            addCriterion("last_check_time <", value, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_check_time <=", value, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeIn(List<Date> values) {
            addCriterion("last_check_time in", values, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeNotIn(List<Date> values) {
            addCriterion("last_check_time not in", values, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeBetween(Date value1, Date value2) {
            addCriterion("last_check_time between", value1, value2, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_check_time not between", value1, value2, "lastCheckTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteIsNull() {
            addCriterion("last_check_note is null");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteIsNotNull() {
            addCriterion("last_check_note is not null");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteEqualTo(String value) {
            addCriterion("last_check_note =", value, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteNotEqualTo(String value) {
            addCriterion("last_check_note <>", value, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteGreaterThan(String value) {
            addCriterion("last_check_note >", value, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteGreaterThanOrEqualTo(String value) {
            addCriterion("last_check_note >=", value, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteLessThan(String value) {
            addCriterion("last_check_note <", value, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteLessThanOrEqualTo(String value) {
            addCriterion("last_check_note <=", value, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteLike(String value) {
            addCriterion("last_check_note like", value, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteNotLike(String value) {
            addCriterion("last_check_note not like", value, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteIn(List<String> values) {
            addCriterion("last_check_note in", values, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteNotIn(List<String> values) {
            addCriterion("last_check_note not in", values, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteBetween(String value1, String value2) {
            addCriterion("last_check_note between", value1, value2, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andLastCheckNoteNotBetween(String value1, String value2) {
            addCriterion("last_check_note not between", value1, value2, "lastCheckNote");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("cate_id is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Long value) {
            addCriterion("cate_id =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Long value) {
            addCriterion("cate_id <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Long value) {
            addCriterion("cate_id >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cate_id >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Long value) {
            addCriterion("cate_id <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Long value) {
            addCriterion("cate_id <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Long> values) {
            addCriterion("cate_id in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Long> values) {
            addCriterion("cate_id not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Long value1, Long value2) {
            addCriterion("cate_id between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Long value1, Long value2) {
            addCriterion("cate_id not between", value1, value2, "cateId");
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