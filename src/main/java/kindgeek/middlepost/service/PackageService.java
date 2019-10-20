package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.PackageRequest;
import kindgeek.middlepost.dto.responce.PackageResponce;
import kindgeek.middlepost.entityes.Package;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<PackageResponce> getAll(){
        return packageRepository
                .findAll()
                .stream()
                .map(PackageResponce::new)
                .collect(Collectors.toList());
    }

    public PackageResponce getById(Long id){
        return new PackageResponce(getPackacgeEntityById(id));
    }

    public void save(PackageRequest packageRequest){
        Package pac = new Package();
        pac.setCustomerTo(customerService.getCustomerEntityById(packageRequest.getCustomerToId()));
        pac.setCustomerFrom(customerService.getCustomerEntityById(packageRequest.getCustomerFromId()));
        pac.setLocationFrom(locationService.getLocationEntityById(packageRequest.getLocationFromId()));
        pac.setLocationTo(locationService.getLocationEntityById(packageRequest.getLocationToId()));
        pac.setSandDate(packageRequest.getSandDate());
        pac.setWeight(packageRequest.getWeight());
        pac.setStatus(statusService.getStatusEntityById(packageRequest.getStatusId()));
        packageRepository.save(pac);
    }

    public void update(Long id, PackageRequest packageRequest){
        Package pac = getPackacgeEntityById(id);
        pac.setCustomerTo(customerService.getCustomerEntityById(packageRequest.getCustomerToId()));
        pac.setCustomerFrom(customerService.getCustomerEntityById(packageRequest.getCustomerFromId()));
        pac.setLocationFrom(locationService.getLocationEntityById(packageRequest.getLocationFromId()));
        pac.setLocationTo(locationService.getLocationEntityById(packageRequest.getLocationToId()));
        pac.setSandDate(packageRequest.getSandDate());
        pac.setWeight(packageRequest.getWeight());
        pac.setStatus(statusService.getStatusEntityById(packageRequest.getStatusId()));
        packageRepository.save(pac);
    }

    public void delete(Long id){
        packageRepository.delete(getPackacgeEntityById(id));
    }
}