/**
 * 
 */
package dataSQL;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import bin.ArraylistStudent;

/**
 * @author Heretic
 *
 * UNSC
 */
public class TextOutput {
	public static final String OUTPUT_FILE = "C:\\Documents\\data.txt";
	public static final String HEADER_FILE = "Danh sach thi sinh";
	public static boolean writeData(String _fileName, ArraylistStudent _list){
		try {
			File file = new File(_fileName);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(HEADER_FILE);
			if (_list != null){
				for (int i =1; i<_list.getsList().size();i++){
					String data = _list.getStudent(i).toString();
					bw.write(data);
				}
			}
			bw.write("\n\nClose");
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static String updateFileName(String fileName){		
		String[] temp = fileName.split("[/.]");		
		if (temp.length<2){
			fileName = fileName + ".txt";
		}
		return fileName;
	}
}
