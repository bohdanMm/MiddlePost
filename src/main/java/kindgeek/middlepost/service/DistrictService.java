package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.DistrictRequest;
import kindgeek.middlepost.dto.responce.DistrictResponce;
import kindgeek.middlepost.entityes.District;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public District getDistrictEntityById(Long id){
        return districtRepository.findById(id)
                .orElseThrow(()->new WrongInputDataExeption("There no district with id: "+ id));
    }

    public List<DistrictResponce> getAllDistricts(){
        return districtRepository
                .findAll()
                .stream()
                .map(DistrictResponce::new)
                .collect(Collectors.toList());
    }

    public DistrictResponce getById(Long id){
        return new DistrictResponce(getDistrictEntityById(id));
    }

    public DistrictResponce getByDistrictName(String name){
        return new DistrictResponce(districtRepository.findByDistrictName(name));
    }

    public void save(DistrictRequest districtRequest){
        District district = new District();
        district.setDistrictName(districtRequest.getDistrictName());
        districtRepository.save(district);
    }

    public void update(Long id, DistrictRequest districtRequest){
        District district = getDistrictEntityById(id);
        district.setDistrictName(districtRequest.getDistrictName());
        districtRepository.save(district);
    }

    public void delete(Long id){
        District district = getDistrictEntityById(id);
        if(district.getRegions().isEmpty() && district.getLocalities().isEmpty()){
            districtRepository.delete(district);
        } else {
            throw new WrongInputDataExeption("District with id:" + id + " has regions or localities");
        }
    }


}
