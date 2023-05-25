package com.tsinglink;

import com.google.gson.Gson;
import com.tsinglink.util.Sm2Util;
import com.tsinglink.util.Util4Hex;
import java.util.HashMap;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
		extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() throws Exception {
        //System.out.println(SM.encrypt("pwd + str2 + model_name"));
		//
		//// =============	ecc:
    	////#ECC公钥加密
		//String publicKey =  "3059301306072a8648ce3d020106082a811ccf5501822d03420004ee3b75cc22bc05465e9a98538b1b4c607498d3ffdc8747e396d86b071c887985ea7ceeb12171decf354981d809937a46ef86d2d8989482e9541362a19adbb794";
		//
    	////#ECC私钥解密
		//String privateKey =  "308193020100301306072a8648ce3d020106082a811ccf5501822d047930770201010420f65ba8f8bbf47fc22ff7f8c8e3b59627e17e2533f5cb9bd4ecc53077a8ea2612a00a06082a811ccf5501822da14403420004ee3b75cc22bc05465e9a98538b1b4c607498d3ffdc8747e396d86b071c887985ea7ceeb12171decf354981d809937a46ef86d2d8989482e9541362a19adbb794";
		//
		//HashMap<String, Object> dataMap = new HashMap<String, Object>();
		//dataMap.put("id_card", "340824199612031430");
		//dataMap.put("cardid", "001");
		//
		//String json = new Gson().toJson(dataMap);
		//System.out.println("被加密 字符串：" + json);
		//
		//String data = Util4Hex.bytesToHexString(Sm2Util.encryptPublic(publicKey, json.getBytes("UTF-8")));
		//System.out.println("加密后的数据(16进制字符串)为：" + data);
		//
		//byte[] bytes = Sm2Util.decryptPrivate(privateKey, Util4Hex.hexStringToBytes(data));
		//String s = new String(bytes, "UTF-8");
		//System.out.println("解密后 字符串："+s);

		System.out.println("341223199902050118 => " + getString("1", "341223199902050118"));
		System.out.println("342427199704250925 => " + getString("1", "342427199704250925"));
		System.out.println("341125199704102906 => " + getString("1", "341125199704102906"));
		System.out.println("342423199909170608 => " + getString("1", "342423199909170608"));

	}


	String getString(String card, String id) {

		try {
			// =============	ecc:
			//#ECC公钥加密
			String publicKey =  "3059301306072a8648ce3d020106082a811ccf5501822d03420004ee3b75cc22bc05465e9a98538b1b4c607498d3ffdc8747e396d86b071c887985ea7ceeb12171decf354981d809937a46ef86d2d8989482e9541362a19adbb794";

			//#ECC私钥解密
			String privateKey =  "308193020100301306072a8648ce3d020106082a811ccf5501822d047930770201010420f65ba8f8bbf47fc22ff7f8c8e3b59627e17e2533f5cb9bd4ecc53077a8ea2612a00a06082a811ccf5501822da14403420004ee3b75cc22bc05465e9a98538b1b4c607498d3ffdc8747e396d86b071c887985ea7ceeb12171decf354981d809937a46ef86d2d8989482e9541362a19adbb794";

			HashMap<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("idCard", id);
			dataMap.put("activiId", card);

			String json = new Gson().toJson(dataMap);
			System.out.println("被加密 字符串：" + json);

			String data = Util4Hex.bytesToHexString(Sm2Util.encryptPublic(publicKey, json.getBytes("UTF-8")));
			//System.out.println("加密后的数据(16进制字符串)为：" + data);

			byte[] bytes = Sm2Util.decryptPrivate(privateKey, Util4Hex.hexStringToBytes(data));
			String s = new String(bytes, "UTF-8");
			//System.out.println("解密后 字符串："+s);

			return  data;
 		} catch (Exception e) {
			e.printStackTrace();
		}

		return  "";

	}
}
