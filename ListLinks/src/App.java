import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<Page> pages = new ArrayList<>();
        ArrayList<String> answerLinks = new ArrayList<>(); // key links that are used to be selected

        Scanner scnr = new Scanner(System.in);
        System.out.print("Give me any URL to start: ");
        String url = scnr.next(); // https://en.wikipedia.org/wiki/Russian_invasion_of_Ukraine
        System.out.print("How many rounds(pages) you want to play? ");
        int numPages = scnr.nextInt();

        print("Fetching %s...", url);
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        //     System.out.println(e);
        // }
                
        // create # of pages with default settings
        for (int i = 0; i < numPages; i++) {
            Page p = new Page();
            pages.add(p);
        }
        // assign fields of all pages with variables
        for (int i = 0; i < numPages; i++) {
            answerLinks.add(url);
            Page currentPage = pages.get(i);
            currentPage.setURL(url);
            currentPage.setLinksFrom(url);
            Elements currentLinks = currentPage.getLinks();
            currentPage.setRandomLinkAmong(currentLinks);
            url = currentPage.getRandomLink();
        }
        
        System.out.println("");
        System.out.println("Starting URL: " + answerLinks.get(0));
        System.out.println("Ending URL: " + answerLinks.get(answerLinks.size() - 1));

        // TODO1: Trim each page to have only 50 links
        // TODO2: what to display?

        // for (Page r : pages) {
        //     System.out.println(r.getURL());
        //     System.out.println(r.getRandomLink());
        //     System.out.println("");
        // }

        // for (String u : answerLinks) {
        //     System.out.println(u);
        // }
        
        for (int i = 0; i < pages.get(0).getLinks().size(); i++) {
            System.out.println(pages.get(0).getLinks().get(i));
        }
 
        // for (Element link : r.getLinks()) {
        //     print(" * <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        // }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    // private static String trim(String s, int width) {
    //     if (s.length() > width)
    //         return s.substring(0, width-1) + ".";
    //     else
    //         return s;
    // }
}