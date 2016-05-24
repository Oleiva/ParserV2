package io.github.Oleiva.services;

import io.github.Oleiva.entity.CompanysEntity;

/**
 * Created by Oleh Ivashko on 24.05.2016.
 */


public interface CompanyServise {

    public CompanysEntity addCompany(long index, String companyName, String contactFace, String telephone,
                                     String website, String description);

}
