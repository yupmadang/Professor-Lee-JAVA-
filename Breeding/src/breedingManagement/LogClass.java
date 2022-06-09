package breedingManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
//�α� ������ �����ϱ� ���� Ŭ����
public class LogClass implements Serializable {

	private static final long serialVersionUID = 7429624065897161851L;
	FileHandler fileHandler;
	LogManager logManager;
	Logger logger;
	//��������Ʈ�� ������ ������ ������
	private static LinkedList<AliveInsect> Info_Name = new LinkedList<>();
	private static LinkedList<DryInsect> Info_DryInsect = new LinkedList<>();
	
	//��������Ʈ�� ȣ���ϴ� �޼���
	public LinkedList<AliveInsect> getINList(){
		return Info_Name;
	}
	public LinkedList<DryInsect> getDIList(){
		return Info_DryInsect;
	}
	
	public LogClass(String fileName) {
		try {
			logManager = LogManager.getLogManager();
			logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
			fileHandler = new FileHandler(fileName);
			logger.addHandler(fileHandler);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//�α׿� ������ �����ϴ� �޼���
	public void log(String logMassage) {
		logger.info(logMassage);
	}
	//����ȣ��޼���: ������ ����� ������ ���α׷��� ���۽� ȣ��
	public void getObject() {
		FileInputStream file;
		try {
			//��������Ʈ�� ��ü�� �ҷ���
			file = new FileInputStream("Breeding.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			Info_Name = (LinkedList<AliveInsect>)in.readObject();
			Info_DryInsect = (LinkedList<DryInsect>)in.readObject();
			in.close();
			file.close();
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//���ϻ����޼��� : ������Ʈ�� ����Ǹ� ������Ʈ
		public void PutObject() { 
			try {
				//��������Ʈ�� ��ü�� ����
				FileOutputStream file1 = new FileOutputStream("Breeding.txt");
				ObjectOutputStream out = new ObjectOutputStream(file1);
				out.writeObject(Info_Name);
				out.writeObject(Info_DryInsect);
				
				out.close();
				file1.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}