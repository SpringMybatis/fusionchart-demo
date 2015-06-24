(function() {
	
	Ext.define('GraphApp.lineGraphApp.view.lineGraphMainLayout', {
		extend : 'Ext.panel.Panel',
		alias : 'widget.lineGraphMainLayout',
		id : 'lineGraphMainLayout',
		layout : 'fit',
		border : 0,
		items : [ {
			xtype : 'container',
			layout : 'border',
			border : 0,
			padding : '5 5 5 5',
			items : [ {
				region : 'north',
				border : 0,
				title : '查询条件',
				xtype : 'form',
				height : 126,
				layout:'column',
				autoScroll : true,
				padding : '0 0 5 0',
				items : [{
					xtype:'combobox',
					fieldLabel : '请选择图表类型',
					id : 'graphType',
					store: Ext.create('Ext.data.Store',{
					fields: ['name', 'value'],
				    data : [
				     	{"name":"Column 2D", "value":"1"},
				        {"name":"Column 3D", "value":"2"},
				        {"name":"Line 2D", "value":"3"},
				        {"name":"Pie 3D",value:"4"},
				        {"name":"Pie 2D",value:"5"},
				        {"name":"Bar 2D",value:"6"},
				        {"name":"Area 2D",value:"7"},
				        {"name":"Doughtnut 2D", "value":"8"},
				        {"name":"Multi Column 3D", "value":"9"},
				        {"name":"Multi Column 2D", "value":"10"},
				        {"name":"Multi Area 2D",value:"11"},
				        {"name":"Multi Line 2D",value:"12"},
				        {"name":"Multi Bar 2D",value:"13"},
				        {"name":"Stacked Column 2D",value:"14"},
				        {"name":"Stacked Column 3D",value:"15"},
				        {"name":"Stacked Bar 2D",value:"16"},
				        {"name":"Stacked Area 2D",value:"17"},
				        {"name":"Col 2D+Line", "value":"18"},
				        {"name":"Col 3D+Line", "value":"19"},
				        {"name":"Funnel", "value":"20"}
				    	]
					}),
				    queryMode: 'local',
				    displayField: 'name',
				    valueField: 'value',
				    listeners:{
				    	change:function(newValue, oldValue,eOpts){
				    		var graphType = oldValue;
				    		var paramObj ={};
				    		paramObj.graphType = graphType;
							Ext.Ajax.request({
								url:'../graph/lineGraphList.html',
								params:paramObj,
								success:function(response, options){
									var obj = Ext.decode(response.responseText);
									var graphData =obj.graph;
									console.info(graphData);
			                     	var chart ;
			                     	switch(graphType){
			                     		case "1" : 
			                     			chart= new FusionCharts("/FusionChartsDemo/charts/FCF_Column2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "2" :
			                     		   chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Column3D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "3" :
			                     		  chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Line.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");   	
			                     			break;
			                     		case "4" :
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Pie3D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "5" :
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Pie2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "6" :
			                     			 chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Bar2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "7" :
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Area2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "8" :
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Doughnut2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "9" :
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_MSColumn3D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "10" :
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_MSColumn2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "11" : 
			                     			chart= new FusionCharts("/FusionChartsDemo/charts/FCF_MSArea2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "12" :
			                     		    chart = new FusionCharts("/FusionChartsDemo/charts/FCF_MSLine.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "13" :
			                     		    chart = new FusionCharts("/FusionChartsDemo/charts/FCF_MSBar2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");   	
			                     			break;
			                     		case "14" :
			                     			 chart = new FusionCharts("/FusionChartsDemo/charts/FCF_StackedColumn2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "15" :
			                     			 chart = new FusionCharts("/FusionChartsDemo/charts/FCF_StackedColumn3D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "16" ://空心饼
			                     			 chart = new FusionCharts("/FusionChartsDemo/charts/FCF_StackedBar2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "17" ://空心饼
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_StackedArea2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "18" ://空心饼
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_MSColumn3DLineDY.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "19" ://空心饼
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_MSColumn2DLineDY.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     		case "20" ://空心饼
			                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Funnel.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
			                     			break;
			                     	}
			                     	
			                     	chart.setJSONData(graphData);
					                chart.render('graphChartDiv');
								}
							});
				    	}
				    }
				}]
			},{
				region : 'center',
				border : 0,
				xtype : 'tabpanel',
				border : 0,
				tabPosition : 'bottom',
				id : 'lineGraphTab',
				items : [{
					title:'图表呈现',
					layout:'fit',
					border : 0,
					html:'<div id="graphChartDiv" align="center">统计图表，目前无数据</div>'
				}]
			}]
		} ]

	});
})();
