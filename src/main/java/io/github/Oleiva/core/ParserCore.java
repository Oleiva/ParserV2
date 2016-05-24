package io.github.Oleiva.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.Oleiva.entity.CompanysEntity;
import io.github.Oleiva.services.CompanyServise;


/**
 * Created by Ivasoft_ on 23.05.2016.
 */

@Component
public class ParserCore {

    @Autowired
    Parser parser;

    @Autowired
    CompanyServise companyServise;

    public void Parse(long main_min, long main_max) throws Exception {

        long index = 0;

        for (index = main_min; index < main_max; index++) {
            System.out.println(
                     parser.parseCompany(index).getIndex()+" "
                    +parser.parseCompany(index).getCompanyName()+" "
                    +parser.parseCompany(index).getContactFace()+" "
                    +parser.parseCompany(index).getTelephone()+" "
                    +parser.parseCompany(index).getWebsite()+" "
                    +parser.parseCompany(index).getDescription()
            );

            System.out.print("New entity");
//            companyServise.addCompany(parser.parseCompany(index)) ;

//            if (parser.parseCompany(index).getCompanyName()!=null){
//                companyServise.addCompany(
//                        parser.parseCompany(index).getIndex(),
//                        parser.parseCompany(index).getCompanyName(),
//                        parser.parseCompany(index).getContactFace(),
//                        parser.parseCompany(index).getTelephone(),
//                        parser.parseCompany(index).getWebsite(),
//                        parser.parseCompany(index).getDescription()
//                );
//            }
            Company company = parser.parseCompany(index);

//            public CompanysEntity addCompany(long index, String companyName, String contactFace, String telephone,
//                    String website, String description);

//            long index, String companyName, String contactFace, String telephone,
//                    String website, String description);

            companyServise.addCompany(company.getIndex(),company.getCompanyName(),
                    company.getContactFace(),
                    company.getTelephone(),company.getWebsite(),company.getWebsite()
            );

            System.out.print("New entity saved");









        }
    }
}
