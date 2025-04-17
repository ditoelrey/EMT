package com.example.emtlab.config;


import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.Host;
import com.example.emtlab.model.User;
import com.example.emtlab.model.enumerations.Category;
import com.example.emtlab.model.enumerations.Role;
import com.example.emtlab.repository.AccommodationRepository;
import com.example.emtlab.repository.CountryRepository;
import com.example.emtlab.repository.HostRepository;
import com.example.emtlab.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {


    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final AccommodationRepository accommodationRepository;

    private final PasswordEncoder passwordEncoder;


    private final UserRepository userRepository;

    public DataInitializer(CountryRepository countryRepository, HostRepository hostRepository, AccommodationRepository accommodationRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.accommodationRepository = accommodationRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        Country usa = countryRepository.save(new Country("USA", "North America"));
        Country uk = countryRepository.save(new Country("UK", "Europe"));
        Country germany = countryRepository.save(new Country("Germany", "Europe"));

        Host john = hostRepository.save(new Host("John", "Doe", usa));
        Host emily = hostRepository.save(new Host("Emily", "Smith", uk));
        Host hans = hostRepository.save(new Host("Hans", "Müller", germany));

        accommodationRepository.save(new Accommodation("Cozy Apartment", john, 2, Category.FLAT,false));
        accommodationRepository.save(new Accommodation("Beach House", emily, 4, Category.HOUSE,false));
        accommodationRepository.save(new Accommodation("City d", hans, 10, Category.FLAT,true));
        accommodationRepository.save(new Accommodation("Css dd", hans, 10, Category.FLAT,true));

        accommodationRepository.save(new Accommodation("Cssy ss", hans, 10, Category.APARTMENT,true));


        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "user",
                "user",
                Role.ROLE_USER
        ));

        userRepository.save(new User(
                "host",
                passwordEncoder.encode("host"),
                "host",
                "host",
                Role.ROLE_HOST
        ));

    }
}


