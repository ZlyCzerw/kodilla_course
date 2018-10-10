package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        BigDecimal bigDecimal = new BigDecimal("50000");
        BigDecimal bigDecimal2 = new BigDecimal("40000");

        Product product1 = new Product("Bulbulator");
        Product product2 = new Product("Zamutowacz");

        Item item1 = new Item(bigDecimal,5,bigDecimal2);
        Item item2 = new Item(bigDecimal.divide(new BigDecimal("2")),20,bigDecimal2.divide(new BigDecimal("2")));
        Item item3 = new Item(bigDecimal,40,bigDecimal2);
        Item item4 = new Item(bigDecimal2,3,bigDecimal);
        Item item5 = new Item(bigDecimal2, 55,bigDecimal2);

        Invoice invoice1 = new Invoice("45kk34");
        Invoice invoice2 = new Invoice("32ad09");

        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product2.getItems().add(item3);
        product2.getItems().add(item4);
        product2.getItems().add(item5);

        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);
        item4.setProduct(product2);
        item5.setProduct(product2);

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item3);
        invoice2.getItems().add(item2);
        invoice2.getItems().add(item4);
        invoice2.getItems().add(item5);

        item1.setInvoice(invoice1);
        item3.setInvoice(invoice1);
        item2.setInvoice(invoice2);
        item4.setInvoice(invoice2);
        item5.setInvoice(invoice2);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);

        int id1 = invoice1.getId();
        int id2 = invoice2.getId();

        //Then
        Assert.assertNotEquals(0, id1);
        Assert.assertNotEquals(0, id2);
       // CleanUp
        invoiceDao.delete(id1);
        invoiceDao.delete(invoice2);
    }
}
