package packUI;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JPanel;

import packData.ModelProcess;
import packData.ReloadData;

public class WrongList extends JPanel {
	public static int mount = 0;			//ͼƬ�ļ�������
	public int i;							//��i�����
	public int max = 0;
	//���캯��
	public WrongList() {				
		// TODO Auto-generated constructor stub
		initThis();
		filein();
		this.setVisible(true);
	}
	//�����ļ���Ŀ�������Ӧ�����
	public void filein(){
		mount =  ModelProcess.listWrongMess.size();//�ļ���Ŀ
		this.initThis();
		for( i=0; i<mount; i++){
			String text = ""; //�ı�����
			String[] temp = ModelProcess.listWrongMess.get(i).split(" ");
			text += "�ļ�����"+temp[0] + "©��������"+temp[3]+"�����ţ�";
			for(int i = 5; i < temp.length; i++){
				text += temp[i] + " ";
			}
			WrongMassage WM = new WrongMassage(i, text){
				@Override
				public void getFile(int k) {
					// TODO Auto-generated method stub
					super.getFile(k);
					getfile(k);
				}
			};
			if((text.length()*11) > max) max = ( text.length()*11);
			WM.setSize(text.length()*11,ATP.objectH);
//			//�������ֵ�������λ��
			WM.setLocation(0,i*ATP.objectH);
			this.add(WM);	
		}
		//�������������FileContent���ó�ʼ��С
		this.setPreferredSize(new Dimension(max,i*ATP.objectH+5));
		this.repaint();
	}
	
	//��ȡ��ǰ����ĺ���_2
	public void getfile(int k){
		
	}
	//��ʼ����ǰ���趨
	public void initThis(){
		this.setPreferredSize(new Dimension(ATP.leftW-10,ATP.leftBotH-15));
		this.setLayout(null);
	}
}
