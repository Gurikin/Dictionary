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

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author Игорь
 * @see <a href = "https://habrahabr.ru/post/261259/">Источкик кода</a>
 */
public class YandexTranslate {
    private static int i = 0;
	public static String translate(String lang, String input) throws IOException {
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
                FileWorker.write("./report.txt", json);
		int start = json.indexOf("[");
		int end = json.indexOf("]");
		String translated = json.substring(start + 2, end - 1);
		i++;
		if (translated.equals(input) && i < 2) {
			// if return equal of entered text - we need change direction of translation
			return translate("en", input);
		} else return translated;
	}
}
