package com.tgb.util;

public class StringUtils {
	public static int toInt(String str, int defValue) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
		}
		return defValue;
	}

	public static boolean isEmpty(String input) {
		if (input == null || "".equals(input) || "null".equals(input) || "[]".equals(input) || "{}".equals(input) || "NULL".equals(input))
			return true;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
				return false;
			}
		}
		return true;
	}

	
	
	
    public static boolean isEquals(String s1, String s2) {
        if (null == s1 && null == s2) {
            return true;
        }
        if (null != s1 && null != s2) {
            if (s1.trim().equals(s2.trim())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //前一个String是否包括后一个
    public static boolean isContains(String s1, String s2) {
        if (null == s1 && null == s2) {
            return true;
        }
        if (null != s1 && null != s2) {
            if (s1.trim().contains(s2.trim())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
	
	
}
