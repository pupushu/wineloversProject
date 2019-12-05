package softuni.winelovers.data.models.shop;

import softuni.winelovers.data.models.base.BaseEntity;
import softuni.winelovers.data.models.wine.Wine;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToMany(mappedBy = "whereToBuy")
    private List<Wine> wineList;

    public Shop() {
        this.wineList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Wine> getWineList() {
        return wineList;
    }

    public void setWineList(List<Wine> wineList) {
        this.wineList = wineList;
    }

    public void addWine(Wine wine){
        this.wineList.add(wine);
    }
}
