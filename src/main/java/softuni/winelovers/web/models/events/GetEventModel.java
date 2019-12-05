package softuni.winelovers.web.models.events;

import softuni.winelovers.web.models.addresses.GetAddressModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class GetEventModel {
    private String id;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private List<GetAddressModel> address;

    public GetEventModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<GetAddressModel> getAddress() {
        return address;
    }

    public void setAddress(List<GetAddressModel> address) {
        this.address = address;
    }
}
