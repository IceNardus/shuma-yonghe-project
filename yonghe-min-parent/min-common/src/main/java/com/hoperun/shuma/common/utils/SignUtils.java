/**
 * 
 */
package com.hoperun.shuma.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.net.URLEncoder;
import java.text.Collator;
import java.util.*;


@Slf4j
public class SignUtils {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',  
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};  
	
   
    
	/**
     * 对param进行机密(crm开放接口加密)
     * @param arr
     * @param parMap
     * @return
     */
    public static String  getCrmSign(Map<String, Object> map,String secret){
        String sign = "";//签名
        // 将参数进行字典序排序
//        JSONObject map = JSON.parseObject(JSON.toJSONString(parMap));
        List<String> parkeys =new ArrayList<>(map.keySet());
        
        Collections.sort(parkeys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Comparator<Object> com = Collator.getInstance(Locale.ENGLISH);
                return com.compare(o1, o2);
            }
        });
        
        //将参数转码UTF-8
        for(int i = 0;i<parkeys.size();i++){
            try {
                URLEncoder.encode(parkeys.get(i), "UTF-8");
                if(!map.get(parkeys.get(i)).equals("")){
                    sign += parkeys.get(i)+"="+map.get(parkeys.get(i))+"&";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String signs = sign+"secret="+secret;
        String md5 = MD5Util.getMd5(signs);
        return md5;
    }
	/**
     * 对param进行机密(crm开放接口加密)
     * @param arr
     * @param parMap
     * @return
     */
    public static String  getCrmSign(JSONObject map, String secret){
        String sign = "";//签名
        // 将参数进行字典序排序
        List<String> parkeys =new ArrayList<>(map.keySet());
        
        Collections.sort(parkeys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Comparator<Object> com = Collator.getInstance(Locale.ENGLISH);
                return com.compare(o1, o2);
            }
        });
        
        //将参数转码UTF-8
        for(int i = 0;i<parkeys.size();i++){
            try {
//                URLEncoder.encode(parkeys.get(i), "UTF-8");
                if(!map.get(parkeys.get(i)).equals("")){
                    sign += parkeys.get(i)+"="+map.get(parkeys.get(i))+"&";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String signs = sign+"secret="+secret;
		log.info("----signStringIS:"+signs);
        String md5 = MD5Util.getMd5(signs);
        return md5;
    }
    

	
	 public static String signUrl(String jsapi_ticket,String nonceStr,String timestamp, String url) {
			String string1;
			String signature = "";
			// 注意这里参数名必须全部小写，且必须有序
			string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr
					+ "&timestamp=" + timestamp + "&url=" + url;
			System.out.println(string1);
			try {
				signature = DigestUtils.sha1Hex(string1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return signature;
		}

	
	 public static String wxCardExt(String api_ticket, String timestamp,String nonce_str,String cardId,String code){
			String signature = "";
		       
			List<String> strList = new ArrayList<>();
			
	        strList.add(api_ticket);
	        strList.add(timestamp);
	        strList.add(cardId);
	        strList.add(nonce_str);
	        if(null!=code && !code.equals("")){
	        	 strList.add(code);
	        }
	       
	        Collections.sort(strList);
	        StringBuilder sb = new StringBuilder();
	        for (String str : strList) {
	            sb.append(str);
	        }
	        String sign = sb.toString();
	        signature = DigestUtils.sha1Hex(sign);

			Map<String,String> cardExtMap = new HashMap<>();
			cardExtMap.put("nonce_str", nonce_str);
			cardExtMap.put("timestamp", timestamp);
			cardExtMap.put("signature", signature);
			if(null != code && !code.equals("")){
				cardExtMap.put("code", code);
			}
			String cardExt = JSON.toJSONString(cardExtMap);
			return cardExt;
		}

	    private static String byteToHex(final byte[] hash) {
	        Formatter formatter = new Formatter();
	        for (byte b : hash)
	        {
	            formatter.format("%02x", b);
	        }
	        String result = formatter.toString();
	        formatter.close();
	        return result;
	    }
	    
	  //获取商户sign签名
		public static String getSign(HashMap<String,String> map,String mchKey){
			String sign="";
			String stringSignTemp="";
			Collection<String> keyset= map.keySet();   
			ArrayList list=new ArrayList<String>(keyset);  
			Collections.sort(list);  
			for(int i=0;i<list.size();i++){
				if(i!=0){
					stringSignTemp+="&";
				}
				stringSignTemp+=list.get(i)+"="+map.get(list.get(i));  
			}
			stringSignTemp+="&key="+mchKey;
			sign= MD5Util.getMd5(stringSignTemp).toUpperCase();
			
			String xml="<xml>";
			for(int i=0;i<list.size();i++){
				xml+="<"+list.get(i)+">"+map.get(list.get(i))+"</"+list.get(i)+">";  
			}
			
			xml+="<sign>"+sign+"</sign></xml>";
			return xml;
		}
}
