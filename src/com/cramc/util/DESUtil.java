package com.cramc.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

/**
 * DES加密工具类
 * @author duxianchao
 */
public class DESUtil {
	  private static final String strKey = "Middle and re assets";//锟街凤拷锟斤拷钥写锟斤拷锟斤拷锟斤拷锟节硷拷锟杰斤拷锟斤拷使锟斤拷
	  private Key key;
	  private byte[] byteMi = null;
	  private byte[] byteMing = null;
	  private String strMi= "";
	  private String strM= ""; 
	  //  锟斤拷莶锟斤拷锟斤拷锟斤拷KEY   
	  private void setKey(String strKey){ 
	   try{  
	        KeyGenerator _generator = KeyGenerator.getInstance("DES");  
	        _generator.init(new SecureRandom(strKey.getBytes()));  
	        this.key = _generator.generateKey();  
	        _generator=null;
	    }catch(Exception e){
	    	e.printStackTrace();
	     }
	   
	    }  
	  //  锟斤拷锟斤拷String锟斤拷锟斤拷锟斤拷锟斤拷,String锟斤拷锟斤拷锟斤拷锟� 
	  private void setEncString(String strMing){
	    BASE64Encoder base64en = new BASE64Encoder();  
	    try {
		      this.byteMing = strMing.getBytes("UTF8");  
		      this.byteMi = this.getEncCode(this.byteMing);  
		      this.strMi = base64en.encode(this.byteMi);
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	      this.byteMing = null;  
	      this.byteMi = null;
	      }
	  }  
	  // 锟斤拷锟斤拷:锟斤拷String锟斤拷锟斤拷锟斤拷锟斤拷,String锟斤拷锟斤拷锟斤拷锟�  
	  private void setDesString(String strMi){  
		  BASE64Decoder base64De = new BASE64Decoder();   
	      try{
		      this.byteMi = base64De.decodeBuffer(strMi);  
		      this.byteMing = this.getDesCode(byteMi);  
		      this.strM = new String(byteMing,"UTF8");  
	      }catch(Exception e){
	          e.printStackTrace();
	      }finally{
		      base64De = null;  
		      byteMing = null;  
		      byteMi = null;
	      }  
	  
	  }
	  //锟斤拷锟斤拷锟斤拷byte[]锟斤拷锟斤拷锟斤拷锟斤拷,byte[]锟斤拷锟斤拷锟斤拷锟�   
	  private byte[] getEncCode(byte[] byteS){
		   byte[] byteFina = null;  
		   Cipher cipher;  
	      try{
		      cipher = Cipher.getInstance("DES");  
		      cipher.init(Cipher.ENCRYPT_MODE,key);  
		      byteFina = cipher.doFinal(byteS);
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }finally{
	    	  cipher = null;
	     }
	      return byteFina;
	  } 

	  // 锟斤拷锟斤拷锟斤拷byte[]锟斤拷锟斤拷锟斤拷锟斤拷,锟斤拷byte[]锟斤拷锟斤拷锟斤拷锟�   
	 private byte[] getDesCode(byte[] byteD){
	    Cipher cipher;  
	    byte[] byteFina=null;  
	    try{
		      cipher = Cipher.getInstance("DES");  
		      cipher.init(Cipher.DECRYPT_MODE,key);  
		      byteFina = cipher.doFinal(byteD);
	    }catch(Exception e){
		   System.out.println("锟斤拷锟斤拷锟侥诧拷锟斤拷DES锟斤拷锟杰ｏ拷getDescCode(byte[] byteD)锟斤拷锟斤拷锟斤拷锟斤拷失锟斤拷");
		   e.printStackTrace();
	    }finally{
	      cipher=null;
	      }  
	    return byteFina;
	  } 
	  //锟斤拷锟截硷拷锟杰猴拷锟斤拷锟斤拷锟絪trMi  
	 private String getStrMi()
	  {
	   return strMi;
	  }
	  //锟斤拷锟截斤拷锟杰猴拷锟斤拷锟斤拷锟�
	 private String getStrM()
	  {
	   return strM;
	  }
	  
	  /**
	   * 锟斤拷锟杰凤拷锟斤拷
	   * @param strM 要锟斤拷锟杰碉拷锟斤拷锟斤拷
	   * @return
	   */
	  public static String enCode(String strM){
		  DESUtil des = new DESUtil();
		  des.setKey(strKey);
		  des.setEncString(strM);//锟斤拷要锟斤拷锟杰碉拷锟斤拷锟侥达拷锟酵革拷Encrypt.java锟斤拷锟叫硷拷锟杰硷拷锟姐。
		  return des.getStrMi();
	  }
	  
	  /**
	   * 锟斤拷锟杰凤拷锟斤拷
	   * @param strMi 要锟斤拷锟杰碉拷锟斤拷锟斤拷
	   * @return
	   */
	  public static String deCode(String strMi){
		  DESUtil des = new DESUtil();
		  des.setKey(strKey);
		  des.setDesString(strMi);   //锟斤拷要锟斤拷锟杰碉拷锟斤拷锟斤拷
		  return des.getStrM();
	  }
	  
}
