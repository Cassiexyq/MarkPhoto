package packUI;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import packData.ModelProcess;
import packData.ReloadData;

//���ObjectName������б�
public class LBList extends JPanel {
	public int mount;		//���������Ŀ
	public int i;			//��i������
	//���캯��
	public LBList() {
		// TODO Auto-generated constructor stub
		initThis();
		filein();
		this.setVisible(true);
	}
	
	//��ȡ������Ŀ������Ӧ����
	public void filein(){
		try {
			if(ReloadData.canCheck())
			{
				mount = MyFrame.rList.size();
		//		System.out.println("rList size is :"+mount);
			}
			else
			{
				mount =  MyFrame.list.size();
		//		System.out.println("list size is :"+mount);
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		mount =  MyFrame.rList.size();
		this.initThis();
		for( i=0; i<mount; i++){
			String text = "Object " + (i+1) ;
//			System.out.println(text);
			ObjectName ON = new ObjectName(text,i){
				
				@Override
				public void getFile(int k) {
					// TODO Auto-generated method stub
					super.getFile(k);
					getOneRec(k);
				}
				
				@Override
				public void Double(int k) {
					// TODO Auto-generated method stub
					super.Double(k);
					final int c = k;
					change.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							edited(c);
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
							
						}
					});
					
					delect.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							deleted(c);
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
							
						}
					});
				}
				
			};
			ON.setSize(ATP.leftW,ATP.objectH);
			ON.setLocation(0, i*ATP.objectH);
		
			if(!MainFrame.workerType){
				try {
					ModelProcess.writeTorobjnum();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(ModelProcess.rObjNum[i] == 1)
				ON.turnWrong();
			}
			//if(!MainFrame.workerType && (FileRead.rObjNum[MyFrame.PictureNum][i] == 1))
			//ON.turnWrong();
			this.add(ON);
		}
	
		this.setPreferredSize(new Dimension(ATP.leftW,i*ATP.objectH+15));
		this.repaint();
	}  
	
	//��ʼ����ǰ���
	public void initThis(){
		if(MainFrame.workerType) this.setPreferredSize(new Dimension(ATP.leftW, ATP.leftBotH-15));
		else this.setPreferredSize(new Dimension(ATP.leftW, ATP.leftBotH-35));
		this.setLayout(null);
	}
	
	//��ȡ��ǰ����ĺ���_2
	public void  getOneRec(int k){
		
	}
	//�༭����_1
	public void edited(int k){
		
	}
	//ɾ������_1
	public void deleted(int k){
		
	}
//	public void isWrong(){
//		int m;
//		Object obj = null;
//		ObjectName ON = null;
//		for( m=0; m<FileRead.wrongObjNuum[MyFrame.PictureNum]; m++ )
//		{
//			obj = this.getComponent(ModelProcess.rObjNum[m]);
//			if( obj instanceof ObjectName)
//			{
//				ON = (ObjectName)obj;
//				ON.turnWrong();
//			}
//		}	
//	}
}
