package com.abuziyo.ziyotrans.repository;

import com.abuziyo.ziyotrans.entity.CarDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDocRepo extends JpaRepository<CarDocument,Long> {

    @Query(value = "select * from cardoc where car_fk=?",nativeQuery = true)
    List<CarDocument> findByFk(@Param("id") Long id);

    @Query(value = "select c.* from cardoc as c " +
            "INNER JOIN carnum as n ON n.id = c.car_fk where n.car_num = ?",nativeQuery = true)
    List<CarDocument> findByCarNumber(@Param("num") String num);

    List<CarDocument> findByOrderById();

    List<CarDocument> findByOrderByDateDesc();

    @Query(value = "select * from cardoc where check_all = 0",nativeQuery = true)
    List<CarDocument> findByChecker();


    @Query(value = "select * from cardoc as c where c.date = ? ",nativeQuery = true)
    List<CarDocument> findByDates(@Param("date") String date);

    @Query(value = "select c from cardoc  c where c.date like %:date%",nativeQuery = true)
    List<CarDocument> findAllNativeLike(@Param("date") String date);


}
