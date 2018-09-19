import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] unused) {
        int count = 0;
        String a = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] parts = a.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("Prince") || parts[i].equals("prince")) {
                count++;
            }
        }

        System.out.println(count);
        // System.out.print(urlToString(unused));
    }


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
