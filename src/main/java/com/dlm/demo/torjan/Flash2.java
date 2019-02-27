package com.dlm.demo.torjan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/* 闪屏 */
public class Flash2 {
	JFrame frame;
	JPanel pane;
	Color c[] = { Color.pink, Color.white, Color.blue };
	int i;
	Image offScreenImage = null;
	String msg;

	public Flash2(String s) {
		msg = s;
		final int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		final int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setBounds(0, 0, width, height);
		pane = new JPanel() {
			@Override
			public void paint(Graphics g) {
				if (offScreenImage == null) {
					offScreenImage = this.createImage(width, height);
				}
				Graphics gg = offScreenImage.getGraphics();
				gg.setFont(new Font(null, Font.PLAIN, 50));
				gg.setColor(c[i]);
				gg.fillRect(0, 0, width, height);
				//gg.setColor(Color.black);
				gg.drawString(msg, 200, 50);
				g.drawImage(offScreenImage, 0, 0, null);
			}
		};
		frame.setContentPane(pane);
		frame.setVisible(true);
		new Thread() {
			@Override
			public void run() {
				int time = 0;
				while (i < c.length) {
					Flash2.this.myUpdate();
					try {
						Thread.sleep(10);
						time++;
						if (time == 100) {
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
		if (i == c.length - 1) {
			i = 0;
		} else {
			i++;
		}
		pane.repaint();
	}
	
	public static void main(String[] args) {
		new Flash2("hhhh");
	}
}