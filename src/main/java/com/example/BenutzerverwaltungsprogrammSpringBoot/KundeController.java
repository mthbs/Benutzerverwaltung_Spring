package com.example.BenutzerverwaltungsprogrammSpringBoot;

import com.example.BenutzerverwaltungsprogrammSpringBoot.Model.Kunde;
import com.example.BenutzerverwaltungsprogrammSpringBoot.database.DBConnection;
import com.example.BenutzerverwaltungsprogrammSpringBoot.form.DeleteForm;
import com.example.BenutzerverwaltungsprogrammSpringBoot.form.KundeForm;
import com.example.BenutzerverwaltungsprogrammSpringBoot.form.SpaltenKategorien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class KundeController {


//    private static Kunde[] kunden = new Kunde[]{
//            new Kunde("1","max","kundel","mkd@f.de","ffm"),
//            new Kunde("2","friedrich","heinz","mkd@f.de","marburg"),
//            new Kunde("3","gusti","huber","gustavhuber@web.de","ffm")
//    };

    @GetMapping("/hauptanzeige")
    public String getKunden(Model model) throws SQLException {
        DBConnection dba = new DBConnection("root","root");
        model.addAttribute("kunden",dba.createCustomerList());
        return "hauptanzeige";
    }

    @GetMapping("/hauptanzeige/kunde_anlegen")
    public String newKunde(Model model) throws SQLException {
        KundeForm kundeForm = new KundeForm();
        model.addAttribute("kundeForm",kundeForm);
        return "kunde_anlegen";
    }

    @PostMapping("/hauptanzeige/kunde_anlegen")
    public String addNewKunde(Model model,
            @ModelAttribute("kundeForm") KundeForm kundeForm
    ){
        DBConnection dba = new DBConnection("root","root");
        if(kundeForm.getVorname().equals("") || kundeForm.getName().equals("") || kundeForm.getEmail().equals("")){
            String errorMessage = "Please fill out required fields!";
            model.addAttribute("errorMessage",errorMessage);
            return "kunde_anlegen";
        } else if (kundeForm.getStadt().equals("")) {
            dba.addNewCustomer(kundeForm.getVorname(),kundeForm.getName(),kundeForm.getEmail());
        } else {
            dba.addNewCustomer(kundeForm.getVorname(),kundeForm.getName(),kundeForm.getEmail(),kundeForm.getStadt());
        }
        return "redirect:/hauptanzeige";
    }

    @GetMapping("/hauptanzeige/kunde_entfernen")
    public String deleteKunde(Model model) {
        DeleteForm deleteForm = new DeleteForm();
        model.addAttribute("deleteForm",deleteForm);
//        List<SpaltenKategorien> list = new ArrayList(Arrays.asList(
//                new SpaltenKategorien("id","Id"),
//                new SpaltenKategorien("vorname","Vorname"),
//                new SpaltenKategorien("name","Name"),
//                new SpaltenKategorien("email","E-Mail"),
//                new SpaltenKategorien("stadt","Stadt")
//        ));
//        model.addAttribute("categories",list);
        List<String> options = new ArrayList<>(Arrays.asList("id","vorname","name","email","stadt"));
        model.addAttribute("options",options);
        return "kunde_entfernen";
    }

    @PostMapping("/hauptanzeige/kunde_entfernen")
    public String deleteKundeAction(Model model,
            @ModelAttribute("deleteForm") DeleteForm deleteForm) {
    String column = deleteForm.getColumn();
    String value = deleteForm.getValue();
        System.out.println("Delete "+ value + " From " + column);
        DBConnection dba = new DBConnection("root","root");
        dba.deleteCustomer(column,value);
        return "redirect:/hauptanzeige";
    }
}
