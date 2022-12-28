package com.abuziyo.ziyotrans.controller;


import com.abuziyo.ziyotrans.entity.CarDocument;
import com.abuziyo.ziyotrans.entity.CarNumber;
import com.abuziyo.ziyotrans.service.CarDocService;
import com.abuziyo.ziyotrans.service.CarNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CarDocController {

    @Autowired
    private CarDocService carDocService;

    @GetMapping("/login")
    public String greet(Model model){
        return "login";
    }

    @Autowired
    private CarNumService carNumService;

    @GetMapping("/main")
    public String index(Model model){

        return "index1";

    }

    @GetMapping("/viewcardoc")
        public String home(@RequestParam(defaultValue = "", name="filterid") String filterid,
                       @RequestParam(defaultValue = "", name = "dates") String dates, Model model){


        List<CarDocument> car = new ArrayList<>();

//        Long fid = Long.parseLong(f   ilterid);
        if (filterid.length() > 0) {
            car = carDocService.findByCarNumber(filterid);
            model.addAttribute("filter", filterid);
        }
        else if(dates.equals("1")){
            car = carDocService.findByDate();
        }
        else if(dates.equals("2")){
            car = carDocService.findByChecker();
        }
//        else if(datefind.){
//            car = carDocService.findByDates(datefind);
//          }
        else  {
            car = carDocService.findById();
            model.addAttribute("filter", "");
        }
        model.addAttribute("car",car);

        return "viewcardoc";
    }

    @GetMapping("/add_doc")

      public String addDoc(Model model){
        List<CarNumber> cnum = carNumService.findNum();
        model.addAttribute("cnum",cnum);
        return "add_doc";
    }

    @PostMapping("/register")
    public String  regisDoc(@ModelAttribute CarDocument carDocument, HttpSession session){

        if (testChecker((long) carDocument.getCheckTirNum() & carDocument.getCheckWayBill() & carDocument.getCheckCmr()
                & carDocument.getCheckCmr2() & carDocument.getCheckDazvol() & carDocument.getCheckcomUdos())){
            carDocument.setCheckAll(1);
        }else {
            carDocument.setCheckAll(0);
            }
        carDocService.saveDoc(carDocument);
        session.setAttribute("msg","Hujjat muvaffaqqiyatli saqlandi");
        return "redirect:/viewcardoc";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        CarDocument carDocument = carDocService.getDocId(id);
        model.addAttribute("car",carDocument);
        List<CarNumber> cnum = carNumService.findNum();
        model.addAttribute("cnum",cnum);
        return "edit";
    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute CarDocument carDocument,HttpSession session){

        if (testChecker((long) carDocument.getCheckTirNum() & carDocument.getCheckWayBill() & carDocument.getCheckCmr()
        & carDocument.getCheckCmr2() & carDocument.getCheckDazvol() & carDocument.getCheckcomUdos())){
            carDocument.setCheckAll(1);
        }else {
            carDocument.setCheckAll(0);
        }
        carDocService.saveDoc(carDocument);
        session.setAttribute("msg","Ma'lumot muvaffaqqiyatli yangilandi");
        return "redirect:/viewcardoc";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoc(@PathVariable Long id,HttpSession session){
        carDocService.deleteId(id);
        session.setAttribute("msg","Document muvaffaqqiyatli o'chirildi");
        return "redirect:/viewcardoc";
    }

    public Boolean testChecker(Long check){
        return check==1;
    }



}
