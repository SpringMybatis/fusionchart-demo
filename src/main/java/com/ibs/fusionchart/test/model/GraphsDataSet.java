package com.ibs.fusionchart.test.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphsDataSet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 单线属性
	private String name;
	private String value;
	private String hoverText;

	// 多线属性
	private String showValues = "1";
	private String color;
	private String seriesname;
	private String parentYAxis;
	private String numberSuffix;
	private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

	public GraphsDataSet() {
		super();
	}

	public GraphsDataSet(String name, String value, String hoverText) {
		super();
		this.name = name;
		this.value = value;
		this.hoverText = hoverText;
	}

	public GraphsDataSet(String showValues, String color, String seriesname,
			String parentYAxis, String numberSuffix,
			List<Map<String, Object>> data) {
		super();
		this.showValues = showValues;
		this.color = color;
		this.seriesname = seriesname;
		this.parentYAxis = parentYAxis;
		this.numberSuffix = numberSuffix;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getHoverText() {
		return hoverText;
	}

	public void setHoverText(String hoverText) {
		this.hoverText = hoverText;
	}

	public String getShowValues() {
		return showValues;
	}

	public void setShowValues(String showValues) {
		this.showValues = showValues;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSeriesname() {
		return seriesname;
	}

	public void setSeriesname(String seriesname) {
		this.seriesname = seriesname;
	}

	public String getParentYAxis() {
		return parentYAxis;
	}

	public void setParentYAxis(String parentYAxis) {
		this.parentYAxis = parentYAxis;
	}

	public String getNumberSuffix() {
		return numberSuffix;
	}

	public void setNumberSuffix(String numberSuffix) {
		this.numberSuffix = numberSuffix;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

}
