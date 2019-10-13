package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.RegionRequest;
import kindgeek.middlepost.dto.responce.RegionResponce;
import kindgeek.middlepost.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<RegionResponce> getAll(){
        return  regionService.getAll();
    }

    @GetMapping("/{id}")
    public RegionResponce getById(@PathVariable Long id){
        return regionService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody RegionRequest regionRequest){
        regionService.save(regionRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RegionRequest regionRequest){
        regionService.update(id, regionRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        regionService.delete(id);
    }

}
