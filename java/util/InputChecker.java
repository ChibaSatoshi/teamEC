package com.internousdev.kiyurumi.util;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils
;

import com.internousdev.kiyurumi.dao.ProductInfoDAO;
import com.internousdev.kiyurumi.dao.UserInfoDAO;
public class InputChecker {



	public List<String> doCheck(String propertyName,String value,int minLength,int maxLength,boolean availableAlphabeticCharacters,boolean availableKanji,boolean availableHiragana,boolean availableHalfWidthDigit,boolean availableHalfWidthSymbols,boolean availableKatakana,boolean availableFullWidthSymbols){

				List<String> stringList = new ArrayList<String>();
				List<String> characterTypeList = new ArrayList<String>();

				if(StringUtils.isEmpty(value)){
					stringList.add(propertyName + "を入力してください。");
				}

				if(value.length() < minLength || value.length() > maxLength){
					stringList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください。");
				}

				String regularExpression = "";
				String errorExpression = "";

				if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableHalfWidthSymbols||availableKatakana||availableFullWidthSymbols){
					regularExpression = "[^";
				}
				if(!(availableAlphabeticCharacters) || !(availableKanji) || !(availableHiragana) || !(availableHalfWidthDigit) || !(availableHalfWidthSymbols)|| !(availableKatakana)|| !(availableFullWidthSymbols)){
					errorExpression = "[^";
				}

				if(availableAlphabeticCharacters){
					regularExpression +="a-zA-Z";
						characterTypeList.add("半角英字");
				}else{
					errorExpression += "a-zA-Z";
				}

				if(availableKanji){
					regularExpression +="一-龯";
					characterTypeList.add("漢字");
				}else{
					errorExpression +="一-龯";
				}

				if(availableHiragana){
					regularExpression +="ぁ-ん";
					characterTypeList.add("ひらがな");
				}else{
					errorExpression +="ぁ-ん";
				}

				if(availableHalfWidthDigit){
					regularExpression +="0-9";
					characterTypeList.add("半角数字");
				}else{
					errorExpression+="0-9";
				}

				if(availableHalfWidthSymbols){
					regularExpression +="@.,;:!#$%&'*+-/=?^_`{|}~";
					characterTypeList.add("半角記号");
				}else{
					errorExpression +="@.,;:!#$%&'*+-/=?^_`{|}~";
				}

				if(availableKatakana){
					regularExpression +="ァ-ヺ";
					characterTypeList.add("カタカナ");
				}else{
					errorExpression +="ァ-ヺ";
				}

				if(availableFullWidthSymbols){
					regularExpression +="＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
					characterTypeList.add("全角記号");
				}else{
					errorExpression +="＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
				}

				if(!StringUtils.isEmpty(regularExpression)){
					regularExpression +="]+";
				}
				if(!StringUtils.isEmpty(errorExpression)){
					errorExpression +="]+";
				}

				String characterType = "";
				for(int i = 0;i < characterTypeList.size();i++){
					if(i == 0){
						characterType += characterTypeList.get(i).toString();
					}else{
						characterType += "、" + characterTypeList.get(i).toString();
					}
				}
				if(errorExpression.equals("")){
					if(value.matches(regularExpression)){
						stringList.add(propertyName + "は" + characterType + "で入力してください。");
					}
				}else{
					if(value.matches(regularExpression)||(!value.matches(errorExpression)&&!value.equals(""))){
						stringList.add(propertyName + "は" + characterType + "で入力してください。");
					}
				}

				return stringList;
			}


	public List<String> doPasswordCheck(String newPassword,String reConfirmationPassword){
		List<String> stringList = new ArrayList<String>();
		if(!(newPassword.equals(reConfirmationPassword))){
			stringList.add("入力されたパスワードが異なります。");
		}
		return stringList;
	}

//	管理者ユーザー登録時の重複チェック

	public List<String> doLoginIdCheck(String loginId){
		System.out.println("loginId"+loginId);
	List<String> loginIdErrorMessageList= new ArrayList<String>();
		UserInfoDAO dao = new UserInfoDAO();
		int count = dao.checkUserId(loginId);
		System.out.println("重複件数NAME:"+count);
		if(count>0){
			loginIdErrorMessageList.add("そのユーザーID名はすでに登録されています。他の名前に変えてください。");
		}
		return loginIdErrorMessageList;
	}

//ログイン画面エラー
	public List<String> doLoginError(String loginId){
		List<String> loginErrorMessageList=new ArrayList<String>();
		UserInfoDAO dao = new UserInfoDAO();
		int count = dao.checkLoginId(loginId);
		if(count > 0){
			loginErrorMessageList.add("入力されたパスワードが異なります");
		}
		return loginErrorMessageList;
	}

//	管理画面商品追加時の重複チェック
	public List<String> doProductNameCheck(String productName){
		System.out.println("productName"+productName);
		List<String> productNameErrorMessageList=new ArrayList<String>();
		ProductInfoDAO dao = new ProductInfoDAO();
		int count = dao.checkProductName(productName);
		System.out.println("重複件数NAME： "+count);
		if(count > 0){
			productNameErrorMessageList.add("その商品名はすでに登録されています。他の商品名を入力してください。");
		}
		return productNameErrorMessageList;
	}

	public List<String> doProductIdCheck(int productId){
		System.out.println("productId"+productId);
		List<String> productIdErrorMessageList=new ArrayList<String>();
		ProductInfoDAO dao = new ProductInfoDAO();
		int count = dao.checkProductId(productId);
		System.out.println("重複件数ID： "+count);
		if(count > 0){
			productIdErrorMessageList.add("その商品IDはすでに登録されています。他のIDを入力してください。");
		}
		return productIdErrorMessageList;
	}

//	日付分割して入ってるかチェック
	public List<String> doBirthDateCheck(String birthDate){
		List<String> birthDateErrorMessageList=new ArrayList<String>();
		if(birthDate.length()==0){
			birthDateErrorMessageList.add("日付を入力してください。");
		}
		return birthDateErrorMessageList;
	}

//	画像のサイズチェック
	public List<String> doFileNameCheck(String fileName){
		List<String> imageFileNameErrorMessageList=new ArrayList<String>();
		if(fileName.length()==0){
			imageFileNameErrorMessageList.add("画像を選択してください。");
		}
		else if(fileName.length()>30){
			imageFileNameErrorMessageList.add("画像サイズは1文字以上30文字以下で入力してください。");
		}
		return imageFileNameErrorMessageList;
	}

	public List<String> doBirthPlaceCheck(String birthPlace){
		List<String> birthPlaceErrorMessageList=new ArrayList<String>();
		if(!(birthPlace.contains("都") ||birthPlace.contains("道")||birthPlace.contains("府")||birthPlace.contains("県"))){
			birthPlaceErrorMessageList.add("出身地には都道府県まで入力してください。");
		}
		return birthPlaceErrorMessageList;
	}

}
