package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.LocalityRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.dto.responce.LocalityResponce;
import kindgeek.middlepost.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/locality")
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    @GetMapping
    public DataResponce<LocalityResponce> getAll(@RequestParam Integer page, @RequestParam Integer size,
                                                 @RequestParam String sortBy, @RequestParam Sort.Direction direction){
        return localityService.getAll(page, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public LocalityResponce getById(@PathVariable Long id){
        return localityService.getById(id);
    }

    @PostMapping
    public LocalityResponce save(@RequestBody LocalityRequest localityRequest){
        return localityService.save(localityRequest);
    }

    @PutMapping("/{id}")
    public  LocalityResponce update(@PathVariable Long id, @RequestBody LocalityRequest localityRequest){
        return localityService.update(id, localityRequest);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Long id){
        return localityService.delete(id);
    }

}
