package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.WorkerRequest;
import kindgeek.middlepost.dto.responce.WorkerResponce;
import kindgeek.middlepost.entityes.Worker;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private LocationService locationService;

    private Worker getWorkerEntityById(Long id){
        return workerRepository.findById(id)
                .orElseThrow(()->new WrongInputDataExeption("There are not worker with id: " + id));
    }

    public List<WorkerResponce> getAll(){
        return workerRepository
                .findAll()
                .stream()
                .map(WorkerResponce::new)
                .collect(Collectors.toList());
    }

    public WorkerResponce getById(Long id){
        return new WorkerResponce(getWorkerEntityById(id));
    }

    public void save(WorkerRequest workerRequest){
        Worker worker = new Worker();
        worker.setName(workerRequest.getName());
        worker.setSurname(workerRequest.getSurname());
        worker.setSalary(workerRequest.getSalary());
        worker.setPosition(workerRequest.getPosition());
        worker.setLocation(locationService.getLocationEntityById(workerRequest.getLocationId()));
        workerRepository.save(worker);
    }

    public void update(Long id, WorkerRequest workerRequest){
        Worker worker = getWorkerEntityById(id);
        worker.setName(workerRequest.getName());
        worker.setSurname(workerRequest.getSurname());
        worker.setSalary(workerRequest.getSalary());
        worker.setPosition(workerRequest.getPosition());
        worker.setLocation(locationService.getLocationEntityById(workerRequest.getLocationId()));
        workerRepository.save(worker);
    }

    public void delete(Long id){
        workerRepository.delete(getWorkerEntityById(id));
    }

}
