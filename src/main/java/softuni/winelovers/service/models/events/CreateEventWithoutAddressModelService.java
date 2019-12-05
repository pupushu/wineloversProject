package softuni.winelovers.service.models.events;

import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.service.models.addresses.GetAddressModelService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreateEventWithoutAddressModelService {
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private List<GetAddressModelService> address;

    public CreateEventWithoutAddressModelService() {
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

    public List<GetAddressModelService> getAddress() {
        return address;
    }

    public void setAddress(List<GetAddressModelService> address) {
        this.address = address;
    }
}
