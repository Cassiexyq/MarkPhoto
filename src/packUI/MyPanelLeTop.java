package packUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

//���ϵ�Panel���
public class MyPanelLeTop extends JPanel {
	public static FileContent fC;		//�ļ��б������
	public static JScrollPane jP;			//���������
	//���캯��
	public MyPanelLeTop(){	
		initMPLT();
		this.setVisible(true);
	}
	//��ʼ����ǰ���
	public void initMPLT(){
		this.setBackground(new Color(0xCCCCCC));
		this.setBounds(0, 0, ATP.leftW, ATP.leftTopH);
//		this.repaint();
		this.setLayout(null);
	}
	//�����������
	public void openAll(){
		if( jP != null ) this.remove(jP);
		fC = new FileContent(){
			
			@Override
			public void getfile(int i) {
				// TODO Auto-generated method stub
				getfiles(i);
			}
		};
		
		
		jP = new JScrollPane(fC);
		jP.setSize(ATP.leftW,ATP.leftTopH);
		//���ú����������������
		jP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(jP);
		this.setVisible(true);
		this.updateUI();
		
	}
	//��ȡ��ǰ����ĺ���_3
	public void getfiles(int i){
		
	}
	
	//�ı��б���ı�����ɫ��ѡ�С�δѡ�У�
	public void changeBC(){
		Object obj = null;
		//�ҵ���Ӧ��������ı�ֵ
	    obj = fC.getComponent(MyFrame.PictureNumF);
		if(obj instanceof FileName){
			FileName FN = (FileName)obj;
			FN.init();
		}
		obj = fC.getComponent(MyFrame.PictureNum);
		if(obj instanceof FileName){
			FileName FN = (FileName)obj;
			FN.BC();
		}
	}
	
	//����Ƿ��Ѿ���ͼƬ���б��
	public static void changeGL(){
		Object obj = null;
		FileName FN = null;
		//�ҵ���Ӧ�����
//		System.out.println("ce shi 1");
		if(fC != null){
//			System.out.println("ce shi 2");
			obj = fC.getComponent(MyFrame.PictureNum); 
			if(obj instanceof FileName)
		    FN = (FileName)obj;
			
			//�ж�ͼƬ�Ƿ��ǲ��ı�ֵ
			if(fC.getComponentCount()>MyFrame.PictureNum && MainFrame.workerType)
			{
				FN.addSpecial();
			}
			else if( !MainFrame.workerType && FN.getShow()){
				FN.addSpecial();
			}
			else
			{
				FN.clearSpecial();
			}
		}

	}
	//���ͼƬΪ�������ļ�
	public static void changeWR(){
		Object obj = null;
		FileName FN = null;
		//�ҵ���Ӧ�����
		obj = fC.getComponent(MyFrame.PictureNum); 
		if(obj instanceof FileName)
	    FN = (FileName)obj;
		
		//�ж�ͼƬ�Ƿ��ǲ��ı�ֵ
		FN.addWrong();
	}
//	//��ȡ�ļ��д���ı���ļ�
//	public static void changeWRAll(){
//		Object obj = null;
//		FileName FN = null;
//		for(int i=0; i<FileRead.wrongObjNuum.length; i++ )
//		{
//			if(FileRead.wrongObjNuum[i]>0)
//			{
//				obj = fC.getComponent(i);
//				if(obj instanceof FileName)
//				FN = (FileName)obj;
//				FN.addWrong();
//			}
//		}
//	}
}
