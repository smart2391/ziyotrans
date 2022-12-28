package com.abuziyo.ziyotrans.controller;


import com.abuziyo.ziyotrans.entity.CarNumber;
import com.abuziyo.ziyotrans.service.CarNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CarNumController {

    @Autowired
    private CarNumService carNumService;

    @GetMapping("/viewcarnum")
    public String viewnums(Model model){

        List<CarNumber> num = carNumService.orderById();
        model.addAttribute("num",num);
        return "viewcarnum";
    }

    @GetMapping("/add_num")
    public String addNumber(){
        return "add_num";
    }

    @PostMapping("/registernum")

    public String addNum(@ModelAttribute CarNumber carNumber, HttpSession session){
        carNumService.saveNum(carNumber);
        session.setAttribute("msg","Ma'lumot muvaffaqqiyatli saqlandi");
        return "redirect:/viewcarnum";
    }


    @GetMapping("/editnum/{id}")
    public String editNum(@PathVariable Long id, Model model){
        CarNumber carNumber = carNumService.getNumId(id);
        model.addAttribute("number",carNumber);
        return "editnum";
    }

    @PostMapping("/updatenum")
    public String updateNum(@ModelAttribute CarNumber carNumber,HttpSession session){
        carNumService.saveNum(carNumber);
        session.setAttribute("number","Ma'lumot muvaffaqqiyatli yangilandi");
        return "redirect:/viewcarnum";
    }

    @GetMapping("/del/{id}")
    public String deleteNum(@PathVariable Long id,HttpSession session){
        carNumService.delId(id);
        session.setAttribute("msg","Mashina raqami muvaffaqqiyatli o'chirildi");
        return "redirect:/viewcarnum";
    }




}
