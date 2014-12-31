package cn.zcib.action;

import cn.zcib.util.jFreeChartDemo3;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import sun.awt.image.ImageFormatException;


/**
 * @name 验证码类
 * @package cn.zcib.util
 * @author REAL
 * @version 2013.12.24
 */
@SuppressWarnings("unused")
public class PieChartAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	//Struts2中Map类型的session
//    @SuppressWarnings("unchecked")
//	private Map<String, Object> session = ActionContext.getContext().getSession();
    
    //图片流
    private ByteArrayInputStream imageStream;

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

	public String execute() throws Exception {
    	imageStream = jFreeChartDemo3.create();
        return SUCCESS;
    }

}
