package term;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MouseEventHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton btn=(JButton)e.getComponent();
			btn.setText("얼굴검출 완성");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}class EventHandler{
		public static void main(String[] args){
			JFrame frm=new JFrame("얼굴을 검출할 사진");
			frm.setBounds(120, 120, 300, 400);
			frm.setLayout(new FlowLayout());
			JButton btn=new JButton("얼굴검출 시작");
			MouseListener listener=new MouseEventHandler();
			btn.addMouseListener(listener);
			frm.add(btn);
			frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frm.setVisible(true);
		}
}		




