package com.sindhu.vendor.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilImpl implements ReportUtil {
	
	@Override
	public void generateChart(String path, List<Object[]> data) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Object[] objs : data){
			dataset.setValue(objs[0].toString(), new Double(objs[1].toString()));
		}
		JFreeChart createChart = ChartFactory.createPieChart3D("Pie Chart for Vendor types", dataset );
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/pieChartReport.jpeg"), createChart, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		ChartFactory.createBarChart3D(title, categoryAxisLabel, valueAxisLabel, dataset)
	}

}
