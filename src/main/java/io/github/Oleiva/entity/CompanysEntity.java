package io.github.Oleiva.entity;

/**
 * Created by Oleh Ivashko on 24.05.2016.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "COMPANYS")
public class CompanysEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    
    @NotNull
    private long INDEX_MY;

//    @NotNull
    private String COMPANYNAME;

//    @NotNull
    private String CONTACTFACE;

//    @NotNull
    private String TELEPHONE;
//    @NotNull
    private String WEBSITE;
//
//    @NotNull
    private String DESCRIPTION;


    public CompanysEntity(){}

    public CompanysEntity(long ID){
        this.ID=ID;
    }

    public CompanysEntity(String COMPANYNAME, String CONTACTFACE, String TELEPHONE, String WEBSITE, String DESCRIPTION, String SKU, long PRICE, long AMOUNT) {
        this.COMPANYNAME = COMPANYNAME;
        this.CONTACTFACE = CONTACTFACE;
        this.TELEPHONE = TELEPHONE;
        this.WEBSITE = WEBSITE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public CompanysEntity(long INDEX_MY, String COMPANYNAME, String CONTACTFACE, String TELEPHONE, String WEBSITE, String DESCRIPTION) {
        this.INDEX_MY = INDEX_MY;
        this.COMPANYNAME = COMPANYNAME;
        this.CONTACTFACE = CONTACTFACE;
        this.TELEPHONE = TELEPHONE;
        this.WEBSITE = WEBSITE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }


    public String getCOMPANYNAME() {
        return COMPANYNAME;
    }

    public void setCOMPANYNAME(String COMPANYNAME) {
        this.COMPANYNAME = COMPANYNAME;
    }

    public String getCONTACTFACE() {
        return CONTACTFACE;
    }

    public void setCONTACTFACE(String CONTACTFACE) {
        this.CONTACTFACE = CONTACTFACE;
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public void setWEBSITE(String WEBSITE) {
        this.WEBSITE = WEBSITE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public long getINDEX_MY() {
        return INDEX_MY;
    }

    public void setINDEX_MY(long INDEX_MY) {
        this.INDEX_MY = INDEX_MY;
    }
}
