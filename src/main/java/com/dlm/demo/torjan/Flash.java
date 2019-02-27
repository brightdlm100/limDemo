package com.dlm.demo.torjan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.Field;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


/*闪屏*/
	public class Flash {
		JFrame frame;
		JPanel pane;
		Color c[] = {  Color.pink,Color.white,Color.blue};
		

		
		int i;
		Image offScreenImage = null;	
		String msg;
		public Flash(String s) {
			
			msg=s;
			final int width=Toolkit.getDefaultToolkit().getScreenSize().width;
			final int height=Toolkit.getDefaultToolkit().getScreenSize().height;
			frame = new JFrame();
			frame.setAlwaysOnTop(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setUndecorated(true);
			frame.setBounds(0,0,width,height);
			pane = new JPanel() {
				public void paint(Graphics g) {
					if(offScreenImage == null){
						offScreenImage=this.createImage(width, height);
					}
					Graphics gg=offScreenImage.getGraphics();
					gg.setFont(new Font(null, Font.CENTER_BASELINE, 100));
					Object[] o=getColor();
					gg.setColor((Color) o[0]);
					gg.fillRect(0, 0, width, height);
					gg.setColor(Color.black);
					String text=msg+"-----color:"+o[1];
					gg.drawString(msg, 500, height/2);
					gg.setFont(new Font(null, Font.ROMAN_BASELINE, 30));
					gg.drawString((String) o[1], width/5*3, height);
					g.drawImage(offScreenImage, 0, 0, null);
				}
			};
			frame.setContentPane(pane);
			frame.setVisible(true);
			new Thread() {
				public void run() {
					int time=0;
					while (true) {
						Flash.this.myUpdate();
						try {
							Thread.sleep(42);
							time++;
							if(time==10){
								frame.dispose();
								break;
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
		public void myUpdate() {
			if (i == c.length-1) {
				i = 0;
			} else {
				i++;
			}
			pane.repaint();
		}
		
		public static void main(String[] args) {
			new Flash("哈哈哈哈哈,你的电脑已中毒！");
			//getColor();
		}
		
		
		public static Object[] getColor() {
			Random r=new Random();
			Float f1=r.nextFloat();
			Float f2=r.nextFloat();
			Float f3=r.nextFloat();
			Color c=new Color(f1,f2,f3);
			Object[] o=new Object[2];
			o[0]=c;
			o[1]="R:+"+f1*100+"%-------G:"+f2*100+"%-------,B:"+f3*100+"%";
			return o;
		}
		
		/**
		 * 获取属性名数组
		 */
		private static String[] getFiledName(Object o) {
			Field[] fields = o.getClass().getDeclaredFields();
			String[] fieldNames = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				// System.out.println(fields[i].getType());
				fieldNames[i] = fields[i].getName();
			}
			return fieldNames;
		}
		
	}