package com.tracebucket.partner;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;

/**
 * Created by vishwa on 10-12-2014.
 */
public class PartnerType {

    @Column(name = "CUSTOMER")
    @Basic(fetch = FetchType.EAGER)
    Customer customer;

    @Column(name = "AFFILIATE")
    @Basic(fetch = FetchType.EAGER)
    Affiliate affiliate;


    @Column(name = "ENT_COMPANY")
    @Basic(fetch = FetchType.EAGER)
    EntertainmentCompany entertainmentCompany;

    @Column(name = "TOUR_COMPANY")
    @Basic(fetch = FetchType.EAGER)
    TourCompany tourCompany;

    @Column(name = "MUSEUMS")
    @Basic(fetch = FetchType.EAGER)
    Museums museums;

    @Column(name = "TRANSPORT_PROVIDER")
    @Basic(fetch = FetchType.EAGER)
    TransportProvider transportProvider;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public EntertainmentCompany getEntertainmentCompany() {
        return entertainmentCompany;
    }

    public void setEntertainmentCompany(EntertainmentCompany entertainmentCompany) {
        this.entertainmentCompany = entertainmentCompany;
    }

    public TourCompany getTourCompany() {
        return tourCompany;
    }

    public void setTourCompany(TourCompany tourCompany) {
        this.tourCompany = tourCompany;
    }

    public Museums getMuseums() {
        return museums;
    }

    public void setMuseums(Museums museums) {
        this.museums = museums;
    }

    public TransportProvider getTransportProvider() {
        return transportProvider;
    }

    public void setTransportProvider(TransportProvider transportProvider) {
        this.transportProvider = transportProvider;
    }
}
