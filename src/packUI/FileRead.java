package packUI;
import java.io.File;
import java.util.ArrayList;

import packData.ModelProcess;

//�ļ���ȡ���
public class FileRead {
	 public static int[] wrongObjNuum;	//����Ŀ�����
	 public static int[] leaveObjNum;		//©��Ŀ�����
	 
//	 public static int [][] rObjNum;
	 private static ArrayList<String> filelist = new ArrayList<String>();		//�ļ�·�����б�
	 public static ArrayList<String> flienamelist = new ArrayList<String>(); //�ļ����Ƶ��б�
	 public void readAll(String boom){

	    String filePath = boom;
	    getFiles(filePath);
	 }
	    /*
	     * ͨ���ݹ�õ�ĳһ·�������е�Ŀ¼�����ļ�
	     */
	    static void getFiles(String filePath){
		     File root = new File(filePath);
			       File[] files = root.listFiles();
			       for(File file:files){     
				        if(file.isDirectory()){
				         /*
				          * �ݹ����
				          */
				        	getFiles(file.getAbsolutePath());
				         //System.out.println("��ʾ"+filePath+"��������Ŀ¼�����ļ�"+file.getAbsolutePath());
				        }
				        else{
				        	
				        	String s = file.getAbsolutePath();
				        	//System.out.println(s.endsWith(".jpg") + " " + s.endsWith(".png") );
				        	if( s.endsWith(".jpg")  || s.endsWith(".png") || s.endsWith(".PNG") || s.endsWith(".JPG") )
				        	{
//				        		if(ModelProcess.checkNoName(file.getName())){
				        			flienamelist.add(file.getName());
					        		filelist.add(file.getAbsolutePath());
//				        		}
				        		
				        		
				        	//	System.out.println("��ʾ"+filePath+"��������Ŀ¼"+file.getAbsolutePath());
				             }
				        }  
			       }
			       wrongObjNuum = new int[filelist.size()];
			       leaveObjNum = new int[filelist.size()];
//			       rObjNum = new int[filelist.size()][100];
		    }
		    
	    	//�õ�ָ���ļ���·��
		    public String getOnePic(int i){
		    	return filelist.get(i);
		    }
		    //�õ��ļ�������
		    public int getSize(){
		    	return filelist.size();
		    }
		    //����ļ����
		    public void clearAll(){
		    	filelist.clear();
		    	flienamelist.clear();
		    }
		    //�õ�ָ���ļ�������
		    
		    public String getOneName(int i){
		    	return flienamelist.get(i);
		    }
		    
		    //�����ļ�����ȡ�ļ�ID
		    public static int idFromName(String name){
		    	int i;
		    	for( i=0; i<flienamelist.size(); i++)
		    	{
		    		if(flienamelist.get(i).equals(name)) break;
		    	}
		    	return i;
		    }
}
