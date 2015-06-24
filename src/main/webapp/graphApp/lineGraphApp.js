Ext.onReady(function() {
			Ext.QuickTips.init();
			
			Ext.Loader.setConfig({
						enabled : true
					});
			Ext.application({
						name : 'GraphApp.lineGraphApp',
						appFolder : '../graphApp/lineGraphApp',
						launch : function() {
							Ext.create('Ext.container.Viewport', {
										layout : 'fit',
										items : [{
													xtype : 'lineGraphMainLayout'
												}]
									});
						},
						controllers : ['lineGraphController']
					});
		});