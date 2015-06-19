package model;

import java.util.List;
import java.util.Map;


public class GraphsLine {
	private GraphLineSettings graph;
	private List<GraphLineDataSet> set;
	
	//多线属性
	private List<Map<String, List<Map<String, Object>>>> categories;
	private List<GraphLineDataSet> dataset;
	
	public GraphsLine(){
		
	}
	//单线
	public GraphsLine(GraphLineSettings graph, List<GraphLineDataSet> set) {
		this.graph = graph;
		this.set = set;
	}
	
	//多线
	public GraphsLine(GraphLineSettings graph,
			List<Map<String, List<Map<String, Object>>>> categories,
			List<GraphLineDataSet> dataset) {
		this.graph = graph;
		this.categories = categories;
		this.dataset = dataset;
	}
	
	public GraphLineSettings getGraph() {
		return graph;
	}
	public void setGraph(GraphLineSettings graph) {
		this.graph = graph;
	}
	public List<GraphLineDataSet> getSet() {
		return set;
	}
	public void setSet(List<GraphLineDataSet> set) {
		this.set = set;
	}
	public List<Map<String, List<Map<String, Object>>>> getCategories() {
		return categories;
	}
	public void setCategories(
			List<Map<String, List<Map<String, Object>>>> categories) {
		this.categories = categories;
	}
	public List<GraphLineDataSet> getDataset() {
		return dataset;
	}
	public void setDataset(List<GraphLineDataSet> dataset) {
		this.dataset = dataset;
	}
	
}
