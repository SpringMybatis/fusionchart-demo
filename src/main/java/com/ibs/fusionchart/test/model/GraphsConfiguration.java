package com.ibs.fusionchart.test.model;

import java.io.Serializable;

public class GraphsConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 标题
	private String caption;
	// 子标题
	private String subcaption;
	// x轴名字
	private String xAxisName;
	// y轴最小值
	private String yAxisMinValue;
	// y轴名字
	private String yAxisName;
	// y轴最大值
	private String yAxisMaxValue;
	// 小数精确度
	private String decimalPrecision = "0";
	// 数字格式化
	private String formatNumberScale;
	// 数字前缀
	private String numberPrefix;
	// 显示汉字
	private String showNames = "1";
	// 显示值
	private String showValues = "1";
	private String showAlternateHGridColor = "1";
	private String AlternateHGridColor = "ff5904";
	private String divLineColor = "ff5904";
	private String divLineAlpha = "20";
	private String alternateHGridAlpha = "5";
	private String rotateNames = "0";
	private String yAxisValuesStep;
	private String PYAxisName = "数量(次/网元)";
	private String SYAxisName = "百分占比";
	private String hovercapbg = "FFECAA";
	private String hovercapborder = "F47E00";
	private String numdivlines = "3";
	private String numVdivlines = "0";
	private String yAxisminvalue;
	private String yAxismaxvalue;

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getSubcaption() {
		return subcaption;
	}

	public void setSubcaption(String subcaption) {
		this.subcaption = subcaption;
	}

	public String getxAxisName() {
		return xAxisName;
	}

	public void setxAxisName(String xAxisName) {
		this.xAxisName = xAxisName;
	}

	public String getyAxisMinValue() {
		return yAxisMinValue;
	}

	public void setyAxisMinValue(String yAxisMinValue) {
		this.yAxisMinValue = yAxisMinValue;
	}

	public String getyAxisName() {
		return yAxisName;
	}

	public void setyAxisName(String yAxisName) {
		this.yAxisName = yAxisName;
	}

	public String getyAxisMaxValue() {
		return yAxisMaxValue;
	}

	public void setyAxisMaxValue(String yAxisMaxValue) {
		this.yAxisMaxValue = yAxisMaxValue;
	}

	public String getDecimalPrecision() {
		return decimalPrecision;
	}

	public void setDecimalPrecision(String decimalPrecision) {
		this.decimalPrecision = decimalPrecision;
	}

	public String getFormatNumberScale() {
		return formatNumberScale;
	}

	public void setFormatNumberScale(String formatNumberScale) {
		this.formatNumberScale = formatNumberScale;
	}

	public String getNumberPrefix() {
		return numberPrefix;
	}

	public void setNumberPrefix(String numberPrefix) {
		this.numberPrefix = numberPrefix;
	}

	public String getShowNames() {
		return showNames;
	}

	public void setShowNames(String showNames) {
		this.showNames = showNames;
	}

	public String getShowValues() {
		return showValues;
	}

	public void setShowValues(String showValues) {
		this.showValues = showValues;
	}

	public String getShowAlternateHGridColor() {
		return showAlternateHGridColor;
	}

	public void setShowAlternateHGridColor(String showAlternateHGridColor) {
		this.showAlternateHGridColor = showAlternateHGridColor;
	}

	public String getAlternateHGridColor() {
		return AlternateHGridColor;
	}

	public void setAlternateHGridColor(String alternateHGridColor) {
		AlternateHGridColor = alternateHGridColor;
	}

	public String getDivLineColor() {
		return divLineColor;
	}

	public void setDivLineColor(String divLineColor) {
		this.divLineColor = divLineColor;
	}

	public String getDivLineAlpha() {
		return divLineAlpha;
	}

	public void setDivLineAlpha(String divLineAlpha) {
		this.divLineAlpha = divLineAlpha;
	}

	public String getAlternateHGridAlpha() {
		return alternateHGridAlpha;
	}

	public void setAlternateHGridAlpha(String alternateHGridAlpha) {
		this.alternateHGridAlpha = alternateHGridAlpha;
	}

	public String getRotateNames() {
		return rotateNames;
	}

	public void setRotateNames(String rotateNames) {
		this.rotateNames = rotateNames;
	}

	public String getyAxisValuesStep() {
		return yAxisValuesStep;
	}

	public void setyAxisValuesStep(String yAxisValuesStep) {
		this.yAxisValuesStep = yAxisValuesStep;
	}

	public String getPYAxisName() {
		return PYAxisName;
	}

	public void setPYAxisName(String pYAxisName) {
		PYAxisName = pYAxisName;
	}

	public String getSYAxisName() {
		return SYAxisName;
	}

	public void setSYAxisName(String sYAxisName) {
		SYAxisName = sYAxisName;
	}

	public String getHovercapbg() {
		return hovercapbg;
	}

	public void setHovercapbg(String hovercapbg) {
		this.hovercapbg = hovercapbg;
	}

	public String getHovercapborder() {
		return hovercapborder;
	}

	public void setHovercapborder(String hovercapborder) {
		this.hovercapborder = hovercapborder;
	}

	public String getNumdivlines() {
		return numdivlines;
	}

	public void setNumdivlines(String numdivlines) {
		this.numdivlines = numdivlines;
	}

	public String getNumVdivlines() {
		return numVdivlines;
	}

	public void setNumVdivlines(String numVdivlines) {
		this.numVdivlines = numVdivlines;
	}

	public String getyAxisminvalue() {
		return yAxisminvalue;
	}

	public void setyAxisminvalue(String yAxisminvalue) {
		this.yAxisminvalue = yAxisminvalue;
	}

	public String getyAxismaxvalue() {
		return yAxismaxvalue;
	}

	public void setyAxismaxvalue(String yAxismaxvalue) {
		this.yAxismaxvalue = yAxismaxvalue;
	}

}
