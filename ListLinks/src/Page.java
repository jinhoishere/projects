import java.io.IOException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Page {
    // fields
    private String url; // a URL of the current page
    private Elements links; // extracted 50 links on the current page
    private String randLink; // a random link among 50 links on the current page

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
    public void setLinksFrom(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements origianl_links = doc.select("a[href]");
        // only picks first 50 links from the top
        for (int i = 0; i < 50; i++) {
            Element new_link = origianl_links.get(i);
            String absHref = new_link.attr("abs:href");
        }
        this.links = origianl_links;
    }

    public Elements getLinks() {
        return this.links;
    }

    // pick a random link among links on that page
    public void setRandomLinkAmong(Elements links) {
        Random randGen = new Random();
        int randNum = randGen.nextInt(links.size()) + 1;
        Element link = links.get(randNum);
        String absHref = link.attr("abs:href");
        this.randLink = absHref;
    }

    public String getRandomLink() {
        return this.randLink;
    }
}
