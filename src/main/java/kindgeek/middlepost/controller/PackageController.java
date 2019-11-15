package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.PackageRequest;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.dto.responce.PackageResponce;
import kindgeek.middlepost.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping
    public DataResponce<PackageResponce> getAll(@RequestParam Integer page, @RequestParam Integer size ){
        return packageService.getAll(page, size);
    }

    @GetMapping("/byUser")
    public DataResponce<PackageResponce> getByUser(@RequestParam Integer page, @RequestParam Integer size,
                                                   @RequestParam String sortBy, @RequestParam Sort.Direction direction,
                                                   @RequestParam Long id ){
        return packageService.getAllByUserId(page, size, sortBy, direction, id);
    }

    @GetMapping("/{id}")
    public PackageResponce getById(@PathVariable Long id){
        return packageService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody PackageRequest packageRequest){
        packageService.save(packageRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id ,@RequestBody PackageRequest packageRequest){
        packageService.update(id, packageRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        packageService.delete(id);
    }

}
