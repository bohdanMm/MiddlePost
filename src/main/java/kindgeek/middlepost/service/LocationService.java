package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.LocationRequest;
import kindgeek.middlepost.dto.responce.LocationResponce;
import kindgeek.middlepost.entityes.Location;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired AdressService adressService;

    public Location getLocationEntityById(Long id){
        return locationRepository.findById(id)
                .orElseThrow(()-> new WrongInputDataExeption("There ae not Location with id: " + id));
    }

    public List<LocationResponce> getAll(){
        return locationRepository
                .findAll()
                .stream()
                .map(LocationResponce::new)
                .collect(Collectors.toList());
    }

    public LocationResponce getById(Long id){
        return new LocationResponce(getLocationEntityById(id));
    }

    public void save(LocationRequest locationRequest){
        Location location = new Location();
        location.setAdress(adressService.getAdressEntityById(locationRequest.getAdressId()));
        locationRepository.save(location);
    }

    public void update(Long id, LocationRequest locationRequest){
        Location location = getLocationEntityById(id);
        location.setAdress(adressService.getAdressEntityById(locationRequest.getAdressId()));
        locationRepository.save(location);
    }

    public void delete(Long id){
        Location location = getLocationEntityById(id);
        if(location.getWorker().isEmpty()) {
            locationRepository.delete(location);
        } else {
            throw new WrongInputDataExeption("Location with id:" + id + " contains workers.");
        }
    }
}