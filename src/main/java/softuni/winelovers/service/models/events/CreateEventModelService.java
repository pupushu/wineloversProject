package softuni.winelovers.service.models.events;

import softuni.winelovers.data.models.shop.Address;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreateEventModelService {
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private List<Address> address;

    public CreateEventModelService() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
