package packUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class WrongMassage extends JPanel {
	private int fnID;							 //�����ID
	private Color color; 						  //����ı�����ɫ
	private Color color1 = new Color(0xCCCCCC); //�����Ĭ�ϱ���ɫ
	private JLabel wrongMassage;					 //��ʾ������
	public WrongMassage(int i,String text) {
		// TODO Auto-generated constructor stub
		fnID = i;
		setBackgroud();
		wrongMassage = new JLabel(text);
		wrongMassage.setSize(text.length()*11,25);
		wrongMassage.setHorizontalAlignment(SwingConstants.LEFT);
		wrongMassage.setFont(new Font("����", 1, 11));
		this.setSize(text.length()*11,25);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(new Color(0xCCCCCC)));
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				getFile(fnID);
			}
		});
	
		this.setOpaque(true);
		this.add(wrongMassage);
		this.setVisible(true);
	}

	public void getFile(int k ){
		
	}
	
	public void setBackgroud(){
		if(fnID%2 == 1){
			color = color1;
			this.setBackground(color);
		}
	}
}
