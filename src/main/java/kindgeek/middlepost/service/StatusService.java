package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.StatusRequest;
import kindgeek.middlepost.dto.responce.StatusResponce;
import kindgeek.middlepost.entityes.Status;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<StatusResponce> getAllAdresses() {
        return statusRepository
                .findAll()
                .stream()
                .map(StatusResponce::new)
                .collect(Collectors.toList());
    }

    public StatusResponce getById(Long id){
        return new StatusResponce(getStatusEntity(id));
    }


    public Status getStatusEntityById(Long id){
        return statusRepository.findById(id)
                .orElseThrow(()->new WrongInputDataExeption("Status with " + id + " not found"));
    }

    public Status getStatusByStatusName(String statusName){
        return statusRepository.findByStatusName(statusName);
    }

    public void save(StatusRequest statusRequest){
        Status status = new Status();
        status.setStatusName(statusRequest.getStatusName());
        statusRepository.save(status);
    }

    public void update(Long id, StatusRequest statusRequest){
        Status status = getStatusEntity(id);
        status.setStatusName(statusRequest.getStatusName());
        statusRepository.save(status);
    }

    public void delete(Long id) {
        Status status = getStatusEntity(id);
        if(status.getPackageList().isEmpty()) {
            statusRepository.delete(status);
        } else {
            throw new WrongInputDataExeption("Status with id: " + id +" has some packages.");
        }
    }

    private Status getStatusEntity(Long id){
        return statusRepository.findById(id).
                orElseThrow(()->new WrongInputDataExeption("No Status with id:" + id));
    }


}
