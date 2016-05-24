package io.github.Oleiva.core;

/**
 * Created by Ivasoft_ on 22.05.2016.
 */

public class Company {

    private long index;
    private String companyName;
    private String contactFace;
    private String telephone;
    private String website;
    private String description;


    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactFace() {
        return contactFace;
    }

    public void setContactFace(String contactFace) {
        this.contactFace = contactFace;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
