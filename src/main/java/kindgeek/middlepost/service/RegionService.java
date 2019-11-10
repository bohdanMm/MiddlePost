package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.RegionRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.dto.responce.DistrictResponce;
import kindgeek.middlepost.dto.responce.RegionResponce;
import kindgeek.middlepost.entityes.District;
import kindgeek.middlepost.entityes.Region;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.DistrictRepository;
import kindgeek.middlepost.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private DistrictService districtService;

    public Region getRegionEntityByID(Long id){
        return regionRepository.findById(id)
                .orElseThrow(()->new WrongInputDataExeption("There are not region with id: " + id));
    }

    public DataResponce<RegionResponce> getAll(Integer page, Integer size,
                                       String sortBy, Sort.Direction direction,
                                       String name){
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Region> regionPage;
        if(name != null){
            regionPage = regionRepository.findAllByRegionNameLike("%" + name + "%", pageRequest);
        } else {
            regionPage = regionRepository.findAll(pageRequest);
        }
        return new DataResponce<RegionResponce>(regionPage.getContent()
                .stream()
                .map(RegionResponce::new)
                .collect(Collectors.toList())
                , regionPage);
    }

    public RegionResponce getById(Long id){
        return new RegionResponce(getRegionEntityByID(id));
    }

    public void save(RegionRequest regionRequest){
        Region region = new Region();
        region.setRegionName(regionRequest.getRegionName());
        region.setDistrict(districtService.getDistrictEntityById(regionRequest.getDistrictId()));
        regionRepository.save(region);
    }

    public void update(Long id, RegionRequest regionRequest){
        Region region = getRegionEntityByID(id);
        region.setRegionName(regionRequest.getRegionName());
        region.setDistrict(districtService.getDistrictEntityById(regionRequest.getDistrictId()));
        regionRepository.save(region);
    }

    public void delete(Long id){
        Region region = getRegionEntityByID(id);
        if(region.getLocalities().isEmpty()){
            regionRepository.delete(region);
        } else {
            throw new WrongInputDataExeption("Region with id:" + id + " has localities");
        }
    }
}
