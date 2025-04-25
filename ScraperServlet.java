import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScraperServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String url = request.getParameter("url");
        String[] options = request.getParameterValues("scrape");


        HttpSession session = request.getSession();
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        visitCount = (visitCount == null) ? 1 : visitCount + 1;
        session.setAttribute("visitCount", visitCount);


        BasicWebdata data = new BasicWebdata();
        List<NewsArticle> articles = new ArrayList<>();

        if (url != null && options != null) {
            for (String option : options) {
                switch (option) {
                    case "title":
                    case "headings":
                    case "links":
                        data = WebScraper.scrapeBasicdata(url);
                        break;
                    case "news":
                        articles = WebScraper.scrapeNewsArticles(url);
                        break;
                }
            }
        }


        request.setAttribute("visitCount", visitCount);
        request.setAttribute("title", data.getTitle());
        request.setAttribute("headings", data.getHeadings());
        request.setAttribute("links", data.getLinks());
        request.setAttribute("articles", articles);


        Gson gson = new Gson();
        String jsonOutput = gson.toJson(articles);


        response.setContentType("text/html");


    }
}
