package jsp_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadFileEncoding {

    public static void main(String[] args) {
//        File file = new File("D:/Temp/Info.xml");
    	File file=new File("d:/user.frm");
        try {
            FileReader fileReader = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(file),
                    fileReader.getEncoding());
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            String xml = sb.toString();
            System.out.println("�ļ��������ǣ�\n" + xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
