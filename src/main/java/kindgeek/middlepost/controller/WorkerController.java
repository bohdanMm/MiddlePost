package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.WorkerRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.dto.responce.WorkerResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerController workerController;

    @GetMapping
    public DataResponce<WorkerResponce> getAll(@RequestParam Integer page, @RequestParam Integer size,
                                               @RequestParam String sortBy, @RequestParam Sort.Direction direction){
        return workerController.getAll(page, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public WorkerResponce getById(Long id){
        return workerController.getById(id);
    }

    @PostMapping
    public WorkerResponce save(@RequestBody WorkerRequest workerRequest){
        return workerController.save(workerRequest);
    }

    @PutMapping
    public WorkerResponce update(@PathVariable Long id ,@RequestBody WorkerRequest workerRequest){
        return workerController.update(id, workerRequest);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Long id){
        return workerController.delete(id);
    }

}
