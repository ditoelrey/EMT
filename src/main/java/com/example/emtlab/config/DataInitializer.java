package com.example.emtlab.config;


import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.Host;
import com.example.emtlab.model.enumerations.Category;
import com.example.emtlab.repository.AccommodationRepository;
import com.example.emtlab.repository.CountryRepository;
import com.example.emtlab.repository.HostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {


    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final AccommodationRepository accommodationRepository;

    public DataInitializer(CountryRepository countryRepository, HostRepository hostRepository, AccommodationRepository accommodationRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @PostConstruct
    public void init() {
        Country usa = countryRepository.save(new Country("USA", "North America"));
        Country uk = countryRepository.save(new Country("UK", "Europe"));
        Country germany = countryRepository.save(new Country("Germany", "Europe"));

        Host john = hostRepository.save(new Host("John", "Doe", usa));
        Host emily = hostRepository.save(new Host("Emily", "Smith", uk));
        Host hans = hostRepository.save(new Host("Hans", "Müller", germany));

        accommodationRepository.save(new Accommodation("Cozy Apartment", john, 2, Category.FLAT));
        accommodationRepository.save(new Accommodation("Beach House", emily, 4, Category.HOUSE));
        accommodationRepository.save(new Accommodation("City Hotel", hans, 10, Category.HOTEL));
    }
}


