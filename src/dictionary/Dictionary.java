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

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Игорь
 */
public class Dictionary {
    private static List[] dictionary = new List[2];
    private static int i = 0;
    
    private static List[] getDictionary(String dictPath){
        try {
            dictionary = FileWorker.read(dictPath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dictionary;
    }

    /**
     *
     * @author Виталий Зданевич
     * @param lang Языковая пара ("en-ru") или только язык ответа ("ru")
     * @param input Слово для перевода на английском языке (при использовании в других проектах метод может определять язык ввода(английский или русский) автоматически).
     * @return Перевод слова.
     * @throws IOException
     * @see <a href = "https://habrahabr.ru/post/261259/">Источкик кода метода yandexTranslate на HabraHabr</a>
     */
    public static String yandexTranslate(String lang, String input) throws IOException {
		//my translate api key
                String urlStr = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20160830T202008Z.dca20e7c532187a4.b563037b8a5b88bbeef003b16684365989a69a16";
		URL urlObj = new URL(urlStr);
		HttpsURLConnection connection = (HttpsURLConnection)urlObj.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
                dataOutputStream.writeBytes("&text=" + input + "&lang=" + lang + "&format=plain");
		InputStream response = connection.getInputStream();
		String json = new java.util.Scanner(response).nextLine();
                int start = json.indexOf("[");
		int end = json.indexOf("]");
		String translated = new String(json.substring(start + 2, end - 1).getBytes(), "UTF-8");
                i++;
		if (translated.equals(input) && i < 2) {
			// if return equal of entered text - we need change direction of translation
			return yandexTranslate("en", input);
		} else return translated;
	}
    
    /**
     *
     * @param EngReadTextField Объект JTextField, содержащий слово для перевода
     * @param RusReadTextField Объект JTextField, где будет показан перевод
     * @param RusReadLabel Объект JLabel с комментариями к ходу работы программы
     */
    public static String localTranslate(javax.swing.JTextField EngReadTextField, javax.swing.JTextField RusReadTextField, javax.swing.JLabel RusReadLabel) throws IOException {
        dictionary = getDictionary("./wordPair.txt");
        List<String> engList = dictionary[0];
        List<String> rusList = dictionary[1];
        String searchWord = EngReadTextField.getText();
        int searchIndex;
        if (engList.contains(searchWord)) {
            RusReadLabel.setText("Возможный вариант перевода");
            searchIndex = engList.indexOf(searchWord);
            return rusList.get(searchIndex);
        } else if(!searchWord.equals("")) {
            RusReadLabel.setText("Перевод от Yandex Translate");
            return yandexTranslate("ru", EngReadTextField.getText());
        } else {
            RusReadLabel.setText("Поле ввода не может быть путым");
            return "";
        }       
    }
    
    /**
     *
     * @param EngAddTextField Поле исходного слова на английском
     * @param RusAddTextField Поле перевода на русском
     * @param EngAddWordLabel Пояснения к английским словам
     * @param RusAddWordLabel Пояснения к русским словам
     */
    public static void addWordToLocDic(javax.swing.JTextField EngAddTextField, javax.swing.JTextField RusAddTextField, javax.swing.JLabel EngAddWordLabel, javax.swing.JLabel RusAddWordLabel) {
        try {
            dictionary = FileWorker.read("./wordPair.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        EngAddWordLabel.setText("Input english word.");
        RusAddWordLabel.setText("Введите перевод английского слова.");
        String engAddWord = EngAddTextField.getText();
        String rusAddWord = RusAddTextField.getText();
        String wordPair = "";
        if (engAddWord.isEmpty()) {
            EngAddWordLabel.setText("This field can't be empty.");
        }
        if (rusAddWord.isEmpty()) {
            RusAddWordLabel.setText("Это поле не может быть пустым.");
            if (dictionary[0].toString().contains(engAddWord)) {
                EngAddWordLabel.setText("Dictionary already have this word.");
                RusAddWordLabel.setText("Это слово уже есть в словаре.");
            }
        }
        if (dictionary[0].toString().contains(engAddWord)) {
            EngAddWordLabel.setText("Dictionary already have this word.");
            RusAddWordLabel.setText("Это слово уже есть в словаре.");
        }
        if (!engAddWord.isEmpty() && !rusAddWord.isEmpty())
        {
            if (!dictionary[0].toString().contains(engAddWord)) {
                wordPair = wordPair.concat(engAddWord);
                wordPair = wordPair.concat("|");
                wordPair = wordPair.concat(rusAddWord);
                wordPair = wordPair.concat("\n");

                FileWorker.write("./wordPair.txt", wordPair);
                EngAddWordLabel.setText("Input english word.");
                RusAddWordLabel.setText("Введите перевод английского слова.");
                EngAddTextField.setText("");
                RusAddTextField.setText("");
            } else {
                EngAddWordLabel.setText("Dictionary already have this word.");
                RusAddWordLabel.setText("Это слово уже есть в словаре.");
            }
        }
    }
}
