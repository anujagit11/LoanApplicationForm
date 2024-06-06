package com.finalpro.appform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PermanentAddress {
@Id
private int permanentAddressId;
private String areaname;
private String cityname;
private String district;
private String state;
private long pincode;
private int houseNumber;
private String streetName;

}







