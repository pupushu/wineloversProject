package softuni.winelovers.data.repositories.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.winelovers.data.models.shop.Shop;
import softuni.winelovers.web.models.shop.GetShopModel;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {
    Optional<Shop> findById(String id);

    Shop findByName(String name);
}
