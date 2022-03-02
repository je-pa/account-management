package com.cmt.cmt_eyes.dto;

import com.cmt.cmt_eyes.entity.PwReseted;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//@Getter
//@Setter
//@ToString
public class UserDto {
    public interface PwValidationGroup {}
    public interface UserCreateValidationGroup {}
    @NotBlank(message = "userId는 필수 입력 값입니다." ,groups = {UserCreateValidationGroup.class})
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다." ,groups = {PwValidationGroup.class})
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다."
            ,groups = {PwValidationGroup.class}) // \W:word문자아님 \S:공백아님 \:특수문자아닌 문자 $:문장의 끝
    private String userPw;

    private String applicant;

    @NotNull(message = "계정분류를 선택해 주세요" ,groups = {UserCreateValidationGroup.class})
    private Integer userSortId;

    @NotBlank(message = "이름은 필수 입력 값입니다." ,groups = {UserCreateValidationGroup.class})
    private String userName;

    @NotBlank(message = "e-mail은 필수 입력 값입니다." ,groups = {UserCreateValidationGroup.class})
    @Email(message = "e-mail형식을 맞춰 주세요." ,groups = {UserCreateValidationGroup.class})
    private String email;

    private String company;
    private String department;
    private String position;
    private String contact;
    private String note;
    private String representative;
    private PwReseted pwReseted;
    private String approval;
    private String reportingDate;

    public UserDto() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Integer getUserSortId() {
        return userSortId;
    }

    public void setUserSortId(Integer userSortId) {
        this.userSortId = userSortId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public PwReseted getPwReseted() {
        return pwReseted;
    }

    public void setPwReseted(PwReseted pwReseted) {
        this.pwReseted = pwReseted;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(String reportingDate) {
        this.reportingDate = reportingDate;
    }
}

