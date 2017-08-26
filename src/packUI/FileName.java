package packUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import packData.DataProcess;
import packData.ModelProcess;
import packData.ReloadData;

//������б��е�һ�����
public class FileName extends JPanel{
	public static boolean deleteAll = false;   //�ж��Ƿ���ú���changeToCache�е���ղ���
	public static boolean flagGoog = false;	  
	//
	private Color color; 						  //����ı�����ɫ
	private Color color1 = new Color(0xCCCCCC); //�����Ĭ�ϱ���ɫ
	private int fnID;							 //�����ID
	private JLabel fileName;					 //��ʾ������
	private JLabel special;					 //��ʾΪ�Թ���ɫ�����
	private boolean isSpecial = false;		 //��ǰ����Ƿ񱻱��
	private boolean isShow = false;
	public FileName(String text,int i) {
		// TODO Auto-generated constructor stub
		
		this.fnID = i;
		color = color1;
		this.setBackground(color);
		this.setSize(180,25);
		this.setLayout(null);
		//��ʾ�ļ������ֵ������ʼ��
		fileName = new JLabel();
		fileName.setBounds(0, 0,135, 25);
		fileName.setHorizontalAlignment(SwingConstants.LEFT);
		fileName.setText(text);		
		//���ͼƬ��ʾ�������ʼ��
		special = new JLabel();
		special.setBounds(138, 3, 19, 19);
		special.addMouseListener(new MouseListener() {
			
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
				getFile(fnID);
				if(isSpecial&&MainFrame.workerType)
				{
					if(JOptionPane.showInternalConfirmDialog(MainFrame.myFrame.getContentPane(), 
							"ȷ��Ҫɾ����ͼ���еĶ�����", "��ն���", 
							JOptionPane.YES_NO_OPTION, 
							JOptionPane.INFORMATION_MESSAGE)==JOptionPane.YES_OPTION)
					{
						deleteAll = true;
						try {
							DataProcess.changeToCache();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(!MyFrame.rList.isEmpty())
						{
							MyFrame.rList.clear();
							ReloadData.rMarkL.clear();
						}
						MyPanelRight.reLook();
						MyFrame.mPLB.openAll();
						clearSpecial();
						deleteAll = false;
					}	
				}
			}
		});
		
		this.add(fileName);
		this.add(special);
		this.setBorder(BorderFactory.createLineBorder(new Color(0xCCCCCC)));
		this.setOpaque(true);
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
				color = color1;
				changeColor();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			   color = Color.cyan;
			   changeColor();
//			   System.out.println("is Entered");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				MyPanelRight.reLook();

				if(MyFrame.havePaint == true)
				{
					if(MyPanelRight.btnMark == false){
						  JOptionPane.showMessageDialog(null, "����û�б��棡��");
						  
					  }
					else
					{
						String bg = MyFrame.openKey.getOnePic(MyFrame.PictureNum);
						String arrBgTemp = bg;
						String arrBg[] = arrBgTemp.split("\\\\");
						arrBgTemp = arrBg[arrBg.length-1];
						MyFrame.onePicName = arrBgTemp;
						

						if(MyPanelRight.markedR.size() == MyFrame.list.size())
						{
//							try {
//								test1.dataToCache();
//								test1.txtToXML(test1.pathData+"\\imgCache.txt");
//								test1.dataToTxt(test1.testTxt);
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
							
							MyFrame.cleatAllList();
							MyPanelRight.btnMark = false;
							MyFrame.havePaint = false;
						}
						if(MyFrame.clearRect > 0 && MyPanelRight.markedR.size() != MyFrame.list.size())
						{
							for(int i = MyFrame.list.size()-1; i >= 0 && MyFrame.clearRect > 0; i--,MyFrame.clearRect--)
							  {
								MyFrame.list.remove(i);
								MyFrame.listS.remove(i);
								  
							  }
						}
//						saveData();
//						System.out.println("�����picnum��"+MyFrame.onePicName);
						getFile(fnID);
						
					}
					
				}
				else
				{
					getFile(fnID);
				}
				
				
			}
		});
//		visitFile();
	}
	
	//��ȡ��ǰ����ĺ���_1
	public void getFile(int k){
		
	}
	
	//�ı䵱ǰ����ı�����ɫ
	public void changeColor(){
		this.setBackground(color);
	}
	
	
	//�ı������Ĭ�ϱ���ɫ
	public void BC(){
		color1 = Color.cyan;
		color = color1;
		changeColor();
	}
	
	//��ԭ�����Ĭ�ϱ���ɫ
	public void init(){
		color1 = new Color(0xCCCCCC);
		color = color1;
		changeColor();
	}
	
//	public void visitFile(){
//		
//		for(int i = 0; i < FileContent.mount; i++){
//			addGoodLabel(MyFrame.openKey.getOneName(i), i);
//		}
//	}
	
//	public void addGoodLabel(String filename, int i){
////		System.out.println("����1");
//		try {
//			if(ReloadData.specialCheck(filename))
//			{
//				System.out.println("����");
//				goodL.setBounds(135, 25, 20, 20);
//				this.add(goodL);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.println("addGoodLabel ������!");
//		}
//		
//	}
	
	//���ø����Ϊ�ѱ�����
	public void addSpecial(){
		special.setIcon(new ImageIcon(FileName.class.getResource("/image/good.jpg")));
		if(MainFrame.workerType) isSpecial = true;
		else isShow = true;
	}
	//���ø����Ϊδ������
	public void clearSpecial(){
		special.setIcon(null);
		isSpecial = false;
		isShow = false;
	}
	//���ø����Ϊ���������
	public void addWrong()
	{
		special.setIcon(new ImageIcon(FileName.class.getResource("/image/wrong.png")));
		isSpecial = true;
		isShow = false;
	}
	
	public boolean getShow(){
		return isShow;
	}
	public void setShowt(){
		System.out.println(" is  setShowt");
		isShow = true;
	}
//	public void setShoww(){
//		isShow = false;
//	}
}
