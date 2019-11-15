package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.AdressRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.service.AdressService;
import kindgeek.middlepost.dto.responce.AdressResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @GetMapping
    public DataResponce<AdressResponce> getAll(@RequestParam Integer page, @RequestParam Integer size){
        return adressService.getAll(page, size);
    }

    @GetMapping("/{id}")
    public AdressResponce getAll(@PathVariable Long id){
        return adressService.getById(id);
    }

    @PostMapping
    public AdressResponce save(@RequestBody AdressRequest adressRequest){
        return adressService.save(adressRequest);
    }

    @PutMapping("/{id}")
    public AdressResponce update(@PathVariable Long id, @RequestBody AdressRequest adressRequest){
        return adressService.update(id, adressRequest);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Long id){
        return adressService.delete(id);
    }

}
