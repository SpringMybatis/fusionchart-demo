<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3D柱状图</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/extjs/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/extjs/bootstrap.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/extjs/ext-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/fusioncharts/FusionCharts.js"></script>
<script type="text/javascript">
	function showChart() {
		var paramsObj = {};
		paramsObj.chartFlag = true;
		paramsObj.graphType = "18";
		Ext.Ajax.request({
			url : "../chartDemo.do",
			params : paramsObj,
			method : 'POST',
			timeout : 1800000,
			success : function(response, options) {
				var obj = Ext.decode(response.responseText);
				var graphData =obj.graph;
				console.info(graphData);
				var chart=null;
             	switch(paramsObj.graphType){
             		case "1" : 
             			chart= new FusionCharts("../fusioncharts/Column2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
             			break;
             		case "2" :
             		   chart = new FusionCharts("../fusioncharts/MSColumn3D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
             			break;
             		case "3" :
             		  chart = new FusionCharts("../fusioncharts/MSLine.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");   	
             			break;
             		case "4" :
             			chart = new FusionCharts("../fusioncharts/Pie3D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
             			break;
             		case "18" :
             			chart = new FusionCharts("../fusioncharts/MSColumn3DLineDY.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
             			break;
             	}
             	chart.setJSONData(graphData);
                chart.render('myChart');
			},
			failure : function(response, options) {
				Ext.MessageBox.alert('提示', '查询失败!');
			}
		});
	}
</script>
</head>
<body>
	<h1>3D柱状图</h1>
	<button type="button" onclick="showChart();">Click Me!</button>
	<div id="myChart"></div>
</body>
</html>
