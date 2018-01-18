package com.tgb.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tgb.model.P2pInfo;
import com.tgb.model.User;
import com.tgb.service.P2pService;
import com.tgb.util.StringUtils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import net.sf.json.JSON;

@Controller
public class P2pControler {

	@Autowired
	private P2pService p2pService;

	/**
	 * 第一次从excel中初始化平台数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "app/p2p/init", method = RequestMethod.GET)
	@ResponseBody
	public void getInitData(HttpServletRequest request, HttpServletResponse response) {
		jxl.Workbook readwb = null;
		try {
			// 构建Workbook对象, 只读Workbook对象

			// 直接从本地文件创建Workbook
			InputStream instream = new FileInputStream("F:/理财排行.xls");
			readwb = Workbook.getWorkbook(instream);

			// Sheet的下标是从0开始
			// 获取第一张Sheet表

			Sheet readsheet = readwb.getSheet(0);

			// 获取Sheet表中所包含的总列数
			int rsColumns = readsheet.getColumns();

			// 获取Sheet表中所包含的总行数
			int rsRows = readsheet.getRows();

			// 获取指定单元格的对象引用
			for (int i = 0; i < rsRows; i++) {
				/*
				 * for (int j = 0; j < rsColumns; j++)
				 * 
				 * { Cell cell = readsheet.getCell(j, i);
				 * System.out.print(cell.getContents() + " "); }
				 */

				Cell cell = readsheet.getCell(0, i);
				if (cell != null && cell.getContents() != null && cell.getContents().length() > 0) {
					System.out.println(cell.getContents());
					P2pInfo mP2pInfo = new P2pInfo();
					mP2pInfo.setName(cell.getContents().trim());
					p2pService.save_init(mP2pInfo);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			readwb.close();
		}
	}

	/**
	 * 获取所有列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("app/getList")
	public void getList(HttpServletRequest request, HttpServletResponse response) {
		List<P2pInfo> findAll = p2pService.findAll();
		try {
			// 正常接口返回
			JSONArray jsonArray = JSONArray.fromObject(findAll);

			// jsonp格式返回
			String renderStr = "jsonpCallback" + "(" + jsonArray.toString() + ")";
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().write(renderStr);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("app/getOne")
	public void getOne(HttpServletRequest request, HttpServletResponse response) {
		List<P2pInfo> findAll = p2pService.findAll();
		try {
			// 正常接口返回
			JSONObject mJSONObject = new JSONObject();
			for (P2pInfo mP2pInfo : findAll) {
				mJSONObject.put("key", mP2pInfo);
			}
			response.setContentType("application/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(mJSONObject.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**添加平台
	 * @param request
	 * @param response
	 */
	@RequestMapping("app/addPlat")
	public void addPlat(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String score = request.getParameter("score");
		int code = 200;

		P2pInfo mP2pInfo = new P2pInfo();
		mP2pInfo.setName(name);
		if (!StringUtils.isEmpty(score)) {
			mP2pInfo.setScore(StringUtils.toInt(score, 0));
		} else {
			mP2pInfo.setScore(0);
		}
		List<P2pInfo> findAll = p2pService.findAll();
		boolean isExtie = false;
		for (P2pInfo mP2pInfo1 : findAll) {
			if (StringUtils.isContains(mP2pInfo1.getName(), name)) {
				isExtie = true;
			}
			if (StringUtils.isContains(mP2pInfo1.getOther_name(), name)) {
				isExtie = true;
			}
		}
		if (!isExtie)
			p2pService.save_init(mP2pInfo);
		else
			code = 100;
		try {
			// 正常接口返回
			JSONObject mJSONObject = new JSONObject();
			mJSONObject.put("code", code);

			// jsonp格式返回
			String renderStr = "jsonpCallback" + "(" + mJSONObject.toString() + ")";
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().write(renderStr);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("app/delPlat")
	public void delPlat(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		int code = 200;
		p2pService.delById(id);
		try {
			// 正常接口返回
			JSONObject mJSONObject = new JSONObject();
			mJSONObject.put("code", code);
			
			// jsonp格式返回
			String renderStr = "jsonpCallback" + "(" + mJSONObject.toString() + ")";
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().write(renderStr);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("app/updateScore")
	public void updateScore(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		int score = Integer.parseInt(request.getParameter("score"));
		int code = 200;
		P2pInfo mP2pInfo = new P2pInfo();
		mP2pInfo.setId(id);
		mP2pInfo.setScore(score);
		p2pService.updateScore(mP2pInfo);
		try {
			// 正常接口返回
			JSONObject mJSONObject = new JSONObject();
			mJSONObject.put("code", code);
			
			// jsonp格式返回
			String renderStr = "jsonpCallback" + "(" + mJSONObject.toString() + ")";
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().write(renderStr);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
