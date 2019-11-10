package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.FilterWorkerRequest;
import kindgeek.middlepost.dto.request.WorkerRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.dto.responce.DistrictResponce;
import kindgeek.middlepost.dto.responce.WorkerResponce;
import kindgeek.middlepost.entityes.District;
import kindgeek.middlepost.entityes.Worker;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.WorkerRepository;
import kindgeek.middlepost.specification.WorkerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public DataResponce<WorkerResponce> getAll(Integer page, Integer size,
                                               String sortBy, Sort.Direction direction){
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Worker> workerPage = workerRepository.findAll(pageRequest);
        return new DataResponce<>(workerPage.getContent()
                .stream()
                .map(WorkerResponce::new)
                .collect(Collectors.toList())
                , workerPage);
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

    public List<WorkerResponce> priceFilter(FilterWorkerRequest filterWorkerRequest){
        WorkerSpecification workerSpecification = new WorkerSpecification(filterWorkerRequest);
        return workerRepository.findAll(workerSpecification)
                .stream()
                .map(WorkerResponce::new)
                .collect(Collectors.toList());
    }

}
