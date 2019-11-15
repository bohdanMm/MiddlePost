package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.RegionRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.dto.responce.RegionResponce;
import kindgeek.middlepost.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public DataResponce<RegionResponce> getAll(@RequestParam Integer page, @RequestParam Integer size,
                                               @RequestParam String sortBy, @RequestParam Sort.Direction direction,
                                               @RequestParam(required = false) String name){
        return  regionService.getAll(page, size, sortBy, direction, name);
    }

    @GetMapping("/{id}")
    public RegionResponce getById(@PathVariable Long id){
        return regionService.getById(id);
    }

    @PostMapping
    public RegionResponce save(@RequestBody RegionRequest regionRequest){
        return regionService.save(regionRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RegionRequest regionRequest){
        regionService.update(id, regionRequest);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Long id){
        return regionService.delete(id);
    }

}
