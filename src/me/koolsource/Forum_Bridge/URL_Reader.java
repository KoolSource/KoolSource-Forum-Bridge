/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.koolsource.Forum_Bridge;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author john
 */
public class URL_Reader {

    private HashMap<String, String> returnArray;

    public static Object requestYAML(String aString, Map<String, String> arguments) throws IOException {

        Set keys = arguments.keySet();
        Iterator keyIter = keys.iterator();
        String data = "";
        for (int i = 0; keyIter.hasNext(); i++) {
            Object key = keyIter.next();
            if (i != 0) {
                data += "&";
            }
            data += key + "=" + URLEncoder.encode(arguments.get(key), "UTF-8");
        }

        URL url = new URL(aString);
        URLConnection con = url.openConnection();
        con.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());

        wr.write(data);
        wr.flush();

        Pattern p = Pattern.compile("text/plain;\\s+charset=([^\\s]+)\\s*");
        Matcher m = p.matcher(con.getContentType());
        String charset = m.matches() ? m.group(1) : "ISO-8859-1";
        Reader r = new InputStreamReader(con.getInputStream(), charset);
        StringBuilder buf = new StringBuilder();
        while (true) {
            int ch = r.read();
            if (ch < 0) {
                break;
            }
            buf.append((char) ch);
        }
        String yaml_raw = buf.toString();

        Yaml yaml_parser = new Yaml();

        Object yaml_object = yaml_parser.load(yaml_raw);

        return yaml_object;
    }
}
