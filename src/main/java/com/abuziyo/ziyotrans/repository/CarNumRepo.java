package com.abuziyo.ziyotrans.repository;

import com.abuziyo.ziyotrans.entity.CarNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarNumRepo extends JpaRepository<CarNumber,Long> {

    List<CarNumber> findByOrderById();


}
