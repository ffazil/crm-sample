package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.dictionary.AddressType;
import com.tracebucket.common.domain.Address;
import com.tracebucket.crm.test.builder.AddressBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sadath on 25-Nov-14.
 */
public class AddressFixture {

    public static Address standardAddress() {
        Set<AddressType> addressTypes = new HashSet<AddressType>();
        addressTypes.add(AddressType.HEAD_OFFICE);
        Address address = AddressBuilder.anAddress()
                .withName("MMP")
                .withBuilding("XYZ Complex")
                .withStreet("KR Road")
                .withRegion("Basavanagudi")
                .withCity("Bangalore")
                .withDistrict("Bangalore")
                .withState("Karnataka")
                .withCountry("India")
                .withZip("560004")
                .withAddressType(AddressType.BRANCH)
                .build();
        return address;
    }

    public static Address headOffice() {
        Set<AddressType> addressTypes = new HashSet<AddressType>();
        addressTypes.add(AddressType.HEAD_OFFICE);
        Address address = AddressBuilder.anAddress()
                .withName("MMPBV")
                .withBuilding("Vlasveen")
                .withStreet("9301 PS")
                .withRegion("Roden")
                .withCity("Roden")
                .withDistrict("Roden")
                .withState("Roden")
                .withCountry("NL")
                .withZip("9301 PS")
                .withAddressType(AddressType.HEAD_OFFICE)
                .build();
        return address;
    }
}
