package com.guet.match.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UmsOrganizerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsOrganizerExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public Criteria andAdminNameIsNull() {
            addCriterion("admin_name is null");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNotNull() {
            addCriterion("admin_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdminNameEqualTo(String value) {
            addCriterion("admin_name =", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotEqualTo(String value) {
            addCriterion("admin_name <>", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThan(String value) {
            addCriterion("admin_name >", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_name >=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThan(String value) {
            addCriterion("admin_name <", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThanOrEqualTo(String value) {
            addCriterion("admin_name <=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLike(String value) {
            addCriterion("admin_name like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotLike(String value) {
            addCriterion("admin_name not like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameIn(List<String> values) {
            addCriterion("admin_name in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotIn(List<String> values) {
            addCriterion("admin_name not in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameBetween(String value1, String value2) {
            addCriterion("admin_name between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotBetween(String value1, String value2) {
            addCriterion("admin_name not between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIsNull() {
            addCriterion("admin_phone is null");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIsNotNull() {
            addCriterion("admin_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneEqualTo(String value) {
            addCriterion("admin_phone =", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotEqualTo(String value) {
            addCriterion("admin_phone <>", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneGreaterThan(String value) {
            addCriterion("admin_phone >", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("admin_phone >=", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLessThan(String value) {
            addCriterion("admin_phone <", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLessThanOrEqualTo(String value) {
            addCriterion("admin_phone <=", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLike(String value) {
            addCriterion("admin_phone like", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotLike(String value) {
            addCriterion("admin_phone not like", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIn(List<String> values) {
            addCriterion("admin_phone in", values, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotIn(List<String> values) {
            addCriterion("admin_phone not in", values, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneBetween(String value1, String value2) {
            addCriterion("admin_phone between", value1, value2, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotBetween(String value1, String value2) {
            addCriterion("admin_phone not between", value1, value2, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardIsNull() {
            addCriterion("admin_ID_card is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardIsNotNull() {
            addCriterion("admin_ID_card is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardEqualTo(String value) {
            addCriterion("admin_ID_card =", value, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardNotEqualTo(String value) {
            addCriterion("admin_ID_card <>", value, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardGreaterThan(String value) {
            addCriterion("admin_ID_card >", value, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("admin_ID_card >=", value, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardLessThan(String value) {
            addCriterion("admin_ID_card <", value, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardLessThanOrEqualTo(String value) {
            addCriterion("admin_ID_card <=", value, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardLike(String value) {
            addCriterion("admin_ID_card like", value, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardNotLike(String value) {
            addCriterion("admin_ID_card not like", value, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardIn(List<String> values) {
            addCriterion("admin_ID_card in", values, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardNotIn(List<String> values) {
            addCriterion("admin_ID_card not in", values, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardBetween(String value1, String value2) {
            addCriterion("admin_ID_card between", value1, value2, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andAdminIdCardNotBetween(String value1, String value2) {
            addCriterion("admin_ID_card not between", value1, value2, "adminIdCard");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameIsNull() {
            addCriterion("organizer_name is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameIsNotNull() {
            addCriterion("organizer_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameEqualTo(String value) {
            addCriterion("organizer_name =", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameNotEqualTo(String value) {
            addCriterion("organizer_name <>", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameGreaterThan(String value) {
            addCriterion("organizer_name >", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameGreaterThanOrEqualTo(String value) {
            addCriterion("organizer_name >=", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameLessThan(String value) {
            addCriterion("organizer_name <", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameLessThanOrEqualTo(String value) {
            addCriterion("organizer_name <=", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameLike(String value) {
            addCriterion("organizer_name like", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameNotLike(String value) {
            addCriterion("organizer_name not like", value, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameIn(List<String> values) {
            addCriterion("organizer_name in", values, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameNotIn(List<String> values) {
            addCriterion("organizer_name not in", values, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameBetween(String value1, String value2) {
            addCriterion("organizer_name between", value1, value2, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerNameNotBetween(String value1, String value2) {
            addCriterion("organizer_name not between", value1, value2, "organizerName");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeIsNull() {
            addCriterion("organizer_type is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeIsNotNull() {
            addCriterion("organizer_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeEqualTo(Integer value) {
            addCriterion("organizer_type =", value, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeNotEqualTo(Integer value) {
            addCriterion("organizer_type <>", value, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeGreaterThan(Integer value) {
            addCriterion("organizer_type >", value, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("organizer_type >=", value, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeLessThan(Integer value) {
            addCriterion("organizer_type <", value, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("organizer_type <=", value, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeIn(List<Integer> values) {
            addCriterion("organizer_type in", values, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeNotIn(List<Integer> values) {
            addCriterion("organizer_type not in", values, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeBetween(Integer value1, Integer value2) {
            addCriterion("organizer_type between", value1, value2, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("organizer_type not between", value1, value2, "organizerType");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeIsNull() {
            addCriterion("organizer_code is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeIsNotNull() {
            addCriterion("organizer_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeEqualTo(String value) {
            addCriterion("organizer_code =", value, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeNotEqualTo(String value) {
            addCriterion("organizer_code <>", value, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeGreaterThan(String value) {
            addCriterion("organizer_code >", value, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("organizer_code >=", value, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeLessThan(String value) {
            addCriterion("organizer_code <", value, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeLessThanOrEqualTo(String value) {
            addCriterion("organizer_code <=", value, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeLike(String value) {
            addCriterion("organizer_code like", value, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeNotLike(String value) {
            addCriterion("organizer_code not like", value, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeIn(List<String> values) {
            addCriterion("organizer_code in", values, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeNotIn(List<String> values) {
            addCriterion("organizer_code not in", values, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeBetween(String value1, String value2) {
            addCriterion("organizer_code between", value1, value2, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andOrganizerCodeNotBetween(String value1, String value2) {
            addCriterion("organizer_code not between", value1, value2, "organizerCode");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentIsNull() {
            addCriterion("identity_document is null");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentIsNotNull() {
            addCriterion("identity_document is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentEqualTo(String value) {
            addCriterion("identity_document =", value, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentNotEqualTo(String value) {
            addCriterion("identity_document <>", value, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentGreaterThan(String value) {
            addCriterion("identity_document >", value, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentGreaterThanOrEqualTo(String value) {
            addCriterion("identity_document >=", value, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentLessThan(String value) {
            addCriterion("identity_document <", value, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentLessThanOrEqualTo(String value) {
            addCriterion("identity_document <=", value, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentLike(String value) {
            addCriterion("identity_document like", value, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentNotLike(String value) {
            addCriterion("identity_document not like", value, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentIn(List<String> values) {
            addCriterion("identity_document in", values, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentNotIn(List<String> values) {
            addCriterion("identity_document not in", values, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentBetween(String value1, String value2) {
            addCriterion("identity_document between", value1, value2, "identityDocument");
            return (Criteria) this;
        }

        public Criteria andIdentityDocumentNotBetween(String value1, String value2) {
            addCriterion("identity_document not between", value1, value2, "identityDocument");
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