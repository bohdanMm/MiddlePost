package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.responce.AdressResponce;
import kindgeek.middlepost.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    public List<AdressResponce> getAllAdresses() {
        return adressRepository
                .findAll()
                .stream()
                .map(AdressResponce::new)
                .collect(Collectors.toList());
    }




}
