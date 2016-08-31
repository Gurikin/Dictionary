/*
 * Copyright (C) 2016 Игорь
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package dictionary;

import java.io.*;
import java.util.*;

/**
 *
 * @author Igor Banchkov
 */
public class FileWorker {

    /**
     *
     * @param fileName You need to specify a parameter of type string. Full path to the simple text file which you want to use as dictionary database
     * @param text The string which will be written to the file
     */
    public static void write(String fileName, String text) {
        //Определяем файл
        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            FileWriter wrOut = new FileWriter(file, true);
            //PrintWriter out;
            //out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст в файл
                //out.print(text);
                //out.write(text);
                wrOut.write(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                //out.close();
                wrOut.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param fileName You need to specify a parameter of type string. Full path to the simple text file with word pair
     * @return List of word pair
     * @throws FileNotFoundException Return the exception if the file not found
     */
    public static List[] read(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        //StringBuilder sb = new StringBuilder();
        List<String> engList = new ArrayList<>();
        List<String> rusList = new ArrayList<>();
        List[] result = new List[2];
        String[] splitStr;
        
        File file = exists(fileName);
        
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    //sb.append(s);
                    //sb.append("\n");
                    splitStr = s.split("\\|");
                    engList.add(splitStr[0]);
                    rusList.add(splitStr[1]);
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        result[0] = engList;
        result[1] = rusList;
        //Возвращаем полученный текст с файла
        //return sb.toString();
        return result;
    }

    private static File exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
        return file;
    }
}
