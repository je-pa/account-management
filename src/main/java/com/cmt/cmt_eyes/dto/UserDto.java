package com.cmt.cmt_eyes.dto;

import com.cmt.cmt_eyes.entity.PwReseted;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
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
}

