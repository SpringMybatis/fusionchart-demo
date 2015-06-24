package com.ibs.fusionchart.test.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import model.GraphLineDataSet;

public class Graphs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 图表配置
	private GraphsConfiguration graph;

	// 单线属性
	private List<GraphsDataSet> set;

	// 多线属性
	private List<Map<String, List<Map<String, Object>>>> categories;

	private List<GraphLineDataSet> dataset;

	public Graphs() {
		super();
	}

	// 单线图表
	public Graphs(GraphsConfiguration graph, List<GraphsDataSet> set) {
		super();
		this.graph = graph;
		this.set = set;
	}

	// 多线图表
	public Graphs(GraphsConfiguration graph,
			List<Map<String, List<Map<String, Object>>>> categories,
			List<GraphLineDataSet> dataset) {
		super();
		this.graph = graph;
		this.categories = categories;
		this.dataset = dataset;
	}

	public GraphsConfiguration getGraph() {
		return graph;
	}

	public void setGraph(GraphsConfiguration graph) {
		this.graph = graph;
	}

	public List<GraphsDataSet> getSet() {
		return set;
	}

	public void setSet(List<GraphsDataSet> set) {
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
