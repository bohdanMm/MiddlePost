package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.LocalityRequest;
import kindgeek.middlepost.dto.responce.LocalityResponce;
import kindgeek.middlepost.dto.responce.StatusResponce;
import kindgeek.middlepost.entityes.Locality;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.DistrictRepository;
import kindgeek.middlepost.repository.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private RegionService regionService;

    public Locality getLocalityEntityById(Long id){
        return localityRepository.findById(id)
                .orElseThrow(()-> new WrongInputDataExeption("There are not locality with id: "+ id));
    }

    public LocalityResponce getById(Long id){
        return new LocalityResponce(getLocalityEntityById(id));
    }

    public List<LocalityResponce> getAll(){
        return localityRepository
                .findAll()
                .stream()
                .map(LocalityResponce::new)
                .collect(Collectors.toList());
    }

    public void save(LocalityRequest localityRequest){
        Locality locality = new Locality();
        locality.setLocalityName(localityRequest.getLocalityName());
        locality.setRegion(regionService.getRegionEntityByID(localityRequest.getRegionId()));
        locality.setDistrict(districtService.getDistrictEntityById(localityRequest.getDistrictId()));
        localityRepository.save(locality);
    }

    public void update(Long id, LocalityRequest localityRequest){
        Locality locality = getLocalityEntityById(id);
        locality.setLocalityName(localityRequest.getLocalityName());
        locality.setRegion(regionService.getRegionEntityByID(localityRequest.getRegionId()));
        locality.setDistrict(districtService.getDistrictEntityById(localityRequest.getDistrictId()));
        localityRepository.save(locality);
    }

    public void delete(Long id){
        Locality locality = getLocalityEntityById(id);
        if(locality.getAdress().isEmpty()){
            localityRepository.delete(locality);
        } else {
            throw new WrongInputDataExeption("There are locations in this locality");
        }
    }

}
