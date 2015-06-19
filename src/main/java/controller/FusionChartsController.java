package controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GraphLineDataSet;
import model.GraphLineSettings;
import model.GraphsLine;

public class FusionChartsController {

	public void lineListTest(Integer graphType,HttpServletRequest request,HttpServletResponse response){
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
		GraphsLine g = null;
		switch(graphType){
		case 1 : 
			g = getGraphLineList("Column 2D Chart", "图表呈现", "Times", dataList);
			break;
		case 2 :
			g = getGraphLineList("Column 3D Chart", "图表呈现", "Times", dataList);
			break;
		case 3 : 
			g = getGraphLineList("Line 2D Chart", "图表呈现", "Times", dataList);
			break;
		case 4 :
			g = getGraphLineList("Pie 3D Chart", "图表呈现", "Times", dataList);
			break;
		case 5 :
			g = getGraphLineList("Pie 2D Chart", "图表呈现", "Times", dataList);
			break;
		case 6 :
			g = getGraphLineList("Bar 2D Chart", "图表呈现", "Times", dataList);
			break;
		case 7 :
			g = getGraphLineList("Area 2D Chart", "图表呈现", "Times", dataList);
			break;
		case 8 :
			g = getGraphLineList("Doughnut 2D Chart", "图表呈现", "Times", dataList);
			break;
		case 9 :
			g = getGraphLinesList("Multi-series Column 3D Chart",  dataList);
			break;
		case 10 :
			g = getGraphLinesList("Multi-series Column 2D Chart",   dataList);
			break;
		case 11 : 
			g = getGraphLinesList("Multi-series Area 2D Chart",    dataList);
			break;
		case 12 :
			g = getGraphLinesList("Multi-series line 2D Chart",    dataList);
			break;
		case 13 : 
			g = getGraphLinesList("Multi-series Bar 2D Chart",    dataList);
			break;
		case 14 :
			g = getGraphLinesList("Stacked Column 2D Chart", dataList);
			break;
		case 15 :
			g = getGraphLinesList("Stacked Column 3D Chart",  dataList);
			break;
		case 16 :
			g = getGraphLinesList("Stacked Bar 2D Chart",  dataList);
			break;
		case 17 :
			g = getGraphLinesList("Stacked Area 2D Chart",  dataList);
			break;
		case 18 :
			g = getGraphColLinesList("Column 3D+Line Dual Y Chart",  dataList);
			break;
		case 19 :
			g = getGraphColLinesList("Column 2D+Line Dual Y Chart",  dataList);
			break;
		case 20 :
			g = getGraphLineList("Funnel Chart", "图表呈现", "Times", dataList);
			break;
			
		
			
		}
		 jsonResult.put("actionStatus", "SUCCESS");
		 jsonResult.put("list", dataList);
		 jsonResult.put("graph", g);
		 jsonResult.put("graphType", graphType);
		 String json = "";
		 System.out.println(json);
		try {
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 单线  图表呈现
	 * @param dataList 
	 * @return
	 */
	private GraphsLine getGraphLineList(String caption ,String xAxisName ,String yAxisName,
			List<Map<String, Object>> dataList){
		GraphLineSettings graphLineSettings = new GraphLineSettings();
		graphLineSettings.setCaption(caption);
		graphLineSettings.setyAxisName(yAxisName);//纵坐标标题
		graphLineSettings.setxAxisName(xAxisName);//横坐标标题	
		List<GraphLineDataSet> dataset = new ArrayList<GraphLineDataSet>();
		
		int maxTime =0;
		for(Map<String, ?> map : dataList){
			String name = (String)map.get("id");
			int value = Integer.parseInt((String)map.get("time1"));
			if(value>maxTime){
				maxTime=value;
			}
			dataset.add(new GraphLineDataSet(name,value+"",""));
		}
		if(maxTime<5){
			graphLineSettings.setyAxisMaxValue("5");
			graphLineSettings.setyAxisValuesStep("1");
		}

		return new  GraphsLine(graphLineSettings,dataset);
	}
	
	
	/**
	 * 多线  图表呈现
	 * @param dataList 
	 * @return
	 */
	private GraphsLine getGraphColLinesList(String caption,List<Map<String, Object>> dataList){
		GraphLineSettings graphSetings = new GraphLineSettings();
		graphSetings.setCaption(caption);
		/*graphSetings.setPYAxisName("time1");
		graphSetings.setSYAxisName("time2");*/
		graphSetings.setxAxisName("id");
		//柱子1数据
		List<Map<String, Object>> timesData1 = new ArrayList<Map<String, Object>>();
		//柱子1数据
		List<Map<String, Object>> timesData2 = new ArrayList<Map<String, Object>>();
		//线1数据
		List<Map<String, Object>> rateData1 = new ArrayList<Map<String, Object>>();
		//线1数据
		List<Map<String, Object>> rateData2 = new ArrayList<Map<String, Object>>();
		//横坐标值
		List<Map<String, Object>> pNames =  new ArrayList<Map<String, Object>>();	
		for (Map<String, ?> map : dataList) {
			NumberFormat nf = NumberFormat.getNumberInstance();
	        nf.setMaximumFractionDigits(4);    
	        Map<String,Object> t0 = new HashMap<String,Object>();
	        Object o =  (String)map.get("id");
	        t0.put("name",o);
	        
	        pNames.add(t0);
			Map<String,Object> t1 = new HashMap<String,Object>();
			Object o1 = map.get("time1");
			t1.put("value", o1!=null&&o1!=""?o1:0);
			timesData1.add(t1);
			
			Map<String,Object> t2 = new HashMap<String,Object>();
			Object o2 = map.get("time2");
			t2.put("value", o2!=null&&o1!=""?o2:0);
			timesData2.add(t2);
		
			Map<String,Object> t3 = new HashMap<String,Object>();
			Object o3 = map.get("time3");
			//Double.parseDouble(nf.format(new Double(o3.toString())))*100:0
			t3.put("value", o3!=null&&o3!=""?o3:0);
			rateData1.add(t3);
			
			Map<String,Object> t4 = new HashMap<String,Object>();
			Object o4 = map.get("time4");
			//Double.parseDouble(nf.format(new Double(o3.toString())))*100:0
			t4.put("value", o4!=null&&o4!=""?o4:0);
			rateData2.add(t4);
			
		}
		List<GraphLineDataSet> dataset = new ArrayList<GraphLineDataSet>();
		dataset.add(new GraphLineDataSet("0", "F9CC74", "time1", timesData1, "P", ""));
		dataset.add(new GraphLineDataSet("0", "AFD7BB", "time2", timesData2, "P", ""));
		dataset.add(new GraphLineDataSet("1", "C9B5D4", "time3", rateData1, "S", "%25"));
		dataset.add(new GraphLineDataSet("1", "99D1D1", "time4", rateData2, "S", "%25"));
		Map<String, List<Map<String, Object>>> category = new HashMap<String, List<Map<String, Object>>>();
		category.put("category", pNames);
		List<Map<String, List<Map<String, Object>>>> categories = new ArrayList<Map<String, List<Map<String, Object>>>>();
		categories.add(category);
		return new GraphsLine(graphSetings, categories, dataset);
	}
	
	/**
	 * 多线  图表呈现
	 * @param dataList 
	 * @return
	 */
	private GraphsLine getGraphLinesList(String caption,List<Map<String, Object>> dataList){
		
		GraphLineSettings graphSetings = new GraphLineSettings();
		graphSetings.setCaption(caption);
		//线1数据
		List<Map<String, Object>> timesData1 = new ArrayList<Map<String, Object>>();;
		//线2数据
		List<Map<String, Object>> timesData2 = new ArrayList<Map<String, Object>>();
		//线3数据
		List<Map<String, Object>> timesData3 = new ArrayList<Map<String, Object>>();;
		//线4数据
		List<Map<String, Object>> timesData4 = new ArrayList<Map<String, Object>>();
		//横坐标值
		List<Map<String, Object>> pNames =  new ArrayList<Map<String, Object>>();	
		for (Map<String, ?> map : dataList) {
			NumberFormat nf = NumberFormat.getNumberInstance();
	        nf.setMaximumFractionDigits(4);    
	        Map<String,Object> t0 = new HashMap<String,Object>();
	        Object o =  (String)map.get("id");
	        t0.put("name",o);
	        
	        pNames.add(t0);
	        
			Map<String,Object> t1 = new HashMap<String,Object>();
			Object o1 = map.get("time1");
			t1.put("value", o1!=null&&o1!=""?o1:0);
			timesData1.add(t1);
		
			Map<String,Object> t2 = new HashMap<String,Object>();
			Object o2 = map.get("time2");
			//Double.parseDouble(nf.format(new Double(o3.toString())))*100:0
			t2.put("value", o2!=null&&o2!=""?o2:0);
			timesData2.add(t2);
		
			Map<String,Object> t3 = new HashMap<String,Object>();
			Object o3 = map.get("time3");
			//Double.parseDouble(nf.format(new Double(o3.toString())))*100:0
			t3.put("value", o3!=null&&o3!=""?o3:0);
			timesData3.add(t3);
			
			Map<String,Object> t4 = new HashMap<String,Object>();
			Object o4 = map.get("time4");
			t4.put("value", o4!=null&&o4!=""?o4:0);
			timesData4.add(t4);
			
		}
		List<GraphLineDataSet> dataset = new ArrayList<GraphLineDataSet>();
		dataset.add(new GraphLineDataSet("1", "FCF54C", "times1", timesData1,"",""));
		dataset.add(new GraphLineDataSet("1", "AF4A92", "times2", timesData2,"",""));
		dataset.add(new GraphLineDataSet("1", "8273B0", "times3", timesData3,"",""));
		dataset.add(new GraphLineDataSet("1", "EE8000", "times4", timesData4,"",""));
		Map<String, List<Map<String, Object>>> category = new HashMap<String, List<Map<String, Object>>>();
		category.put("category", pNames);
		List<Map<String, List<Map<String, Object>>>> categories = new ArrayList<Map<String, List<Map<String, Object>>>>();
		categories.add(category);
		return new GraphsLine(graphSetings, categories, dataset);
	}
	
}
