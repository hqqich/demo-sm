package com.tsinglink.util;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.util.encoders.Hex;

/**
 * Created by ChenHao on 2023/5/25 is 10:11.
 *
 * @author tsinglink
 */

public class SM {

	private static final String CHARSET = "UTF-8";
	private static final String DEFAULT_XRO_KEY = "BC614E";

	public SM() {
//
//        Byte[] hashData = sm3.digest(context.getBytes());
////        String hashData = S("abc"); // 杂凑
//        //System.out.println("hashData: " + new String(hashData));

	}

	public  static String encrypt(String context){
		String cipherStr = null;
		try{

//            String context = "test123456";
			SM3Digest sm3Digest = new SM3Digest();
			byte[] srcData = context.getBytes(CHARSET);
			sm3Digest.update(srcData,0,srcData.length);
			byte[] encrypt = new byte[sm3Digest.getDigestSize()];
			sm3Digest.doFinal(encrypt, 0);

			cipherStr = Hex.toHexString(encrypt);

		} catch (Exception e) {
			//System.out.println("将字符串转换为字节时出现异常:"+ e.getMessage());
		}
		return cipherStr;
	}

	/**
	 * SM3计算hashCode
	 *
	 * @param srcData 待计算数据
	 * @return
	public static byte[] encrypt(byte[] srcData) {
	SM3Digest sm3Digest = new SM3Digest();
	sm3Digest.update(srcData, 0, srcData.length);
	byte[] encrypt = new byte[sm3Digest.getDigestSize()];
	sm3Digest.doFinal(encrypt, 0);
	return encrypt;
	}
	 */
}
