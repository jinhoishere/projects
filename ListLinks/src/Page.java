import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Page {
    // fields
    private String url; // a URL of the current page
    private ArrayList<String> links; // extracted 30 links from "this.url"
    private String pathLink; // a randomly picked link among "links" to create a url of next page

    // default constructor
    public Page() {
        
    }


    public void setURL(String url) {
        this.url = url;
    }

    public String getURL() {
        return this.url;
    }

    // extract links on a page of the given URL
    public void extractLinksFrom(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements original_links = doc.select("a[href]");
        ArrayList<String> abs_links = new ArrayList<>();
        // pick first 30 links from the top
        // if the page has less than 30, pick all links
        if (original_links.size() < 30) {
            for (int i = 0; i < original_links.size(); i++) {
                Element currentLink = original_links.get(i);
                String absHref = currentLink.attr("abs:href");
                abs_links.add(absHref);
            }
        }
        else {
            for (int i = 0; i < 30; i++) {
                Element currentLink = original_links.get(i);
                String absHref = currentLink.attr("abs:href");
                abs_links.add(absHref);
            }
        }
        this.links = trimmed(abs_links);
        Collections.shuffle(this.links);
    }

    public ArrayList<String> getLinks() {
        return this.links;
    }

    // pick a random link among 30 links on that page
    public void setPathLink(ArrayList<String> links) {
        Random randGen = new Random();
        int randNum = randGen.nextInt(links.size());
        String randLink = links.get(randNum);
        this.pathLink = randLink;
    }

    public String getPathLink() {
        return this.pathLink;
    }

    // a method to remove "#bodyContent" from the first link
    public ArrayList<String> trimmed(ArrayList<String> absLinks) {
        String s = absLinks.get(0);
        String modified_s = s.substring(0, s.length()-12);
        absLinks.set(0, modified_s);
        return absLinks;
    }
}
