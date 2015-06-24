Ext.define('GraphApp.lineGraphApp.store.lineGraphStore', {
			extend : 'Ext.data.Store',
			model : 'GraphApp.lineGraphApp.model.lineGraphModel',
			proxy : {
				type : "ajax",
				url : '../graph/lineGraphList.html',
				reader : {
					type : 'json',
					root : 'list'
				}

			},
			autoLoad:false,
			listeners : {
				load : function(arg1,agr2,arg3,arg4){
					var obj = arg1.proxy.reader.jsonData;
				     if(obj.actionStatus == 'SUCCESS'){
                     	if(obj.count == 0){
                     		Ext.Msg.alert('系统提示','没有满足条件的数据');
                     		return;
                     	}
                     	var graphData = obj.graph;
                     	var chart ;
                     	switch(obj.graphType){
                     		case 1 : 
                     			chart= new FusionCharts("/FusionChartsDemo/charts/FCF_Line.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
                     			break;
                     		case 2 :
                     		   chart = new FusionCharts("/FusionChartsDemo/charts/FCF_MSColumn3DLineDY.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
                     			break;
                     		case 3 :
                     		  chart = new FusionCharts("/FusionChartsDemo/charts/FCF_MSLine.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");   	
                     			break;
                     		case 4 :
                     			 chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Pie3D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
                     			break;
                     		case 5 :
                     			 chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Area2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
                     			break;
                     		case 6 ://空心饼
                     			 chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Doughnut2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
                     			break;
                     		case 7 ://空心饼
                     			chart = new FusionCharts("/FusionChartsDemo/charts/FCF_Bar2D.swf", Ext.Date.format(new Date(),'YmdHis'), "1000", "300", "0", "0");
                     			break;
                     	}

                     	console.info(graphData);
                     	chart.setJSONData(graphData);
		                chart.render('graphChartDiv');
                     }else if(obj.actionStatus == 'FAIL'){
                     	Ext.Msg.alert('系统提示',obj.actionMessage+' '+obj.actionException);
                     	return;
                     }
				}
			}
		});