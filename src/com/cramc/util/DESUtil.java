package com.cramc.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

/**
 * DES加密、解密工具类
 * @author chenwj
 */
public class DESUtil {
	  private static final String strKey = "Middle and re assets";  
	  private Key key;                   //秘钥
	  private byte[] byteMi = null;      //密文数组
	  private byte[] byteMing = null;    //明文数组
	  private String strMi= "";          //密文
	  private String strMing= "";        //明文
	  
	  
	 /**
	  * 加密
	  * @param strMing 明文
	  * @return
	  */
	  public static String encrypt(String strMing){
		  DESUtil des = new DESUtil();
		  des.setKey(strKey);
		  des.setEncString(strMing);
		  return des.getStrMi();
	  }
		  
	  /**
	   * 解密
	   * @param strMing 密文
	   * @return
	   */
	  public static String decrypt(String strMi){
		  DESUtil des = new DESUtil();
		  des.setKey(strKey);
		  des.setDesString(strMi);   
		  return des.getStrMing();
	  }
	  
	  /**
	   * 获取密文
	   * @return
	   */
	  private String getStrMi(){
		  return strMi;
	  }
		 
	  /**
	   * 获取明文
	   * @return
	   */
	 private String getStrMing(){
		 return strMing;
	 }
	
	  /**
	   * 生成秘钥
	   * @param strKey
	   */
	  private void setKey(String strKey){ 
	   try{  
	        KeyGenerator generator = KeyGenerator.getInstance("DES");  
	        generator.init(new SecureRandom(strKey.getBytes()));     //选择DES加密，秘钥长度必须为56位
	        this.key = generator.generateKey();  
	        generator=null;
	    }catch(Exception e){
	    	e.printStackTrace();
	     }
	   }  
	  
	
	  /**
	   * 先用DES加密，再用base64加密
	   * @param strMing
	   */
	  private void setEncString(String strMing){
	    BASE64Encoder base64en = new BASE64Encoder();  
	    try {
		      this.byteMing = strMing.getBytes("UTF8");  
		      this.byteMi = this.desEncrypt(this.byteMing);  
		      this.strMi = base64en.encode(this.byteMi);
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	      this.byteMing = null;  
	      this.byteMi = null;
	      }
	  }  
	  
	 /**
	  * 先用base64解密，再用DES解密
	  * @param strMi
	  */
	  private void setDesString(String strMi){  
		  BASE64Decoder base64De = new BASE64Decoder();   
	      try{
		      this.byteMi = base64De.decodeBuffer(strMi);  
		      this.byteMing = this.desDecrypt(byteMi);  
		      this.strMing = new String(byteMing,"UTF8");  
	      }catch(Exception e){
	          e.printStackTrace();
	      }finally{
		      base64De = null;  
		      byteMing = null;  
		      byteMi = null;
	      }  
	  
	  }
	  
	  /**
	   * DES加密
	   * @param byteMing 明文数组 
	   * @return
	   */
	  private byte[] desEncrypt(byte[] byteMing){
		   byte[] byteFina = null;  
		   Cipher cipher;  
	      try{
		      cipher = Cipher.getInstance("DES");  
		      cipher.init(Cipher.ENCRYPT_MODE,key);  
		      byteFina = cipher.doFinal(byteMing);
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }finally{
	    	  cipher = null;
	     }
	      return byteFina;
	  } 

	  
	  /**
	   * DES解密
	   * @param byteD
	   * @return
	   */
	 private byte[] desDecrypt(byte[] byteD){
	    Cipher cipher;  
	    byte[] byteFina=null;  
	    try{
	        cipher = Cipher.getInstance("DES");  
	        cipher.init(Cipher.DECRYPT_MODE,key);  
	        byteFina = cipher.doFinal(byteD);
	    }catch(Exception e){
		   e.printStackTrace();
	    }finally{
	      cipher=null;
	      }  
	    return byteFina;
	  } 
	 
	 
}
