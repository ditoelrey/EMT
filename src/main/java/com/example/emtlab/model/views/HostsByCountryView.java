package com.example.emtlab.model.views;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;


@Data
@Entity
@Subselect("SELECT * FROM public.hosts_by_country")
@Immutable
public class HostsByCountryView {


    @Id
    @Column(name = "country_name")
    private String countryName;

    @Column(name = "host_count")
    private Long numHosts;



    public Long getNumHosts() {
        return numHosts;
    }

//    public Long getCountryId() {
//        return countryId;
//    }

    public String getCountryName() {
        return countryName;

    }
}
