package io.github.Oleiva.controllers;

import io.github.Oleiva.dto.pojo.ResponsePojo;
import io.github.Oleiva.services.CompanyServise;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
   public final Logger LOG = Logger.getLogger(this.getClass());

  @Autowired
  private CompanyServise companyServise;

  @RequestMapping("/")
  @ResponseBody
  public ResponsePojo index(ResponsePojo responsePojo) {
    responsePojo.setMessage("Proudly handcrafted by " + "<a href='http://oleiva.github.io'>Ivasoft </a> :)");
    return responsePojo;
  }

  @RequestMapping(value = "/initializer", method = RequestMethod.GET)
  @ResponseBody
  public ResponsePojo DBInitializer (
          ResponsePojo responsePojo) {

    try{ /*add Items|--> |String SKU|String NAME| long PRICE| long AMOUN| */
//      itemsService.addItems("10001-1290-S", "iron",  50000,30);
//      itemsService.addItems("10002-1233-D", "sock",61000,30);
//      itemsService.addItems("10031-1233-S", "pot",61000,30);
//      itemsService.addItems("10003-1234-D", "pan",61000,30);
//      itemsService.addItems("10303-1235-S", "scissors",8000,30);
//      itemsService.addItems("10301-1236-M", "phone",600,30);
//      itemsService.addItems("10031-1237-S", "pen",63000,30);
//      itemsService.addItems("13005-1238-S", "notebook",61030,30);
//      itemsService.addItems("10006-1239-S", "laptop",61032,30);
//      itemsService.addItems("10404-1210-M", "board",61050,30);
//      itemsService.addItems("10051-1220-M", "marker",999999999,30);

    companyServise.addCompany(10,"name","ee","ee","ee","ee");

      responsePojo.setMessage("All items added");


    }catch (Exception ex){
      responsePojo.setMessage(responsePojo.getMessage()+" ShippingAddresses were not added. Probably, they were added previously");
      LOG.warn("LOG## ShippingAddresses were not added. Probably, they were added previously ");
    }

    return responsePojo;
  }

}
