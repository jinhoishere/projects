import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int count = 0; // the number of links taken to reach the first URL from the last one 
    private static ArrayList<Page> pages = new ArrayList<>(); // # of pages by user input
    private static ArrayList<String> urls = new ArrayList<>(); // links that lead to next page
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Give me any URL to start: ");
        String currentURL = scnr.next();
        System.out.print("How many pages you want to set: ");
        int userNumPage = scnr.nextInt();
        System.out.println("");
        
        checkInputValidity(userNumPage, scnr);

        print("> Fetching %s...", currentURL);
        System.out.println("");   
        
        // create # of pages
        for (int i = 0; i < userNumPage; i++) {
            Page p = new Page();
            pages.add(p);
        }
        // assign all fields of the pages
        for (int i = 0; i < userNumPage; i++) {
            urls.add(currentURL);
            Page currentPage = pages.get(i);
            currentPage.setURL(currentURL);
            try {
                currentPage.extractLinksFrom(currentURL);    
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("There's an error in fetching given URL. Try again with the same URL or a new one.");
                System.exit(0);
            }
            ArrayList<String> currentLinks = currentPage.getLinks();
            currentPage.setPathLink(currentLinks);
            currentURL = currentPage.getPathLink();
        }
        
        displayGoals(urls);
        
        // Display links of the last page first and links of the first page last.
        int currentIndex = userNumPage - 1;
        while (currentIndex >= 0) {
            Page currentPage = pages.get(currentIndex);
            System.out.println("> Display links in the page (" + 
                                (userNumPage - currentIndex) + "/" + userNumPage + ")." + 
                                " Your current score is " + count + ".");
            displayLinksOf(currentPage);
            System.out.print("\nGive a corresponding number of URL to move on to next page (1-30): ");
            int userInput = scnr.nextInt();
            String userAnswer = currentPage.getLinks().get(userInput-1);
            String correctAnswer = urls.get(currentIndex);
            if (userAnswer.equals(correctAnswer)) {
                if (currentIndex == 0) {
                    count += 1;
                    System.out.println("\n<Notice> You tracked all paths of links ! Game ends.");
                    System.out.println("<Your score: " + count + ">");
                    System.exit(0);
                }
                else {
                    count +=1;
                    currentIndex -= 1; // move on to the next page (down)
                    System.out.println("<Notice> You got it! Move on to next page.\n");
                }
            }
            else {
                count += 1;
                System.out.println("<Notice> That link is not a path to another. Try again.\n");
            }
        }
    }

    // a method to check if user input is valid or not
    public static void checkInputValidity(int userNumPages, Scanner scnr) {
        while (userNumPages < 2) {
            System.out.println("Pages(rounds) should be at least 2. Try again.");
            System.out.print("How many pages(rounds) you want to set? ");
            userNumPages = scnr.nextInt();
            System.out.println("");
        }
    }

    // a library built-in method from jsoup library
    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    // a method to display starting and ending links from random links
    public static void displayGoals(ArrayList<String> randLinks) {
        String starting_url = randLinks.get(0);
        String ending_url = randLinks.get(randLinks.size()-1);
        System.out.println("> Track back pages by finding a link that leads to next page. \n" +
                            "> Your first choice will be <" + ending_url + ">, \n" +
                            "> And the last choice will be <" + starting_url + ">\n");
    }

    // a method to display extracted links of the page
    public static void displayLinksOf(Page p) {
        for (int i = 0; i < p.getLinks().size(); i++) {
            System.out.println((i+1) + ". " + p.getLinks().get(i));
        }
    }
}