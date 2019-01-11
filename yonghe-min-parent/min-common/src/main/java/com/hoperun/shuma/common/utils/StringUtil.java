package com.hoperun.shuma.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.*;

public class StringUtil {

	/**
	 * <li>判断字符串是否为空值</li>
	 * <li>NULL、空格均认为空值</li>.
	 * 
	 * @param value
	 *            the value
	 * 
	 * @return true, if checks if is empty
	 */
	public static boolean isEmpty(String value) {
		return null == value || "".equals(value.trim());
	}

	/**
	 * <li>判断字符串是不为空值</li>
	 * <li>NULL、空格均认为空值</li>.
	 * 
	 * @param value
	 *            the value
	 * 
	 * @return true, if checks if is empty
	 */
	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}

	/**
	 * 重复字符串 如 repeatString("a",3) ==> "aaa".
	 * 
	 * @param src
	 *            the src
	 * @param repeats
	 *            the repeats
	 * 
	 * @return the string
	 * 
	 * @author uke
	 */
	public static String repeatString(String src, int repeats) {
		if (null == src || repeats <= 0) {
			return src;
		} else {
			StringBuffer bf = new StringBuffer();
			for (int i = 0; i < repeats; i++) {
				bf.append(src);
			}
			return bf.toString();
		}
	}

	/**
	 * 左对齐字符串 * lpadString("X",3); ==>" X" *.
	 * 
	 * @param src
	 *            the src
	 * @param length
	 *            the length
	 * 
	 * @return the string
	 */
	public static String lpadString(String src, int length) {
		return lpadString(src, length, " ");
	}

	/**
	 * 以指定字符串填补空位，左对齐字符串 * lpadString("X",3,"0"); ==>"00X".
	 * 
	 * @param src
	 *            the src
	 * @param length
	 *            the length
	 * @param single
	 *            the single
	 * 
	 * @return the string
	 */
	public static String lpadString(String src, int length, String single) {
		if (src == null || length <= src.getBytes().length) {
			return src;
		} else {
			return repeatString(single, length - src.getBytes().length) + src;
		}
	}

	/**
	 * 右对齐字符串 * rpadString("9",3)==>"9 ".
	 * 
	 * @param src
	 *            the src
	 * @param byteLength
	 *            the byte length
	 * 
	 * @return the string
	 */
	public static String rpadString(String src, int byteLength) {
		return rpadString(src, byteLength, " ");
	}

	/**
	 * 以指定字符串填补空位，右对齐字符串 rpadString("9",3,"0")==>"900".
	 * 
	 * @param src
	 *            the src
	 * @param single
	 *            the single
	 * @param length
	 *            the length
	 * 
	 * @return the string
	 */
	public static String rpadString(String src, int length, String single) {
		if (src == null || length <= src.getBytes().length) {
			return src;
		} else {
			return src + repeatString(single, length - src.getBytes().length);
		}
	}

	/**
	 * 去除,分隔符，用于金额数值去格式化.
	 * 
	 * @param value
	 *            the value
	 * 
	 * @return the string
	 */
	public static String decimal(String value) {
		if (null == value || "".equals(value.trim())) {
			return "0";
		} else {
			return value.replaceAll(",", "");
		}
	}

	/**
	 * 在数组中查找字符串.
	 * 
	 * @param params
	 *            the params
	 * @param name
	 *            the name
	 * @param ignoreCase
	 *            the ignore case
	 * 
	 * @return the int
	 */
	public static int indexOf(String[] params, String name, boolean ignoreCase) {
		if (params == null)
			return -1;
		for (int i = 0, j = params.length; i < j; i++) {
			if (ignoreCase && params[i].equalsIgnoreCase(name)) {
				return i;
			} else if (params[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 将字符转数组.
	 * 
	 * @param str
	 *            the str
	 * 
	 * @return the string[]
	 */
	public static String[] toArr(String str) {
		String inStr = str;
		String a[] = null;
		try {
			if (null != inStr) {
				StringTokenizer st = new StringTokenizer(inStr, ",");
				if (st.countTokens() > 0) {
					a = new String[st.countTokens()];
					int i = 0;
					while (st.hasMoreTokens()) {
						a[i++] = st.nextToken();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * 将字符转数组.
	 * 
	 * @param str
	 *            the str
	 * @param splitChar
	 *            the split char
	 * 
	 * @return the string[]
	 */
	public static String[] toArr(String str, String splitChar) {
		String inStr = str;
		String a[] = null;
		try {
			if (null != inStr) {
				StringTokenizer st = new StringTokenizer(inStr, splitChar);
				if (st.countTokens() > 0) {
					a = new String[st.countTokens()];
					int i = 0;
					while (st.hasMoreTokens()) {
						a[i++] = st.nextToken();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * 字符串数组包装成字符串.
	 * 
	 * @param ary
	 *            the ary
	 * @param s
	 *            包装符号如 ' 或 "
	 * 
	 * @return the string
	 */
	public static String toStr(String[] ary, String s) {
		if (ary == null || ary.length < 1)
			return "";
		StringBuffer bf = new StringBuffer();
		bf.append(s);
		bf.append(ary[0]);
		for (int i = 1; i < ary.length; i++) {
			bf.append(s).append(",").append(s);
			bf.append(ary[i]);
		}
		bf.append(s);
		return bf.toString();
	}

	/**
	 * 設置MESSAGE中的變量{0}...{N}
	 * 
	 * @param msg
	 *            the msg
	 * @param vars
	 *            the vars
	 * 
	 * @return the message
	 */
	public static String getMessage(String msg, String[] vars) {
		for (int i = 0; i < vars.length; i++) {
			msg = msg.replaceAll("\\{" + i + "\\}", vars[i]);
		}
		return msg;
	}

	/**
	 * Gets the message.
	 * 
	 * @param msg
	 *            the msg
	 * @param var
	 *            the var
	 * 
	 * @return the message
	 */
	public static String getMessage(String msg, String var) {
		return getMessage(msg, new String[] { var });
	}

	/**
	 * Gets the message.
	 * 
	 * @param msg
	 *            the msg
	 * @param var
	 *            the var
	 * @param var2
	 *            the var2
	 * 
	 * @return the message
	 */
	public static String getMessage(String msg, String var, String var2) {
		return getMessage(msg, new String[] { var, var2 });
	}

	/**
	 * 从Map中取String类型值.
	 * 
	 * @param map
	 *            the map
	 * @param key
	 *            the key
	 * 
	 * @return the map value
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Object getMapValue(Map map, Object key) {
		if (null == map || null == key)
			return "";
		Object value = map.get(key);
		return null == value ? "" : value;
	}

	/**
	 * 从Map中取Integer类型值.
	 * 
	 * @param map
	 *            the map
	 * @param key
	 *            the key
	 * 
	 * @return the map int value
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Object getMapIntValue(Map map, Object key) {
		if (null == map || null == key)
			return new Integer(0);
		Object value = map.get(key);
		return null == value ? new Integer(0) : value;
	}

	/**
	 * 將key=value;key2=value2……轉換成Map.
	 * 
	 * @param params
	 *            the params
	 * 
	 * @return the map
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map gerneryParams(String params) {
		Map args = new HashMap();
		if (!isEmpty(params)) {
			try {
				String map, key, value;
				StringTokenizer st = new StringTokenizer(params, ";");
				StringTokenizer stMap;
				while (st.hasMoreTokens()) {
					map = st.nextToken();
					if (isEmpty(map.trim()))
						break;
					stMap = new StringTokenizer(map, "=");
					key = stMap.hasMoreTokens() ? stMap.nextToken() : "";
					if (isEmpty(key.trim()))
						continue;
					value = stMap.hasMoreTokens() ? stMap.nextToken() : "";
					args.put(key, value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return args;
	}

	/**
	 * 获取主键.
	 * 
	 * @return the string
	 */
	public static String uuid32len() {
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 获取主键.
	 * 
	 * @return the string
	 */
	public static String uuid36len() {
		return java.util.UUID.randomUUID().toString();
	}

	/**
	 * 将字符数值取scale为小数.
	 * 
	 * @param v
	 *            the v
	 * @param scale
	 *            the scale
	 * 
	 * @return the string
	 */
	public static String round(String v, int scale) {
		if ((v == null) || (v.equals("")))
			return "";
		try {
			BigDecimal b = new BigDecimal(v);
			BigDecimal one = new BigDecimal("1");
			return b.divide(one, scale, 4).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 将字符数值取scale为小数.
	 * 
	 * @param value
	 *            the value
	 * @param XT
	 *            the xT
	 * @param SJLX
	 *            the sJLX
	 * 
	 * @return the value
	 */
	public static String getValue(String value, String XT, String SJLX) {
		try {
			if (value == null) {
				return "";
			}
			return StringUtil.round(value, 2);
		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * Tran code p.
	 * 
	 * @param value
	 *            the value
	 * 
	 * @return the string
	 */
	public static String tranCodeP(String value) {
		String tempStr = "";
		if (value != null) {
			if (System.getProperties().toString().indexOf("tomcat") != -1) {
				try {
					// tempStr = new String(value.getBytes("iso-8859-1"),
					// "GBK");
					tempStr = (null == value ? "" : value);
				} catch (Exception ex)// UnsupportedEncodingException ex
				{
				}
			} else {
				tempStr = value;
			}
		}
		return tempStr.trim();
	}

	/**
	 * 字符串替换.
	 * 
	 * @param strSource
	 *            the str source
	 * @param oldStr
	 *            the old str
	 * @param newStr
	 *            the new str
	 * 
	 * @return the string
	 */
	public static String replace(String strSource, String oldStr, String newStr) {
		// String strDest = "";
		int intFromLen = oldStr.length();
		int intPos;
		StringBuffer strDest = new StringBuffer();
		while ((intPos = strSource.indexOf(oldStr)) != -1) {
			strDest.append(strSource.substring(0, intPos));
			strDest.append(newStr);
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest.append(strSource);
		return strDest.toString();
	}

	public static String trim(String obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.trim();
		}
	}

	/**
	 * utf8转码 Description :.
	 * 
	 * @param str
	 *            the str
	 * 
	 * @return the string
	 */
	public static String utf8Decoder(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 将空串转换成空字符串.
	 * 
	 * @param obj
	 *            the obj
	 * 
	 * @return the string
	 */
	public static String nullToSring(Object obj) {
		if (null == obj || "".equals(obj) || "null".equals(obj)) {
			return "";
		}
		return String.valueOf(obj);
	}

	public static String filterString(String str) {
		// for example
		String[] fileStr = { "'", "$", "=", "select" };
		String[] replaceStr = { "", "", "", "" };
		int len = fileStr.length;
		for (int i = 0; i < len; i++) {
			str = str.replaceAll(fileStr[i], replaceStr[i]);
		}
		return str;
	}

	public static String encoding(String s) throws Exception {
		s = new String(s.getBytes("iso-8859-1"), "utf-8");
		return s;
	}

	/**
	 * 获取本机IP
	 * 
	 * @author feng_wei
	 * @return
	 */
	public static String getLocalIp() {
		Enumeration<NetworkInterface> netInterfaces = null;
		try {
			netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					InetAddress ip = ips.nextElement();
					if (ip.isSiteLocalAddress()) {
						return ip.getHostAddress();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取本机HostName
	 * 
	 * @author feng_wei
	 * @return
	 */
	public static String getLocalHostName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (Exception e) {
			if (e instanceof UnknownHostException) {
				return e.getMessage().split("\\:")[0];
			}
			e.printStackTrace();
		}
		return null;
	}

	private static final char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	/**
	 * 将10进制转化为62进制
	 * 
	 * @param number
	 * @param length
	 *            转化成的62进制长度，不足length长度的话高位补0，否则不改变什么
	 * @return
	 */
	public static String convertLongToBase36(long number) {
		int length = 3;
		Long rest = number;
		Stack<Character> stack = new Stack<Character>();
		StringBuilder result = new StringBuilder(0);
		while (rest != 0) {
			stack.add(charSet[new Long((rest - (rest / 36) * 36)).intValue()]);
			rest = rest / 36;
		}
		for (; !stack.isEmpty();) {
			result.append(stack.pop());
		}
		int result_length = result.length();
		StringBuilder temp0 = new StringBuilder();
		for (int i = 0; i < length - result_length; i++) {
			temp0.append('0');
		}

		return temp0.toString() + result.toString().toUpperCase();

	}

	/**
	 * 将62进制转换成10进制数
	 * 
	 * @param ident62
	 * @return
	 */
	public static String convertBase36ToDecimal(String ident62) {
		int decimal = 0;
		int base = 36;
		int keisu = 0;
		int cnt = 0;

		byte ident[] = ident62.getBytes();
		for (int i = ident.length - 1; i >= 0; i--) {
			int num = 0;
			if (ident[i] > 48 && ident[i] <= 57) {
				num = ident[i] - 48;
			} else if (ident[i] >= 65 && ident[i] <= 90) {
				num = ident[i] - 65 + 10;
			} else if (ident[i] >= 97 && ident[i] <= 122) {
				num = ident[i] - 97 + 10;
			}
			keisu = (int) java.lang.Math.pow((double) base, (double) cnt);
			decimal += num * keisu;
			cnt++;
		}
		return String.format("%d", decimal);
	}

	public static String uuid() {
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 18);
		return uuid;

	}

}

class EscapeEntity {
	private String key;
	private String val;

	public EscapeEntity(String key, String val) {
		super();
		this.key = key;
		this.val = val;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}
