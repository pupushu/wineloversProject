package softuni.winelovers.web.models.events;

import softuni.winelovers.web.models.addresses.GetAddressModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UpdateEventModel {
    private String id;
    private String title;
    private String content;
    private String startDate;
    private String endDate;
    private BigDecimal price;
    private List<GetAddressModel> address;

    public UpdateEventModel() {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
