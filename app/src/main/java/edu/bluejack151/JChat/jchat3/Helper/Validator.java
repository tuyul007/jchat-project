package edu.bluejack151.JChat.jchat3.Helper;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by ASUS on 23/12/2015.
 */
public class Validator {
    public static boolean checkUserID(String userId){
        //6-8 huruf/angka

        if(!checkLength(userId,6,8)){
            return false;
        }else{
            for (int i=0; i< userId.length(); i++){
                if(!Character.isLetter(userId.charAt(i))){
                    if(!Character.isDigit(userId.charAt(i)))return false;
                }

            }
        }
        return true;
    }
    public static boolean isAlpha(String word){
        for (int i=0; i< word.length(); i++){
            if(!Character.isLetter(word.charAt(i)))return false;
        }
        return true;
    }
    public static boolean validateEmail(CharSequence email){
        if(TextUtils.isEmpty(email)){
            return false;
        }else{
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

    }
    public static boolean checkLength(String word, int minLength, int maxLength){
        if(word.length() < minLength || word.length() > maxLength)return false;
        return true;
    }

    public static boolean isAlphaNumeric(String word){
        boolean alpha= false, digit=false;
        for(int i=0; i< word.length(); i++){
            if(Character.isLetter(word.charAt(i))){
                if(digit)return true;
                alpha = true;
            }
            if(Character.isDigit(word.charAt(i))){
                if(alpha)return true;
                digit = true;
            }
        }
        return false;
    }

}
