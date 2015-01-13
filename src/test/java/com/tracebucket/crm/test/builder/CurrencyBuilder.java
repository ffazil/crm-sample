package com.tracebucket.crm.test.builder;


import com.tracebucket.common.domain.Currency;

/**
 * Created by sadath on 21-Nov-14.
 */
public class CurrencyBuilder {
    private String name;
    private String iso4217Code;
    private String subUnit110;
    private String image;
    
    private CurrencyBuilder(){ }

    public static CurrencyBuilder aCurrencyBuilder(){
        return new CurrencyBuilder();
    }

    public CurrencyBuilder withName(String name){
        this.name = name;
        return this;
    }

    public CurrencyBuilder withIso4217Code(String iso4217Code){
        this.iso4217Code = iso4217Code;
        return this;
    }

    public CurrencyBuilder withSubUnit110(String subUnit110){
        this.subUnit110 = subUnit110;
        return this;
    }

    public CurrencyBuilder withImage(String image){
        this.image = image;
        return this;
    }

    public Currency build(){
        Currency currency = new Currency();
        currency.setName(name);
        currency.setIso4217Code(iso4217Code);
        currency.setSubUnit110(subUnit110);
        currency.setImage(image);
        return currency;
    }
}
