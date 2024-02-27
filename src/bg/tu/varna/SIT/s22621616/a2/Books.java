package bg.tu.varna.SIT.s22621616.a2;

public class Books {
    String author;
    String title;
    Genre genre;
    String description;
    Keywords[] keywords;
    int yearOfRelease;
    float rating;
    String id;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKeywords(Keywords[] keywords) {
        this.keywords = keywords;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Books(String author, String title, Genre genre, String description, Keywords[] keywords, int yearOfRelease, float rating, String id) {
        setAuthor(author);
        setTitle(title);
        setGenre(genre);
        setDescription(description);
        setKeywords(keywords);
        setYearOfRelease(yearOfRelease);
        setRating(rating);
        setId(id);
    }


}
