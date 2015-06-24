(function(){
	Ext.define('GraphApp.lineGraphApp.view.lineGraphGrid', {
			extend : 'Ext.grid.Panel',
			alias : 'widget.lineGraphGrid',
			selType:'cellmodel',
			enableColumnHide:false,
			enableColumnMove:false,
			sortableColumns : false,
			store:"lineGraphStore", 
			columns : [
	                     {header : "ID", align:'right',dataIndex : 'id',sortable : true},
	                     {header : "time1", align:'right', dataIndex : 'time1',width:80},
	                     {header : "time2",align:'right',  dataIndex : 'time2',width:120}
	                      
	                  ]
		});
})();
