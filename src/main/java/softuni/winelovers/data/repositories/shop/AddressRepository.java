package softuni.winelovers.data.repositories.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.winelovers.data.models.shop.Address;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    Optional<Address> findByCountryAndCityAndStreetAndNumber(String country, String city, String street, String number);

    Optional<Address> findById(String id);
}
