package com.tgb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;

/**
 * @author Administrator 统计一列中名字出现的次数数量并排序
 */
public class ExcelMain1 {

	public static void main(String[] args) {

		jxl.Workbook readwb = null;

		try

		{

			// 构建Workbook对象, 只读Workbook对象

			// 直接从本地文件创建Workbook

			InputStream instream = new FileInputStream("F:/记账.xls");

			readwb = Workbook.getWorkbook(instream);

			// Sheet的下标是从0开始

			// 获取第一张Sheet表

			Sheet readsheet = readwb.getSheet(0);

			// 获取Sheet表中所包含的总列数

			int rsColumns = readsheet.getColumns();

			// 获取Sheet表中所包含的总行数

			int rsRows = readsheet.getRows();

			// 获取指定单元格的对象引用
			Map<String, Long> map = new HashMap<>();
			for (int i = 0; i < rsRows; i++)

			{

				/*
				 * for (int j = 0; j < rsColumns; j++)
				 * 
				 * { Cell cell = readsheet.getCell(j, i);
				 * System.out.print(cell.getContents() + " "); }
				 */

				Cell cell2 = readsheet.getCell(2, i);
				// System.out.println(cell2.getContents());

				if (map.get(cell2.getContents().trim()) == null) {
					map.put(cell2.getContents().trim(), 1L);
				} else {
					Long value = map.get(cell2.getContents().trim());
					map.put(cell2.getContents().trim(), value + 1);
				}

			}

			// 这里将map.entrySet()转换成list
			List<Map.Entry<String, Long>> list = new ArrayList<Map.Entry<String, Long>>(map.entrySet());
			// 然后通过比较器来实现排序
			Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
				// 升序排序
				public int compare(Entry<String, Long> o1, Entry<String, Long> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}

			});

			Long totle = 0L;

			for (Map.Entry<String, Long> mapping : list) {
				System.out.println(mapping.getKey() + ":" + mapping.getValue());
				totle = totle + mapping.getValue();
			}
			System.out.println( "总数:" + totle);
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			readwb.close();

		}

	}

}
