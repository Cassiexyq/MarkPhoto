package packUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import packData.CalcExchange;
import packData.DataProcess;
import packData.ModelProcess;
import packData.ReloadData;

//��ѡ�������
public class ObjectName extends JPanel{
	private Color color; 						//����ı�����ɫ
	private Color color1 = new Color(0xCCCCCC);//�����Ĭ�ϱ���ɫ
	private int fnID;							//�����ID
	public  JButton change;						//�༭��ť
	public  JButton delect;						//ɾ����ť
	public  JButton wrong;						//����ť
	public  JLabel errorP;						//����ͼ��
	private JLabel objName;					//�����
	boolean ischeck = false;
	
	
	public ObjectName(String text,int i) {
		// TODO Auto-generated constructor stub
		this.fnID = i;
		color = color1;
		
		this.setBackground(color);
		this.setSize(180,25);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(new Color(0xCCCCCC)));
		this.setOpaque(true);
		
		objName = new JLabel();
		objName.setText(text);
		objName.setBounds(0, 0, 80, 25);
		this.add(objName);
	
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
				if(!MyPanelRight.hChange)
				{
					color = Color.cyan;
					changeColor();
					getFile(fnID);
				}	
			   
//			   System.out.println("is Entered");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
					getFile(fnID);
					
				
			}
		});
		
		if(MainFrame.workerType) init_makeer();
		else init_tester();
		
	}
	
	//��ʼ�������������״̬��
	public void init_makeer(){
		change = new JButton("�޸�");
		change.setBounds(81, 1, 38, 23);
		change.setFont(new Font("΢���ź�",1,12));
		change.setMargin(new Insets(0,0,0,0));
		
		delect = new JButton("ɾ��");
		delect.setBounds(121, 1, 38, 23);
		delect.setFont(new Font("΢���ź�",1,12));
		delect.setMargin(new Insets(0,0,0,0));

//		Double(fnID);
		
		this.add(change);
		this.add(delect);
		change.addMouseListener(new MouseListener() {
			
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
				if(!MyPanelRight.hChange)
				{
					color = Color.cyan;
					changeColor();
					getFile(fnID);
				}	
			   
//			   System.out.println("is Entered");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				getFile(fnID);
				MyPanelRight.hChange = true;
				MyFrame.afterPaint = false;
				
				String sTmp = ReloadData.rMarkL.get(fnID);
//				System.out.println("sTmp: "+sTmp);
				MyPanelRight.markTS = sTmp.split(" ");
				
				MyPanelRight.objName.setSelectedItem(MyPanelRight.markTS[0]);
				
				MyPanelRight.objPose.setSelectedItem(MyPanelRight.markTS[1]);
				MyPanelRight.objColor.setSelectedItem(MyPanelRight.markTS[2]);
//				System.out.println(MyPanelRight.markTS[3]+"||"+MyPanelRight.markTS[3]);
				int ttr = Integer.parseInt(MyPanelRight.markTS[3]);
				int tco = Integer.parseInt(MyPanelRight.markTS[4]);
				int tdi = Integer.parseInt(MyPanelRight.markTS[5]);
				int tsh = Integer.parseInt(MyPanelRight.markTS[6]);
				
				MyPanelRight.xmlTrunc = ttr;
				MyPanelRight.xmlCover = tco;
				MyPanelRight.xmlDiff = tdi;
				MyPanelRight.xmlShadow = tsh;
				
				
				if(MyPanelRight.xmlDiff == 1){
					MyPanelRight.kn.setSelected(true);
				}
				else
				{
					MyPanelRight.bkn.setSelected(true);
				}
				
				if(MyPanelRight.xmlTrunc == 1){
					MyPanelRight.fg.setSelected(true);
				}
				else
				{
					MyPanelRight.mfg.setSelected(true);
				}
				
				if(MyPanelRight.xmlCover == 1){
					MyPanelRight.xmid.setSelected(true);
				}
				else
				{
					MyPanelRight.dmid.setSelected(true);
				}
				
				if(MyPanelRight.xmlShadow == 1){
					MyPanelRight.yy.setSelected(true);
				}
				else
				{
					MyPanelRight.myy.setSelected(true);
				}
				
				MyPanelRight.box1 = MyPanelRight.markTS[0];
				MyPanelRight.box2 = MyPanelRight.markTS[1];
				MyPanelRight.box3 = MyPanelRight.markTS[2];
				
				MyFrame.unEnableCom();
				MyPanelRight.myJB.setEnabled(true);
				
				
				MyFrame.enableCom();
			}
		});
//		change.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		delect.addMouseListener(new MouseListener() {
			
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
				if(!MyPanelRight.hChange)
				{
					color = Color.cyan;
					changeColor();
					getFile(fnID);
				}	
			   
//			   System.out.println("is Entered");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				MyFrame.deletePaint = true;
				try {
					DataProcess.changeToCache();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					DataProcess.txtToXML(DataProcess.pathData+"\\imgCache.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!MyFrame.rList.isEmpty())
				{
					System.out.println("����ִ����");
					MyFrame.rList.clear();
					ReloadData.rMarkL.clear();
				}
				MyPanelRight.reLook();
				System.out.println(MyFrame.rList);
				System.out.println(ReloadData.rMarkL);
//				MyFrame.pP.repaint();

//				System.out.println(MyFrame.PictureNum);
				MyFrame.mPLB.openAll();
				MyFrame.mPLB.changeBC();
				MyFrame.deletePaint = false;
			}
		});
//		delect.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
	}
	//��ʼ�������������״̬��
	public void init_tester(){
		wrong = new JButton("����");
		wrong.setBounds(98, 1, 38, 23);
		wrong.setFont(new Font("΢���ź�",1,12));
		wrong.setMargin(new Insets(0,0,0,0));
		this.add(wrong);
		errorP = new JLabel(); 
		errorP.setBounds(138, 1, 38, 23);
		this.add(errorP);
		wrong.addMouseListener(new MouseListener() {
			
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
				if (FileRead.wrongObjNuum[MyFrame.PictureNum] == 0  )
				{
					ModelProcess.haveZero = true;

				}
				try {
					ModelProcess.writeToWrong();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!ischeck){
					turnWrong();		
					ModelProcess.pointObj[fnID]++;
					++FileRead.wrongObjNuum[MyFrame.PictureNum];
					
					if (FileRead.wrongObjNuum[MyFrame.PictureNum] >= 1 )
						MyPanelLeTop.changeWR();
					ModelProcess.errorFlag = true;
					ModelProcess.curFilename = MyFrame.newOnePicName;
					FileRead.leaveObjNum[MyFrame.PictureNum] = ModelProcess.curMiss;
					
					ModelProcess.haveZero = false;

//					ModelProcess.errorObject = FileRead.wrongObjNuum[FileRead.idFromName(ModelProcess.curFilename)];
//					ModelProcess.sumObject = ReloadData.rMarkL.size() - ModelProcess.errorObject;
					if(MyFrame.notOpen)
					{
						try {
							ModelProcess.savePassData();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						if(MainFrame.checkSta == 1)
						{
							try {
								ModelProcess.saveNoPassData();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else
						{
							try {
								ModelProcess.saveNoPassDataGo();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						try {
							ModelProcess.savePassData();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
					try {
						ModelProcess.writeTorobjnum();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					CalcExchange.calcFinishShow();
//					try {
//						CalcExchange.useCopy();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
					ModelProcess.errorFlag = false;
				}
				else
				{
					errorP.setIcon(null);
					wrong.setText("����");
					ischeck =false;
					ModelProcess.pointObj[fnID]+=10;
					--FileRead.wrongObjNuum[MyFrame.PictureNum];
					System.out.println("FileRead.wrongObjNuum[MyFrame.PictureNum]**1:" + FileRead.wrongObjNuum[MyFrame.PictureNum]);
					//FileRead.rObjNum[MyFrame.PictureNum][fnID] = 0;

					
						
					ModelProcess.errorFlag = true;
					ModelProcess.curFilename = MyFrame.newOnePicName;

//					ModelProcess.errorObject = FileRead.wrongObjNuum[FileRead.idFromName(ModelProcess.curFilename)];
//					ModelProcess.sumObject = ReloadData.rMarkL.size() - ModelProcess.errorObject;
//					try {
//						if (FileRead.wrongObjNuum[MyFrame.PictureNum] == 0){
//							ModelProcess.haveZero = true;
//						}
//						ModelProcess.writeToWrong();
//						ModelProcess.haveZero = false;
//					} catch (IOException e3) {
//						// TODO Auto-generated catch block
//						e3.printStackTrace();
//					}
					if(MyFrame.notOpen)
					{
						if(MainFrame.checkSta == 1)
						{
							try {
								ModelProcess.saveNoPassData();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else
						{
							try {
								ModelProcess.saveNoPassDataGo();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						try {
							ModelProcess.savePassData();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
//						MyFrame.notOpen = false;
						
					}
					
					CalcExchange.calcFinishShow();
//					try {
//						CalcExchange.useCopy();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					try {
//					if( ModelProcess.curMiss == 0)
//					{
//					if (FileRead.wrongObjNuum[MyFrame.PictureNum] == 0){
//						ModelProcess.haveZero = true;
//					}
//					ModelProcess.writeToWrong();
//					ModelProcess.haveZero = false;
					ModelProcess.writeTorobjnum();
					}catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					System.out.println("FileRead.wrongObjNuum[MyFrame.PictureNum]**2:" + FileRead.wrongObjNuum[MyFrame.PictureNum]);
					if (FileRead.wrongObjNuum[MyFrame.PictureNum] == 0 && ModelProcess.curMiss == 0 )
					{
//						CalcExchange.calcFinishShow();
//						ModelProcess.haveZero = true;
						MyPanelLeTop.changeGL();
					}
					ModelProcess.errorFlag = false;
				}
			}
		});
//		wrong.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
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
	//��ʼ����ť����¼�_1
	public void Double(int k){
		
	}
	
	//���ð�ť���ܵ��
	public void unBtn(){
		delect.setEnabled(false);
		change.setEnabled(false);
	}
	//���ð�ť���Ե��
	public void abBtn(){
		delect.setEnabled(true);
		change.setEnabled(true);
	}
	//��ͼƬ��Ϊwrong
	public void turnWrong(){
		errorP.setIcon(new ImageIcon(ObjectName.class.getResource("/image/wrong.png")));
		wrong.setText("����");
		ischeck = true;
	}
}

