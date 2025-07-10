package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

//利用SHA-256 生成雜湊
public class PasswordHash {
	
	//產生隨機鹽質
	public static String generateSalt() {
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);//將byte[] 透過Base64編碼後輸出
	}
	//密碼雜湊函式
	public static String getHashPassword(String password,String salt) {
			
		try {
			//建立一個SHA-256雜湊演算法實例
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			//加鹽
			md.update(salt.getBytes());
			
			//將密碼字串轉成位元組陣列並進行雜湊運算
			byte[] hashBytes = md.digest(password.getBytes());
			//建立一個StringBuffer 用來組合雜湊後的16進位字串
			StringBuffer sb = new StringBuffer();
			for(byte b : hashBytes ) {
				String hex = Integer.toHexString(0xff & b);
				if(hex.length()==1)sb.append('0');//若只有一位數補0
				sb.append(hex);
			}
			return sb.toString();
			//return Arrays.toString(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
//		System.out.println("密碼: 1234 Hash"+getHashPassword("1234"));
//		System.out.println("密碼: 5678 Hash"+getHashPassword("5678"));
		
		String password ="1234";//密碼明文
		String salt = generateSalt();//鹽
		String hash= getHashPassword(password, salt);//密碼(加密)雜湊
		System.out.printf("密碼明文:%s  鹽:%s 雜湊:%s%n" ,password,salt,hash);
		
		password ="5678";//密碼明文
		salt = generateSalt();//鹽
		hash= getHashPassword(password, salt);//密碼(加密)雜湊
		System.out.printf("密碼明文:%s  鹽:%s 雜湊:%s%n" ,password,salt,hash);
		
		password ="1234";//密碼明文
		salt = generateSalt();//鹽
		hash= getHashPassword(password, salt);//密碼(加密)雜湊
		System.out.printf("密碼明文:%s  鹽:%s 雜湊:%s%n" ,password,salt,hash);
	
	}
}
