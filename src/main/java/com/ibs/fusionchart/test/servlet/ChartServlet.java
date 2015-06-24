package com.ibs.fusionchart.test.servlet;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GraphLineDataSet;

import com.google.gson.Gson;
import com.ibs.fusionchart.test.model.Graphs;
import com.ibs.fusionchart.test.model.GraphsConfiguration;
import com.ibs.fusionchart.test.model.GraphsDataSet;

@SuppressWarnings("serial")
public class ChartServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> t1 = new HashMap<String, Object>();
		t1.put("id", "坐标1");
		t1.put("time1", "2");
		t1.put("time2", "3");
		t1.put("time3", "2");
		t1.put("time4", "2");
		Map<String, Object> t2 = new HashMap<String, Object>();
		t2.put("id", "坐标2");
		t2.put("time1", "5");
		t2.put("time2", "6");
		t2.put("time3", "10");
		t2.put("time4", "1");
		Map<String, Object> t3 = new HashMap<String, Object>();
		t3.put("id", "坐标3");
		t3.put("time1", "3");
		t3.put("time2", "6");
		t3.put("time3", "1");
		t3.put("time4", "5");
		Map<String, Object> t4 = new HashMap<String, Object>();
		t4.put("id", "坐标4");
		t4.put("time1", "4");
		t4.put("time2", "3");
		t4.put("time3", "1");
		t4.put("time4", "8");
		dataList.add(t1);
		dataList.add(t2);
		dataList.add(t3);
		dataList.add(t4);
		Graphs g = null;
		Integer graphType = Integer.valueOf(request.getParameter("graphType"));
		switch (graphType) {
		case 1:
			g = getGraphs("Column 2D Chart", "图表呈现", "Times", dataList);
			break;
		case 2:
			g = getGraphs("Column 3D Chart", "图表呈现", "Times", dataList);
			break;
		case 3:
			g = getGraphs("Line 2D Chart", "图表呈现", "Times", dataList);
			break;
		case 4:
			g = getGraphs("Pie 3D Chart", "图表呈现", "Times", dataList);
			break;
		case 5:
			g = getGraphs("Pie 2D Chart", "图表呈现", "Times", dataList);
			break;
		case 18 :
			g = getMultiGraphs("Column 3D+Line Dual Y Chart",  dataList);
		}
		jsonResult.put("actionStatus", "SUCCESS");
		jsonResult.put("list", dataList);
		jsonResult.put("graph", g);
		jsonResult.put("graphType", graphType);
		Gson gson = new Gson();
		String json = gson.toJson(jsonResult);
		System.out.println(json);
		response.getWriter().write(json);
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * 多线图Demo
	 * 
	 * 
	 * @param string
	 * @param dataList
	 * @return
	 */
	private Graphs getMultiGraphs(String caption,List<Map<String, Object>> dataList) {
		GraphsConfiguration graphSetings = new GraphsConfiguration();
		graphSetings.setCaption(caption);
		// x轴名字
		graphSetings.setxAxisName("id");
		// color
		String color[] = new String[] { "F9CC74", "AFD7BB", "C9B5D4", "99D1D1" };
		// 柱子、线数据
		String data[] = new String[] { "time1", "time2", "time3", "time4" };
		List<List<Map<String, Object>>> list = new ArrayList<List<Map<String,Object>>>();
		for (int i = 0; i < data.length; i++) {
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			list.add(mapList);
		}
		//横坐标值
		List<Map<String, Object>> pNames =  new ArrayList<Map<String, Object>>();
		for (Map<String, ?> map : dataList) {
			NumberFormat nf = NumberFormat.getNumberInstance();
	        nf.setMaximumFractionDigits(4);    
	        Map<String,Object> t0 = new HashMap<String,Object>();
	        Object o =  (String)map.get("id");
	        t0.put("name",o);
	        pNames.add(t0);
	        
	        for(int j = 0;j<data.length;j++){
				Map<String,Object> t1 = new HashMap<String,Object>();
				Object o1 = map.get(data[j]);
				t1.put("value", o1!=null&&o1!=""?o1:0);
				list.get(j).add(t1);
			}
		}
		List<GraphLineDataSet> dataset = new ArrayList<GraphLineDataSet>();
		for(int k=0;k<data.length;k++){
			if("times1".equals(data[k]) || "times2".equals(data[k])){
				dataset.add(new GraphLineDataSet("0", color[k], data[k], list.get(k), "P", ""));
			}else{
				dataset.add(new GraphLineDataSet("1", color[k], data[k], list.get(k), "S", "%25"));
			}
		}
		Map<String, List<Map<String, Object>>> category = new HashMap<String, List<Map<String, Object>>>();
		category.put("category", pNames);
		List<Map<String, List<Map<String, Object>>>> categories = new ArrayList<Map<String, List<Map<String, Object>>>>();
		categories.add(category);
		Graphs multiGraphs = new Graphs(graphSetings, categories, dataset);
		return multiGraphs;
	}

	/**
	 * 单线图表呈现
	 * 
	 * @param caption
	 * @param xAxisName
	 * @param yAxisName
	 * @param dataList
	 * @return
	 */
	public Graphs getGraphs(String caption, String xAxisName, String yAxisName,
			List<Map<String, Object>> dataList) {
		GraphsConfiguration configuration = new GraphsConfiguration();
		configuration.setCaption(caption);// 标题
		configuration.setyAxisName(yAxisName);// 纵坐标标题
		configuration.setxAxisName(xAxisName);// 横坐标标题
		List<GraphsDataSet> dataset = new ArrayList<GraphsDataSet>();
		int maxTime = 0;
		for (Map<String, ?> map : dataList) {
			String name = (String) map.get("id");
			int value = Integer.parseInt((String) map.get("time1"));
			if (value > maxTime) {
				maxTime = value;
			}
			dataset.add(new GraphsDataSet(name, value + "", ""));
		}
		if (maxTime < 5) {
			configuration.setyAxisMaxValue("5");
			configuration.setyAxisValuesStep("1");
		}
		Graphs graphs = new Graphs(configuration, dataset);
		return graphs;
	}
}
