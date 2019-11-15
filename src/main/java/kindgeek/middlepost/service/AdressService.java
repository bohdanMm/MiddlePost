package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.AdressRequest;
import kindgeek.middlepost.dto.request.PackageRequest;
import kindgeek.middlepost.dto.responce.AdressResponce;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.entityes.Adress;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private LocalityService localityService;

    public Adress getAdressEntityById(Long id){
        return adressRepository.findById(id)
                .orElseThrow(()-> new WrongInputDataExeption("There are nor adress with id:" + id ));
    }

    public DataResponce<AdressResponce> getAll(Integer page, Integer size) {
        PageRequest packageRequest = PageRequest.of(page, size);
        Page<Adress> adressPage = adressRepository.findAll(packageRequest);
        return new DataResponce<AdressResponce>(adressPage.getContent()
                .stream()
                .map(AdressResponce::new)
                .collect(Collectors.toList()),
                adressPage);
    }

    public AdressResponce getById(Long id){
        return new AdressResponce(getAdressEntityById(id));
    }

    public AdressResponce save(AdressRequest adressRequest){
        Adress adress = new Adress();
        adress.setStreet(adressRequest.getStreet());
        adress.setBuildingNumber(adressRequest.getBuildingNumber());
        adress.setLocality(localityService.getLocalityEntityById(adressRequest.getLocalityId()));
        adressRepository.save(adress);
        return new AdressResponce(adress);
    }

    public void update(Long id, AdressRequest adressRequest){
        Adress adress = getAdressEntityById(id);
        adress.setStreet(adressRequest.getStreet());
        adress.setBuildingNumber(adressRequest.getBuildingNumber());
        adress.setLocality(localityService.getLocalityEntityById(adressRequest.getLocalityId()));
        adressRepository.save(adress);
    }

    public Boolean delete(Long id){
        Adress adress = getAdressEntityById(id);
        if (adress.getLocation() == null){
             adressRepository.delete(adress);
             return true;
        } else {
            throw new WrongInputDataExeption("Adress with id: " + id + " is relative to location.");
        }
    }




}
