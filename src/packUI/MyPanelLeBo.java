package packUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import packData.ModelProcess;

//���½ǵ�JPanel
public class MyPanelLeBo extends JPanel{
	public static LBList lblist;
	private JScrollPane jP;
	//���캯��
	public MyPanelLeBo(){
		if(MainFrame.workerType) initMPLBMark();
//		else initMPLBCheck();
		this.setVisible(true);
	}
	//��ʼ����ǰֵ(���ģʽ)
	public void initMPLBMark(){
		this.setBackground(new Color(0xCCCCCC));
		this.setBounds(0, ATP.leftTopH+5, ATP.leftW, ATP.leftBotH);
		this.setLayout(null);
	}
	//��ʼ����ǰֵ�����ģʽ��
	public void initMPLBCheck(){
		this.setBackground(new Color(0xCCCCCC));
		this.setBounds(0, ATP.leftTopH+5, ATP.leftW, ATP.leftBotH - 20);
		MyPanelRight.comMiss = new JComboBox<>();
//		JLabel missLabel = new JLabel("ѡ��©������");
		for(int i = 0; i < 20; i++)
		{
			MyPanelRight.comMiss.addItem(i);
		}
		MyPanelRight.comMiss.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				String temp = (String);
				ModelProcess.errorFlag = true;
				MyPanelRight.missNum = (int) MyPanelRight.comMiss.getSelectedItem();
				if(MyPanelRight.missNum != 0)
				{
//					try {
//						ModelProcess.line2IsNull();
//						ModelProcess.passToTxt();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
				}
				
			}
		});
//		MyFrame.mPR.add(missLabel);
		this.add(MyPanelRight.comMiss);
//		missLabel.setBounds(5, 80, 140, 20);
//		missLabel.setFont(new Font("����",1,11));
		MyPanelRight.comMiss.setBounds(5, 100, 140, 20);
		this.setLayout(null);
	}
	//���ɹ��������
	public void openAll(){
		if( jP != null ) this.remove(jP);
		lblist = new LBList(){
			@Override
			public void getOneRec(int k) {
				// TODO Auto-generated method stub
				super.getOneRec(k);
				getOneRect(k);
			}
			
			@Override
			public void edited(int k) {
				// TODO Auto-generated method stub
				super.edited(k);
				edit(k);
			}
			
			@Override
			public void deleted(int k) {
				// TODO Auto-generated method stub
				super.deleted(k);
				delete(k);
			}
			
		};
		
		
		jP = new JScrollPane(lblist);
		if(MainFrame.workerType) jP.setSize(ATP.leftW,ATP.leftBotH);
		else jP.setSize(ATP.leftW,ATP.leftBotH-20);
		jP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(jP);
		this.setVisible(true);
		this.updateUI();
		
	}
	//��ȡ��ǰ�������_3
	public void getOneRect(int k){
		
	}
	//�༭����_2
	public void edit(int k){
		
	}
	//ɾ������_2
	public void delete(int k){
		
	}
	//�ı䵱ǰ����ı�����ɫ
	public void changeBC(){
	
		if(lblist.getComponentCount()>MyFrame.ObjectNum && lblist.getComponentCount()>MyFrame.ObjectNumF )
		{
			Object obj = lblist.getComponent(MyFrame.ObjectNumF);
			if(obj instanceof ObjectName){
				ObjectName ON = (ObjectName)obj;
				ON.init();
			}
			
			obj = lblist.getComponent(MyFrame.ObjectNum);
			if(obj instanceof ObjectName){
				ObjectName ON = (ObjectName)obj;
				ON.BC();
			}
			
		}
	}
	//ʹ����ڰ�ť�Բ�����
	public static void unAllBtn()
	{
		if(lblist.getComponentCount() > 0)
		{
			for(int i=0; i<lblist.getComponentCount(); i++ )
			{
				Object obj = lblist.getComponent(i);
				if(obj instanceof ObjectName){
					ObjectName ON = (ObjectName)obj;
					ON.unBtn();
				}
			}
		}
	}
	
	//ʹ����ڰ�ť����
	public static void abAllBtn()
	{
		if(lblist.getComponentCount() > 0)
		{
			for(int i=0; i<lblist.getComponentCount(); i++ )
			{
				Object obj = lblist.getComponent(i);
				if(obj instanceof ObjectName){
					ObjectName ON = (ObjectName)obj;
					ON.abBtn();
				}
			}
		}
	}
	
}
