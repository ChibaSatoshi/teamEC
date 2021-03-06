package com.internousdev.kiyurumi.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserUpdateConfirmAction extends ActionSupport implements SessionAware{

	private int id;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private int status;
	private String email;
	private String loginId;
	private String password;
	private Date registDate;
	public Map<String ,Object> session;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexvalue = MALE;

	private List<String> familyNameErrorMessageList = new ArrayList<String>();
	private List<String> firstNameErrorMessageList = new ArrayList<String>();
	private List<String> familyNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> firstNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> emailErrorMessageList = new ArrayList<String>();
	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> loginIdCheckMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();

	public String execute(){
		System.out.println(id);
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();
		session.put("id", id);
		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("fristNameKana", firstNameKana);

		if(sex==null){
			session.put("sex", MALE);
		}else{
			session.put("sex", String.valueOf(session.get("sex")));
		}
		sexList.add(MALE);
		sexList.add(FEMALE);
		session.put("sexList", sexList);
		session.put("status", status);
		session.put("email", email);
		session.put("loginId", loginId);
		session.put("password", password);
		session.put("registDate", registDate);

		familyNameErrorMessageList=inputChecker.doCheck("姓", familyName,1,16, true,true,true, false,false,true,false );
		firstNameErrorMessageList=inputChecker.doCheck("名", firstName,1 ,16 , true,true,true, false,false,true,false );
		familyNameKanaErrorMessageList=inputChecker.doCheck("姓ふりがな", familyNameKana,1 ,16 ,false ,false ,true ,false ,false ,false ,false );
		firstNameKanaErrorMessageList=inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false,false );
		emailErrorMessageList=inputChecker.doCheck("メールアドレス", email, 14, 32, true, false, false, true,true, false, false );
		loginIdErrorMessageList=inputChecker.doCheck("ユーザID", loginId, 1, 8, true, false, false, true, false, false, false);
		passwordErrorMessageList=inputChecker.doCheck("パスワード", password, 1, 16,true, false, false, true, false, false, false);

		loginIdCheckMessageList=inputChecker.doLoginIdCheck(loginId);

		if(familyNameErrorMessageList.size()==0
				&& firstNameErrorMessageList.size()==0
				&& familyNameKanaErrorMessageList.size()==0
				&& firstNameKanaErrorMessageList.size()==0
				&& emailErrorMessageList.size()==0
				&& loginIdErrorMessageList.size()==0
				&& loginIdCheckMessageList.size()==0
				&& passwordErrorMessageList.size()==0
				){
			result = SUCCESS;
		}else{
			session.put("familyNameErrorMessageList", familyNameErrorMessageList);
			session.put("firstNameErrorMessageList",firstNameErrorMessageList);
			session.put("familyNameKanaErrorMessageList", familyNameKanaErrorMessageList);
			session.put("firstNameKanaErrorMessageList", firstNameKanaErrorMessageList);
			session.put("emailErrorMessageList", emailErrorMessageList);
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("loginIdCheckMessageList", loginIdCheckMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			result = ERROR;
		}
		System.out.println();
	return result;
	}

	public List<String> getLoginIdCheckMessageList() {
		return loginIdCheckMessageList;
	}

	public void setLoginIdCheckMessageList(List<String> loginIdCheckMessageList) {
		this.loginIdCheckMessageList = loginIdCheckMessageList;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getDefaultSexvalue() {
		return defaultSexvalue;
	}

	public void setDefaultSexvalue(String defaultSexvalue) {
		this.defaultSexvalue = defaultSexvalue;
	}

	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}

	public void setFamilyNameErrorMessageList(List<String> familyNameErrorMessageList) {
		this.familyNameErrorMessageList = familyNameErrorMessageList;
	}

	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}

	public void setFirstNameErrorMessageList(List<String> firstNameErrorMessageList) {
		this.firstNameErrorMessageList = firstNameErrorMessageList;
	}

	public List<String> getFamilyNameKanaErrorMessageList() {
		return familyNameKanaErrorMessageList;
	}

	public void setFamilyNameKanaErrorMessageList(List<String> familyNameKanaErrorMessageList) {
		this.familyNameKanaErrorMessageList = familyNameKanaErrorMessageList;
	}

	public List<String> getFirstNameKanaErrorMessageList() {
		return firstNameKanaErrorMessageList;
	}

	public void setFirstNameKanaErrorMessageList(List<String> firstNameKanaErrorMessageList) {
		this.firstNameKanaErrorMessageList = firstNameKanaErrorMessageList;
	}

	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}

	public void setEmailErrorMessageList(List<String> emailErrorMessageList) {
		this.emailErrorMessageList = emailErrorMessageList;
	}


	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}


}