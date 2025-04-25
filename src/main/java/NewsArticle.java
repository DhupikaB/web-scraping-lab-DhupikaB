
public class NewsArticle {
	private String headline;
    private String author;
    private String date;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NewsArticle(String headline, String author, String date) {
        this.headline = headline;
        this.author = author;
        this.date = date;
    }

    public String toString() {
        return String.format("Headline: %s\nAuthor: %s\nDate: %s\n", headline, author, date);
    }
}
