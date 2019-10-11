package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.StatusRequest;
import kindgeek.middlepost.dto.responce.StatusResponce;
import kindgeek.middlepost.entityes.Status;
import kindgeek.middlepost.entityes.Statuses;
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


    public Status getStatusEntityById(Long id){
        return statusRepository.findById(id)
                .orElseThrow(()->new WrongInputDataExeption("Status with " + id + " not found"));
    }

    public Status getStatusByStatusName(Statuses status){
        return statusRepository.findByStatusName(status);
    }

    public void save(StatusRequest statusRequest){
        Status status = new Status();
        status.setStatusName(Statuses.valueOf(statusRequest.getStatusName()));
        statusRepository.save(status);
    }

    public void update(Long id)

}
