package io.github.Oleiva.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.Oleiva.dao.CompanyJPA;
import io.github.Oleiva.entity.CompanysEntity;

/**
 * Created by Oleh Ivashko on 24.05.2016.
 */

@Service
@Transactional
public class CompanyServiseImpl implements CompanyServise {

    @Autowired
    private CompanyJPA companyJPA;

//    public CompanysEntity addItems(String SKU, String NAME, long PRICE, long AMOUN){
//        CompanysEntity itemsEntity = new CompanysEntity(SKU,  NAME, PRICE, AMOUN);
//
//        return itemsDao.saveAndFlush(itemsEntity);
////    }

@Override
    public CompanysEntity addCompany(long index, String companyName, String contactFace, String telephone,
                                     String website, String description){
        CompanysEntity companyEntity = new CompanysEntity(index, companyName, contactFace,  telephone, website, description);
        return companyJPA.saveAndFlush(companyEntity);
    }


}
