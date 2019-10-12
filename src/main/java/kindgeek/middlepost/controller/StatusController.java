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

    @RequestMapping
    public List<StatusResponce> getStatuses(){
        return statusService.getAllAdresses();
    }

    @RequestMapping("/{id}")
    public void getById(@PathVariable Long id){
        statusService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody StatusRequest statusRequest){
        statusService.save(statusRequest);
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable Long id, @RequestBody StatusRequest statusRequest){
        statusService.update(id, statusRequest);
    }

    @DeleteMapping
    public void  delete(@RequestParam Long id){
        statusService.delete(id);
    }



}
