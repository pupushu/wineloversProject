package softuni.winelovers.web.models.events;

import softuni.winelovers.data.models.shop.Address;
import softuni.winelovers.web.models.addresses.CreateAddressModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreateEventModel {
    private String title;
    private String content;
    private String startDate;
    private String endDate;
    private BigDecimal price;
    private List<CreateAddressModel> address;

    public CreateEventModel() {
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

    public List<CreateAddressModel> getAddress() {
        return address;
    }

    public void setAddress(List<CreateAddressModel> address) {
        this.address = address;
    }
}
