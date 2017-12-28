package com.tgb.test;

import java.util.ArrayList;
import java.util.List;

import com.tgb.util.PinyinUtils;

public class TestClass {

	public static void main(String[] args) {
		System.out.println(12 & 5);
		System.out.println(12 == 12 & 5 == 5);
		System.out.println(12 == 12 && 5 == 5);

		int count;
		System.out.println(count = +5);

		System.out.println(count += 5);

		Info<Number> mui = new Info<Number>();
		mui.setData(1);
		Integer intNum = (Integer) mui.getData();
		System.out.println(intNum);
		
		
		
		getData(TYPE.red);

		System.out.println(PinyinUtils.ccs2Pinyin("Ww").toUpperCase());
		System.out.println(PinyinUtils.getPinyinFirstLetters("我是谁"));

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		String[] strArray = "".split(",");
		System.out.println(strArray.length);

	}

	public enum TYPE {
		red, RED, green, yellow, blue;
	}

	public static void getData(TYPE type) {

	}

}
