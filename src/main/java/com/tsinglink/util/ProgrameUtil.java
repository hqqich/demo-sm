package com.tsinglink.util;

import com.google.gson.Gson;
import java.util.HashMap;

/**
 * Created by ChenHao on 2023/5/25 is 15:24.
 *
 * @author tsinglink
 */

public class ProgrameUtil {

    public static String getString(String card, String id) {

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
