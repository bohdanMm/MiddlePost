package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.PasportDataReqest;
import kindgeek.middlepost.dto.responce.PasportDataResponce;
import kindgeek.middlepost.service.PasportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pasprtdata")
public class PasportDataController {

    @Autowired
    private PasportDataService pasportDataService;

    @GetMapping
    public List<PasportDataResponce> getAll(){
        return pasportDataService.getAll();
    }

    @GetMapping("/{id}")
    public PasportDataResponce getById(@PathVariable Long id){
        return pasportDataService.getById(id);
    }

    @PostMapping
    public void  save(@RequestBody PasportDataReqest pasportDataReqest){
        pasportDataService.save(pasportDataReqest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PasportDataReqest pasportDataReqest){
        pasportDataService.update(id, pasportDataReqest);
    }

    @DeleteMapping
    public void  delete(@RequestParam Long id){
        pasportDataService.delete(id);
    }
}
