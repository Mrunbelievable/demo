public class FeedItem {
    private int itemId;

    private String title;

    private String[] pics;

    private String author;

    private String category;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setPics(String[] pics) {
        this.pics = pics;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemId() {
        return itemId;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String[] getPics() {
        return pics;
    }
}
