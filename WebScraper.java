import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WebScraper {
    public static void main(String[] args) throws IOException {
        String url = "https://www.bbc.com";
        System.out.println("Scraping: "+ url);

        BasicWebdata basicData = scrapeBasicdata(url);
        System.out.println(basicData.toString());

        List<NewsArticle> articles = scrapeNewsArticles(url);
        System.out.println("\nTop Headlines:\n");
        for (NewsArticle article : articles) {
            System.out.println(article);
        }

    }


    public static BasicWebdata scrapeBasicdata(String url) throws IOException{

    	Document doc = Jsoup.connect(url).get();
    	BasicWebdata data = new BasicWebdata();

    	data.setTitle(doc.title());

    	 for (Element heading : doc.select("h1, h2, h3, h4, h5, h6")) {
             data.addHeading(heading.text());
         }

         for (Element link : doc.select("a[href]")) {
             data.addLink(link.absUrl("href"));
         }

         return data;
    }

    public static List<NewsArticle> scrapeNewsArticles(String url) throws IOException {
        List<NewsArticle> articles = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();


        Elements headlines = doc.select("h3, h2");

        for (Element h : headlines) {
            String headline = h.text();
            String author = "BBC News";
            String date = new Date().toString();

            articles.add(new NewsArticle(headline, author, date));
        }

        return articles;
    }
}
