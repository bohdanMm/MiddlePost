package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.LocalityRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.dto.responce.DistrictResponce;
import kindgeek.middlepost.dto.responce.LocalityResponce;
import kindgeek.middlepost.dto.responce.StatusResponce;
import kindgeek.middlepost.entityes.District;
import kindgeek.middlepost.entityes.Locality;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.DistrictRepository;
import kindgeek.middlepost.repository.LocalityRepository;
import kindgeek.middlepost.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RegionRepository regionRepository;

    public Locality getLocalityEntityById(Long id){
        return localityRepository.findById(id)
                .orElseThrow(()-> new WrongInputDataExeption("There are not locality with id: "+ id));
    }

    public LocalityResponce getById(Long id){
        return new LocalityResponce(getLocalityEntityById(id));
    }

    public DataResponce<LocalityResponce> getAll(Integer page, Integer size,
                                         String sortBy, Sort.Direction direction){
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Locality> localityPage = localityRepository.findAll(pageRequest);
        return new DataResponce<LocalityResponce>(localityPage.getContent()
                .stream()
                .map(LocalityResponce::new)
                .collect(Collectors.toList())
                , localityPage);
    }

    public LocalityResponce save(LocalityRequest localityRequest){
        Locality locality = new Locality();
        locality.setLocalityName(localityRequest.getLocalityName());
        locality.setRegion(regionRepository.findByRegionName(localityRequest.getRegionName()));
        locality.setDistrict(districtRepository.findByDistrictName(localityRequest.getDistrictName()));
        localityRepository.save(locality);
        return new LocalityResponce(locality);
    }

    public LocalityResponce update(Long id, LocalityRequest localityRequest){
        Locality locality = getLocalityEntityById(id);
        locality.setLocalityName(localityRequest.getLocalityName());
        locality.setRegion(regionRepository.findByRegionName(localityRequest.getRegionName()));
        locality.setDistrict(districtRepository.findByDistrictName(localityRequest.getDistrictName()));
        localityRepository.save(locality);
        return new LocalityResponce(locality);
    }

    public Boolean delete(Long id){
        Locality locality = getLocalityEntityById(id);
        if(locality.getAdress().isEmpty()){
            localityRepository.delete(locality);
            return true;
        } else {
            throw new WrongInputDataExeption("There are locations in this locality");
        }
    }

}
