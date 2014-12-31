package cn.zcib.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class jFreeChartDemo3 {
	public static void main(String[] args) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("苹果", 100);
		dataset.setValue("梨子", 200);
		dataset.setValue("葡萄", 300);
		dataset.setValue("香蕉", 400);
		dataset.setValue("荔枝", 500);
		JFreeChart jfreechart = ChartFactory.createPieChart3D("水果产量图", dataset,
		true, true, true);
		//以窗体形式显示
		ChartFrame frame = new ChartFrame("报表练习", jfreechart);
		frame.setVisible(true);
		frame.pack();
		}
	
	public static ByteArrayInputStream create()
	{
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("苹果", 100);
		dataset.setValue("梨子", 200);
		dataset.setValue("葡萄", 300);
		dataset.setValue("香蕉", 400);
		dataset.setValue("荔枝", 500);
		JFreeChart jfreechart = ChartFactory.createPieChart3D("水果产量图", dataset,
		true, true, true);
		
		BufferedImage image = jfreechart.createBufferedImage(500, 300);
		
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(bos);
        try {
            jpeg.encode(image);
            byte[] bts = bos.toByteArray();
            inputStream = new ByteArrayInputStream(bts);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return inputStream;
	}
}