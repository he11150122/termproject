package term;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.*;



public class ReadImage extends JFrame{
	
	BufferedImage bi = null;
	
	public ReadImage(){
		setTitle("얼굴을 검출할 사진");
		setSize(300,300);
		setVisible(true);
		
		
		try{
			bi=bufferedImage();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}private BufferedImage bufferedImage() throws Exception{
		File file = new File("face.jpg");
		BufferedImage bi=ImageIO.read(file);
		return bi;
	}public void paint(Graphics g){
		if(this.bi != null){
			g.drawImage(this.bi, 0, 10, this);
		}
	}public static void main(String args[]){
		WindowListener listen=new WindowAdapter(){     
			public void windowClosing(WindowEvent ev){
				System.exit(0);
			}
		};
		
		ReadImage frm=new ReadImage();
		frm.addWindowListener(listen);
		frm.setBounds(300,120,300,400);
		frm.setLayout(new FlowLayout());

		frm.setVisible(true);
	}
}

