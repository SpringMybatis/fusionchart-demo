package com.ibs.fusionchart.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ChartServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,Object> jsonResult = new HashMap<String,Object>();
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		Map<String, Object> t = new HashMap<String, Object>();
		t.put("id", "坐标1");
		t.put("time1","2");
		t.put("time2","3");
		t.put("time3", "2");
		t.put("time4", "2");
		Map<String, Object> t2 = new HashMap<String, Object>();
		t2.put("id", "坐标2");
		t2.put("time1","5");
		t2.put("time2","6");
		t2.put("time3", "10");
		t2.put("time4", "1");
		Map<String, Object> t3 = new HashMap<String, Object>();
		t3.put("id", "坐标3");
		t3.put("time1","3");
		t3.put("time2","6");
		t3.put("time3","1");
		t3.put("time4", "5");
		Map<String, Object> t4 = new HashMap<String, Object>();
		t4.put("id", "坐标4");
		t4.put("time1","4");
		t4.put("time2","3");
		t4.put("time3","1");
		t4.put("time4", "8");
		dataList.add(t);
		dataList.add(t2);
		dataList.add(t3);
		dataList.add(t3);
		
		
		
		
		
		System.out.println("success");

		
	}
	
}
