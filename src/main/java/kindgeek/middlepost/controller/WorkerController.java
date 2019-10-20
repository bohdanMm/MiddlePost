package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.WorkerRequest;
import kindgeek.middlepost.dto.responce.WorkerResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerController workerController;

    @GetMapping
    public List<WorkerResponce> getAll(){
        return workerController.getAll();
    }

    @GetMapping("/{id}")
    public WorkerResponce getById(Long id){
        return workerController.getById(id);
    }

    @PostMapping
    public void save(@RequestBody WorkerRequest workerRequest){
        workerController.save(workerRequest);
    }

    @PutMapping
    public void update(@PathVariable Long id ,@RequestBody WorkerRequest workerRequest){
        workerController.update(id, workerRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        workerController.delete(id);
    }

}
