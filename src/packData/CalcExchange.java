package packData;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import packUI.MainFrame;
import packUI.MyFrame;

public class CalcExchange {
	
//	public static boolean judgeType;
//	public static int exchNum = 0;
	
//	public static void addEc(){	//��finish.txtд��ģʽ�л��Ĵ���
//		
//		String txtPath = MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto"+"\\unFinish.txt";
//		File fileNP = new File(txtPath);
//		
//		String flagMarkOrCheck = null;
//		if(MainFrame.workerType)
//		{
//			flagMarkOrCheck = "x" + System.getProperty("line.separator");
//		}
//		else{
//			flagMarkOrCheck = "y" + System.getProperty("line.separator");
//		}
//
//		try {
//			FileWriter writern = new FileWriter(fileNP,true);
//			writern.write(flagMarkOrCheck);
//			writern.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	
//	public static boolean judegNPList(){	//�ж�ʲôʱ��snpList��д,ʲôʱ��׷��
//		
//		 int sameNum = 0;
//		 int txtLen = 0;
//		 int arrIndex[] = new int[100];
//		 ArrayList<String> tempList = new ArrayList<>();
//		try{
//			String txtPath = MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto"+"\\unFinish.txt";
//			File file = new File(txtPath);
//			FileReader read = new FileReader(file);
//		    BufferedReader br = new BufferedReader(read);
//		    
//		    
//		    String line = br.readLine();
//		    String sTmp = null;
//		   
//		    while(line != null)
//		    {
//		    	
//		    	tempList.add(line);
//		    	line = br.readLine();
//		    	txtLen++;
//		    }
//		    
//		    for(int i = 1; i < tempList.size(); i++){
//		    	if(!tempList.get(i).equals(tempList.get(i-1))){
//		    		exchNum++;
//		    		arrIndex[exchNum] = i;
//		    	}
//		    }
//		    
//		   
//		    for(int i = tempList.size() - 1; i > 0; i--){
//		    	if(tempList.get(i).equals(tempList.get(i-1))){
//		    		sameNum = i;
//		    		break;
//		    	}
//		    }
//		}catch(IOException e){
//			e.getStackTrace();
//		}
//		if(exchNum == 0)
//			return true;//��д
//		if(exchNum == 1)
//			return true;//��д
//		
//		if(exchNum >= 2 && sameNum == tempList.size() - 1)
//		return true;//����
//		
//		return false;
//	}
//	
	
	
	public static void copyFile(String src,String dest) throws IOException{		//�����Ʒ���������ͼƬ,���ƺ���
        FileInputStream in=new FileInputStream(src);
        File file=new File(dest);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file);
        int c;
        byte buffer[]=new byte[1024];
        while((c=in.read(buffer))!=-1){
            for(int i=0;i<c;i++)
                out.write(buffer[i]);        
        }
        in.close();
        out.close();
    }
	
	
	public static void useCopy() throws IOException{		//����ͼƬ���ƺ���
		
		delDir(DataProcess.pathJPEGImages);
		DataProcess.newJpegFile();
		String txtPath = MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto\\"+ModelProcess.folderName+"_pass.txt";
        File file = new File(txtPath);
        FileReader read = new FileReader(file);
        BufferedReader br = new BufferedReader(read);
        
        String line = br.readLine();
        
		ArrayList<String> srcFile = new ArrayList<>();
		ArrayList<String> destTemp = new ArrayList<>();
		while(line != null)
		{
			srcFile.add(MyFrame.r+"\\"+line.split(" ")[0]);
			destTemp.add(DataProcess.pathJPEGImages+"\\"+line.split(" ")[0]);
			System.out.println("line.split()[0]           "+ line.split(" ")[0]);
			line = br.readLine();
			
		}
		
		for(int i = 0; i < srcFile.size(); i++){
			System.out.println("srcFile.get(i), destTemp.get(i)          :  "+srcFile.get(i)+"   "+ destTemp.get(i));
			copyFile(srcFile.get(i), destTemp.get(i));
		}
		read.close();
		br.close();
	}
	
	
	
	
	 public static void delFile(String path,String filename){		//ɾ�������ļ�����������ɾ��Ŀ¼
         File file=new File(path+"/"+filename);
         if(file.exists()&&file.isFile())
             file.delete();
     }
	
	 public static void delDir(String path){			//ɾ��ָ��Ŀ¼
         File dir=new File(path);
         if(dir.exists()){
             File[] tmp=dir.listFiles();
             for(int i=0;i<tmp.length;i++){
                 if(tmp[i].isDirectory()){
                     delDir(path+"/"+tmp[i].getName());
                 }
                 else{
                     tmp[i].delete();
                 }
             }
             dir.delete();
         }
     }
	
	 public static void calcFinishShow(){		//����ʲôʱ����ʾFinish.txt ʲôʱ����ʾUnfinish,txt
		 
		 try {
				
			String passFilePath = MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto"+"\\"+ModelProcess.folderName+"_pass.txt";
			File fileP = new File(passFilePath);
			FileReader readP;readP = new FileReader(fileP);
	        BufferedReader brP = new BufferedReader(readP);
			
			String txtPath = MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto"+"\\data\\ImgCache.txt";
	        File file = new File(txtPath);
	        FileReader read = new FileReader(file);
	        BufferedReader br = new BufferedReader(read);
	        
	        String line1 = br.readLine();
	        String line2 = brP.readLine();
	        
	        int count1 = 0;
	        int count2 = 0;
	        while(line1 != null){
	        	count1++;
	        	line1 = br.readLine();
	        }
	        
	        while(line2 != null){
	        	count2++;
	        	line2 = brP.readLine();
	        }
	        
	        File fileFinish = new File(MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto"+"\\Unfinish.txt");
			 if(count1 == count2)
			 {
				 if(fileFinish.exists())
					 fileFinish.renameTo(new File(MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto"+"\\Finish.txt"));
				 fileFinish = new File(MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto"+"\\Finish.txt");
			 }
			 else
			 {
				 if(!fileFinish.exists()){
					 fileFinish = new File(MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto"+"\\Finish.txt");
					 fileFinish.renameTo(new File(MyFrame.r+"\\"+ModelProcess.folderName+"_MPhoto"+"\\Unfinish.txt"));
				 }
					 
			 }
			 
			 read.close();
			 readP.close();
			 br.close();
			 brP.close();
			 System.out.println("c1 c2  " + count1+ "   "+count2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
		 
	 }
	 
	 
	 public static void FileAllCopy(String path, String copyPath) throws IOException{		//���������ļ���
		  File filePath = new File(path);
		  DataInputStream read ;
		  DataOutputStream write;
		  if(filePath.isDirectory()){
		   File[] list = filePath.listFiles();
		   for(int i=0; i<list.length; i++){
		    String newPath = path + File.separator + list[i].getName();
		    String newCopyPath = copyPath + File.separator + list[i].getName();
		    File newFile = new File(copyPath);
		    if(!newFile.exists()){
		     newFile.mkdir();
		    }
		    FileAllCopy(newPath, newCopyPath);
		   }
		  }else if(filePath.isFile()){
		   read = new DataInputStream(
		     new BufferedInputStream(new FileInputStream(path)));
		   write = new DataOutputStream(
		     new BufferedOutputStream(new FileOutputStream(copyPath)));
		   byte [] buf = new byte[1024*512];
		   while(read.read(buf) != -1){
		    write.write(buf);
		   }
		   read.close();
		   write.close();
		  }else{
		   System.out.println("��������ȷ���ļ�����·����");
		  }
		 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
