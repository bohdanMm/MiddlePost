package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.DistrictRequest;
import kindgeek.middlepost.dto.responce.DistrictResponce;
import kindgeek.middlepost.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping
    public List<DistrictResponce> getAll(){
        return districtService.getAllDistricts();
    }

    @GetMapping("/{id}")
    public DistrictResponce getById(@PathVariable Long id){
        return districtService.getById(id);
    }

    @PutMapping
    public void save(@RequestBody DistrictRequest districtRequest){
        districtService.save(districtRequest);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody DistrictRequest districtRequest){
        districtService.update(id, districtRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        districtService.delete(id);
    }

}
