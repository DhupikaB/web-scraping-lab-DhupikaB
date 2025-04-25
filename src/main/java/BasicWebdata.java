import java.util.ArrayList;
import java.util.List;

public class BasicWebdata {
    private String title;
    private List<String> headings;
    private List<String> links;

    public BasicWebdata() {
        headings = new ArrayList<>();
        links = new ArrayList<>();
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void addHeading(String heading) {
        this.headings.add(heading);
    }

    public void addLink(String link) {
        this.links.add(link);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getHeadings() {
        return headings;
    }

    public void setHeadings(List<String> headings) {
        this.headings = headings;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public String toString() {
        return "Title: " + title + "\n\nHeadings:\n" + String.join("\n", headings) +
                "\n\nLinks:\n" + String.join("\n", links);

    }
}
