package kindgeek.middlepost.controller;

import kindgeek.middlepost.service.AdressService;
import kindgeek.middlepost.dto.responce.AdressResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    AdressService adressService;

    @RequestMapping("/all")
    public List<AdressResponce> getAdresses(){
        return adressService.getAllAdresses();
    }

}
