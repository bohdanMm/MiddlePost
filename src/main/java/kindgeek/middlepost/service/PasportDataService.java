package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.PasportDataReqest;
import kindgeek.middlepost.dto.responce.PasportDataResponce;
import kindgeek.middlepost.entityes.Locality;
import kindgeek.middlepost.entityes.PasportData;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.PasportDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasportDataService {

    @Autowired
    PasportDataRepository pasportDataRepository;

    public PasportData getPasportDataEntityById(Long id){
        return pasportDataRepository.findById(id)
                .orElseThrow(()-> new WrongInputDataExeption("There are not pasport data with id: "+ id));
    }

    public List<PasportDataResponce> getAll(){
        return pasportDataRepository
                .findAll()
                .stream()
                .map(PasportDataResponce::new)
                .collect(Collectors.toList());
    }

    public PasportDataResponce getById(Long id){
        return new PasportDataResponce(getPasportDataEntityById(id));
    }

    public void save(PasportDataReqest pasportDataReqest){
        PasportData pasportData = new PasportData();
        pasportData.setCode(pasportDataReqest.getCode());
        pasportData.setSerialNumber(pasportDataReqest.getSerialNumber());
        pasportDataRepository.save(pasportData);
    }

    public void update(Long id, PasportDataReqest pasportDataReqest){
        PasportData pasportData = getPasportDataEntityById(id);
        pasportData.setSerialNumber(pasportDataReqest.getSerialNumber());
        pasportData.setCode(pasportDataReqest.getCode());
        pasportDataRepository.save(pasportData);
    }

    public void delete(Long id){
        PasportData pasportData = getPasportDataEntityById(id);
        if (pasportData.getCustomer() == null){
            pasportDataRepository.delete(pasportData);
        } else {
            throw new WrongInputDataExeption("Pasport data with id: " + id + " is relative to some customer");
        }
    }
}
