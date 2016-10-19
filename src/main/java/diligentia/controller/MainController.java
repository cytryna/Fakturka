package diligentia.controller;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.*;

import diligentia.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import diligentia.app.PrepareDataUtil;
import diligentia.dao.CompanyRepository;
import diligentia.entity.Company;
import diligentia.view.MainFrame;

@Component
public class MainController {

    @Autowired
    private PrepareDataUtil prepareDataUtil;

    List<Product> entries = new ArrayList<>();

    public static Company SELLER_COMPANY = new Company("NIP 775-000-78-54", "wich-mot edward Wichrowski", "09-500eeee", "Gostynin", "ul. Chopina 4");

    @Autowired
    private MainFrame frame;

    @Autowired
    private CompanyRepository companyRepository;

    @PostConstruct
    private void init() {
        prepareDataUtil.prepareTemporaryData();
        List<Company> all = companyRepository.findAll();
        for (Company company : all) {
            System.err.println("a"+company.getTaxIdentificationNumber());
        }
        frame.refreshCompanyTable(all);


//        all.stream().forEach(article -> System.err.println("article:"+article.getName()));

//        frame.refreshTable(articleDAO.findAll());

        refreshTable();

        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setSize(new Dimension(1200, 800));
        frame.setVisible(true);
    }



    private void refreshTable() {
//        this.frame.refreshTable(this.articleDAO.findAll());
        entries.add(new Product(1, "Silnik", "opis", 3, 3.0, 2));
        entries.add(new Product(2, "Alternator", "opis", 4, 4.0, 4));
        frame.refreshTable(entries);

    }

}
