Ext.define('GraphApp.lineGraphApp.controller.lineGraphController', {
	extend : 'Ext.app.Controller',
	init : function() {
		var me = this;
		this.control({
		});
	},
	views : ['lineGraphMainLayout', 'lineGraphGrid'],
	stores : ['lineGraphStore'],
	models : ['lineGraphModel']
});