package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.StatusRequest;
import kindgeek.middlepost.service.StatusService;
import kindgeek.middlepost.dto.responce.StatusResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping
    public List<StatusResponce> getStatuses(){
        return statusService.getAll();
    }

    @GetMapping("/{id}")
    public StatusResponce getById(@PathVariable Long id){
        return statusService.getById(id);
    }

    @PostMapping
    public StatusResponce save(@RequestBody StatusRequest statusRequest){
        return statusService.save(statusRequest);
    }

    @PutMapping("/{id}")
    public  StatusResponce update(@PathVariable Long id, @RequestBody StatusRequest statusRequest){
        return statusService.update(id, statusRequest);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Long id){
        return statusService.delete(id);
    }



}
