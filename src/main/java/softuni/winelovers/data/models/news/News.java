package softuni.winelovers.data.models.news;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import softuni.winelovers.data.models.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "news")
public class News extends BaseEntity {
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Lob
    @Column(name = "texts", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Lob
    @Column(name = "picture_url", nullable = false, columnDefinition = "TEXT")
    private String pictureUrl;

    @Column(name = "dates_published")
    private Date datePublished;

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }
}
