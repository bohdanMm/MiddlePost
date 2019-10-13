package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.LocalityRequest;
import kindgeek.middlepost.dto.responce.LocalityResponce;
import kindgeek.middlepost.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/locality")
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    @GetMapping
    public List<LocalityResponce> getAll(){
        return localityService.getAll();
    }

    @GetMapping("/{id}")
    public LocalityResponce getById(@PathVariable Long id){
        return localityService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody LocalityRequest localityRequest){
        localityService.save(localityRequest);
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable Long id, @RequestBody LocalityRequest localityRequest){
        localityService.update(id, localityRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        localityService.delete(id);
    }

}
