package com.dsynhub.digitalgsrtc.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ValidationUtils 
{
	public static boolean isEmpty(String param)
	{
		boolean isEmpty = false;
		if(param=="" || param.trim().length()<=0)
		{
			isEmpty = true;	
		}
		return isEmpty;
	}
	
	public static String getDay(int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, day);
		return c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG,
				new Locale("en"));

	}

	
	public static boolean equalcmd(String param) {
		boolean iseql=false;
		if(param.equals("-- Select Any One --"))
		{
			iseql=true;
		}
		return iseql;
	}
	
    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }

    
    static Pattern pattern;
	static Matcher matcher;
	public static final String DEFAULT_ENCODING="UTF-8"; 
	   static BASE64Encoder enc=new BASE64Encoder();
	   static BASE64Decoder dec=new BASE64Decoder();

	   public static String base64encode(String text){
	      try {
	         String rez = enc.encode( text.getBytes( DEFAULT_ENCODING ) );
	         return rez;         
	      }
	      catch ( UnsupportedEncodingException e ) {
	         return null;
	      }
	   }//base64encode

	   public static String base64decode(String text){

	         try {
	            return new String(dec.decodeBuffer( text ),DEFAULT_ENCODING);
	         }
	         catch ( IOException e ) {
	           return null;
	         }
	   }
	   
	   private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.A-Za-z0-9]+)"
				+ "*(\\.[A-Za-z]{2,})$";
	   public static boolean EmailFormatValidator(String email) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(email);
			if (matcher.matches() && email.endsWith(".com"))
				return true;
			return false;
		}
	
}
