package com.abuziyo.ziyotrans.service;


import com.abuziyo.ziyotrans.entity.CarNumber;
import com.abuziyo.ziyotrans.repository.CarNumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarNumService {

        @Autowired
        private CarNumRepo carNumRepo;

        public void saveNum(CarNumber carNumber){
            carNumRepo.save(carNumber);
        }

        public List<CarNumber> findNum(){
            return carNumRepo.findAll();
        }


        public CarNumber getNumId(Long id){
            Optional<CarNumber> carNumber = carNumRepo.findById(id);

            if (carNumber.isPresent()){
                return carNumber.get();
            }
            else {
                return null;
            }
        }
        public List<CarNumber> orderById(){
            return carNumRepo.findByOrderById();
        }

        public void delId(Long id){
            carNumRepo.deleteById(id);
        }

}
