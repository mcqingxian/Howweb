package com.hoau.wechat.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/**
 * 
 * @ClassName: ChartGraphics 
 * @Description: TODO 生成图片
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年7月31日 上午8:46:31 
 *
 */
public class ChartGraphics {
	int imageWidth = 260;// 图片的宽度
	int imageHeight = 150;// 图片的高度
	BufferedImage image;
	
	/**
	 * 例如：
	 *          谢谢惠顾
	 * <p>Title: </p> 
	 * <p>Description: 谢谢惠顾</p> 
	 * @param msg
	 */
	public ChartGraphics(String msg){
		try{
			graphicsGeneration1(msg);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 例如：
	 *          恭喜中奖，30元优惠劵
	 *       优惠券编码为：BCDSDFLA293898
	 * <p>Title: </p> 
	 * <p>Description: 中奖的</p> 
	 * @param msg
	 * @param detailMsg
	 */
	public ChartGraphics(String msg, String detailMsg){
		try{
			graphicsGeneration2(msg, detailMsg);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: graphicsGeneration1 
	 * @Description: TODO 
	 * @param @param msg    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private void graphicsGeneration1(String msg) throws Exception{
		image = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		graphics.setColor(Color.red);
		int fontSize = 20;
		graphics.setFont(new Font("宋体", Font.BOLD, fontSize));
		int strWidth = graphics.getFontMetrics().stringWidth(msg);
		graphics.drawString(msg, Math.max(0, (imageWidth - strWidth) / 2), 75);
		graphics.dispose();
	}
	
	/**
	 * 
	 * @Title: graphicsGeneration2 
	 * @Description: TODO 生成图片，带详细信息的
	 * @param @param msg
	 * @param @param detailMsg    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private void graphicsGeneration2(String msg, String detailMsg) throws Exception{
		image = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		graphics.setColor(Color.red);
		int fontSize = 20;
		graphics.setFont(new Font("宋体", Font.BOLD, fontSize));
		int strWidth = graphics.getFontMetrics().stringWidth(msg);
		graphics.drawString(msg, Math.max(0, (imageWidth - strWidth) / 2), 70);
		fontSize = 16;
		graphics.setFont(new Font("宋体", Font.BOLD, fontSize));
		strWidth = graphics.getFontMetrics().stringWidth(detailMsg);
		graphics.drawString(detailMsg, Math.max(0, (imageWidth - strWidth) / 2), 100);
		graphics.dispose();
	}
	
	public void write(OutputStream sos) throws IOException {
		ImageIO.write(image, "png", sos);
		sos.close();
	}
	public void write(File file) throws IOException {
		ImageIO.write(image, "png", file);
	}
	
	//String str = request.getSession().getServletContext().getRealPath("/")+"img/"+Math.random()+".png";
}