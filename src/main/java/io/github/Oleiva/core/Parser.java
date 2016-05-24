package io.github.Oleiva.core;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

//import io.github.oleiva.servise.CompanyServise;

import static sun.plugin.javascript.navig.JSType.Document;

/**
 * Created by Ivasoft_ on 23.05.2016.
 */

@Component
public class Parser {

//    @Autowired
//private CompanyServise companyServise;

public Company parseCompany(long index ) throws Exception {

    Company company = new Company();
    Document doc = null;

    String linkin = "http://www.work.ua/jobs/by-company/" + index;

    Connection.Response response = null;
    try {
        response = Jsoup.connect(linkin)
                .userAgent("Mozilla/5.0 (Windows NT 6.0) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.46 Safari/536.5")
                .timeout(100000)
                .ignoreHttpErrors(true)
                .execute();

    } catch (IOException e) {
    System.out.println("Catch in  link" +" "+index);
    }

    if (response.statusCode() == 200) {

        try {
            doc = Jsoup.connect(linkin).timeout(0).get();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

// Parsing Core
        String name = doc.select("div > h1:first-of-type").first().toString();
        String name_cor = name.substring(23, name.length()-5);

        company.setIndex(index);
        company.setCompanyName(name_cor);
        company.setTelephone(getTelephone(doc));
        company.setContactFace(getContactFace(doc));
        company.setWebsite(getWebsite(doc));
        company.setDescription(GetDescription(doc));

    }else {
//        company.setIndex(index);
//        company.setCompanyName(null);
    }
//    System.out.println("####");
//    companyService.addCompany(company);
//    System.out.println(company + "Company");
//    companyServise.addCompany(company);
    return company;

}

    private String getContactFace(Document doc) {

        String str1 = "Êîíòàêòíîå ëèöî";
        String str2 = "Òåëåôîí";
        String ContaktFace = null;
        String text;

        try {

            text = doc.body().text(); // "An example link"

            ContaktFace = text.substring(text.indexOf(str1) + 17, text.lastIndexOf(str2) - 1);
            // System.out.println("ContaktFace = |" +ContaktFace);

            if (ContaktFace.length() > 10) {

                ContaktFace = null;

            }

        } catch (java.lang.StringIndexOutOfBoundsException e) {
            //	System.out.println("ContaktFace = null");
            ContaktFace = "";
        }
        return ContaktFace;
}




        private String GetDescription(Document doc) throws java.lang.NullPointerException, Exception { // Ïàðñèíã îïèñàíèÿ

        Element masthead = doc.select("div.changeableArea ").first();

        if (masthead == null) {
//            System.out.println("null");
        } else {
            String temp = masthead.toString();
            String str1 = "<p>";
            String Description1 = temp.substring(temp.indexOf(str1), temp.lastIndexOf(str1));
            Document doc1 = Jsoup.parse(Description1);
            String Description = doc1.text().toString();

            Description = Description.replaceAll("Ïîäëèííîñòü ýòîé êîìïàíèè ïðîâåðåíà ñîòðóäíèêàìè Work.ua.|òîäàòåëþ|Íàéòè âàêàíñèè|Ðàçìåñòèòü ðåçþìå|Âîéòè|Ïî ðàçäåëàì|Ïî ãîðîäàì| Ïî êîìïàíèÿì Òîï-100|Äëÿ ñòóäåíòîâ|Ïðîâåðåíî|Ïîäðîáíåå|Òåëåôîí|0|1|2|3|4|5|6|7|8|9", "");
            Description = Description.replaceAll("  |", "");
            Description = Description.replaceAll("--|:-|- -", "");
            Description = Description.trim();

            if (Description.length() > 350) {

                Description = Description.substring(0, 350); //Îãðàíè÷åíèå íà îïèñàíèå 350 ñèìâîëîâ
            }

            if (Description.contains("ðèãëàø") | Description.contains("ðåáó") | Description.contains("àêàíñè") | Description.contains("íàáèðàåò")) {

                Description = null;

            }
            return Description;
        }
        return null;
        }



    public static String getTelephone(Document doc) throws IOException {    // Òåëåôîí

        String str1 = "Òåëåôîí";
        String str2 = "Âåá-ñàéò";
        String Telephone = null;
        String text;

        try {

            text = doc.body().text();
            text = text.replace(" ", "");
            Telephone = text.substring((text.indexOf(str1)) + 8, (text.indexOf(str1)) + 25);
            Telephone = Telephone.replace(" ", "");

        } catch (java.lang.StringIndexOutOfBoundsException e) {

            Telephone = null;
        }
        return Telephone;
    }

    public static String getWebsite(Document doc) throws IOException {    // Âåáñàéò

        String str1 = "www";
        String str2 = " ";
        String Website = null;
        String text;
        int fromIndex;

        try {

            text = doc.body().text();

            fromIndex = text.indexOf(str1);

            Website = text.substring(text.indexOf(str1), text.indexOf(str2, fromIndex));
        } catch (java.lang.StringIndexOutOfBoundsException e) {

            Website = null;
        }
        return Website;
    }
}
