package packUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class WrongPanel extends JPanel {
	public static WrongList WL;		//�ļ��б������
	private JScrollPane jP;			//���������
	private JLabel title1;

	//���캯��
	public WrongPanel(){	
		initWP();
		this.setVisible(true);
	}
	//��ʼ����ǰ���
	public void initWP(){
		this.setBackground(new Color(0xCCCCCC));
		this.setBounds( ATP.frameW-ATP.rightW, ATP.frameH-320, ATP.leftW,210);//λ����Ϣ
//		this.repaint();
		this.setLayout(null);
		title1 = new JLabel("������Ϣ");
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setFont(new Font("����", 1, 11));
		title1.setBounds(0, 0, 180, 25);
		if(MainFrame.userID != null){
			this.add(title1);
		}

	}
	//�����������
	public void openAll(){
		if( jP != null ) this.remove(jP);
		WL = new WrongList(){
			
			@Override
			public void getfile(int i) {
				// TODO Auto-generated method stub
				getfiles(i);
			}
		};
		
		initWP();
		jP = new JScrollPane(WL);
		jP.setSize(ATP.leftW,185);
		jP.setLocation(0,25);
		//���ú����������������
	//	jP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(jP);
		this.setVisible(true);
		this.updateUI();
		
	}
	//��ȡ��ǰ����ĺ���_3
	public void getfiles(int i){
		
	}
	
//	//�ı��б���ı�����ɫ��ѡ�С�δѡ�У�
//	public void changeBC(){
//		Object obj = null;
//		//���ݵ�ǰ���������ı��������λ��
//		jP.getVerticalScrollBar().setValue(MyFrame.PictureNum*ATP.objectH-ATP.objectH*11);
//		//�ҵ���Ӧ��������ı�ֵ
//	    obj = fC.getComponent(MyFrame.PictureNumF);
//		if(obj instanceof FileName){
//			FileName FN = (FileName)obj;
//			FN.init();
//		}
//		obj = fC.getComponent(MyFrame.PictureNum);
//		if(obj instanceof FileName){
//			FileName FN = (FileName)obj;
//			FN.BC();
//		}
//	}
//	
//	//����Ƿ��Ѿ���ͼƬ���б��
//	public static void changeGL(){
//		Object obj = null;
//		FileName FN = null;
//		//�ҵ���Ӧ�����
////		System.out.println("ce shi 1");
//		if(fC != null){
////			System.out.println("ce shi 2");
//			obj = fC.getComponent(MyFrame.PictureNum); 
//			if(obj instanceof FileName)
//		    FN = (FileName)obj;
//			
//			//�ж�ͼƬ�Ƿ��ǲ��ı�ֵ
//			if(fC.getComponentCount()>MyFrame.PictureNum && MainFrame.workerType)
//			{
//				FN.addSpecial();
//			}
//			else if( !MainFrame.workerType && FN.getShow()){
//				FN.addSpecial();
//			}
//			else
//			{
//				FN.clearSpecial();
//			}
//		}
//
//	}
//	//���ͼƬΪ�������ļ�
//	public static void changeWR(){
//		Object obj = null;
//		FileName FN = null;
//		//�ҵ���Ӧ�����
//		obj = fC.getComponent(MyFrame.PictureNum); 
//		if(obj instanceof FileName)
//	    FN = (FileName)obj;
//		
//		//�ж�ͼƬ�Ƿ��ǲ��ı�ֵ
//		FN.addWrong();
//	}
}
