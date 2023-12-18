package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileChecker {
    public static void checkFiles(String path1, String path2){
        try{
            File file1 = new File(path1);
            File file2 = new File(path2);

            Character[] text1 = convertToCharArray(file1);
            Character[] text2 = convertToCharArray(file2);

            int count = 0;
            boolean printSyms = true;
            for(int i = 0; i < Math.min(text1.length, text2.length); i++){
                if (!text1[i].equals(text2[i])){
                    count++;
                    if (printSyms) System.out.println("Index: " + i + " - " + text1[i] + " != " + text2[i]);
                }
                if (count > 100){
                    if (printSyms) System.out.println("Слишком много несовпадений!");
                    printSyms = false;
                }
            }
            if (text1.length != text2.length){
                count += Math.max(text1.length, text2.length) - Math.min(text1.length, text2.length);
            }

            System.out.println("Общее количество несовпадений: " + count);

        } catch (FileNotFoundException e){
            System.out.println("Ошибка открытия файлов. Попробуйте еще раз");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Character[] convertToCharArray(File file) throws IOException {
        ArrayList<Character> result = new ArrayList<>();
        FileInputStream input = new FileInputStream(file);

        int c;
        while ( (c = input.read()) != -1) {
            result.add((char)c);
        }
        return result.toArray(new Character[0]);
    }
}
