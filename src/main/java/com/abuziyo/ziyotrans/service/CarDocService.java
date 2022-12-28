package com.abuziyo.ziyotrans.service;

import com.abuziyo.ziyotrans.entity.CarDocument;
import com.abuziyo.ziyotrans.repository.CarDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarDocService {

    @Autowired
    private CarDocRepo carDocRepo;

    public void saveDoc(CarDocument carDocument){
        carDocRepo.save(carDocument);
    }

    public List<CarDocument> findAll(){
        return carDocRepo.findAll();
    }

    public CarDocument getDocId(Long id){

       Optional<CarDocument> carDocument = carDocRepo.findById(id);
       if (carDocument.isPresent()){
           return carDocument.get();
       }else {
           return null;
       }

    }
    public void deleteId(Long id){
         carDocRepo.deleteById(id);
    }

    public List<CarDocument> findFk(Long id){
        return carDocRepo.findByFk(id);
    }

    public List<CarDocument> findByCarNumber(String num) {
        return carDocRepo.findByCarNumber(num);
    }

    public List<CarDocument> findById(){
        return carDocRepo.findByOrderById();

    }

    public List<CarDocument> findByDate(){
        return carDocRepo.findByOrderByDateDesc();
    }

    public List<CarDocument> findByChecker(){
        return carDocRepo.findByChecker();
    }

    public List<CarDocument> findByDates(String date){
        return carDocRepo.findByDates(date);
    }

}
