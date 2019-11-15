package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.PackageRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.dto.responce.PackageResponce;
import kindgeek.middlepost.entityes.Package;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private LocationService locationService;


    private Package getPackacgeEntityById(Long id){
        return packageRepository.findById(id)
                .orElseThrow(()-> new WrongInputDataExeption("There are not Package with id:" + id));
    }

    public DataResponce<PackageResponce> getAll(Integer page, Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Package> packagePage = packageRepository.findAll(pageRequest);
        return new DataResponce<>(packagePage.getContent().stream()
                .map(PackageResponce::new)
                .collect(Collectors.toList()),
                packagePage);
    }

    public DataResponce<PackageResponce> getAllByUserId(Integer page, Integer size,
                                                String sortBy, Sort.Direction direction,
                                                Long userId){
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Package> packagePage = packageRepository.findAllByCustomerFrom_IdOrCustomerTo_Id(userId, userId, pageRequest);
        return new DataResponce<>(packagePage.getContent().stream()
                .map(PackageResponce::new)
                .collect(Collectors.toList()),
                packagePage);
    }

    public PackageResponce getById(Long id){
        return new PackageResponce(getPackacgeEntityById(id));
    }

    public PackageResponce save(PackageRequest packageRequest){
        Package pac = new Package();
        pac.setCustomerTo(customerService.getCustomerEntityById(packageRequest.getCustomerToId()));
        pac.setCustomerFrom(customerService.getCustomerEntityById(packageRequest.getCustomerFromId()));
        pac.setLocationFrom(locationService.getLocationEntityById(packageRequest.getLocationFromId()));
        pac.setLocationTo(locationService.getLocationEntityById(packageRequest.getLocationToId()));
        pac.setSandDate(packageRequest.getSandDate());
        pac.setWeight(packageRequest.getWeight());
        pac.setStatus(statusService.getStatusEntityById(packageRequest.getStatusId()));
        packageRepository.save(pac);
        return new PackageResponce(pac);
    }

    public PackageResponce update(Long id, PackageRequest packageRequest){
        Package pac = getPackacgeEntityById(id);
        pac.setCustomerTo(customerService.getCustomerEntityById(packageRequest.getCustomerToId()));
        pac.setCustomerFrom(customerService.getCustomerEntityById(packageRequest.getCustomerFromId()));
        pac.setLocationFrom(locationService.getLocationEntityById(packageRequest.getLocationFromId()));
        pac.setLocationTo(locationService.getLocationEntityById(packageRequest.getLocationToId()));
        pac.setSandDate(packageRequest.getSandDate());
        pac.setWeight(packageRequest.getWeight());
        pac.setStatus(statusService.getStatusEntityById(packageRequest.getStatusId()));
        packageRepository.save(pac);
        return new PackageResponce(pac);
    }

    public Boolean delete(Long id){
        packageRepository.delete(getPackacgeEntityById(id));
        return true;
    }
}
