/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courier;


public class ModelTable {
    
   String bookingId,name,date,contact,service,Fromadd,Toadd;

    public ModelTable(String bookingId, String date, String contact, String service, String Fromadd, String Toadd) {
        this.bookingId = bookingId;
        //this.name=name;
        this.date = date;
        this.contact = contact;
        this.service = service;
        this.Fromadd = Fromadd;
        this.Toadd = Toadd;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getFromadd() {
        return Fromadd;
    }

    public void setFromadd(String Fromadd) {
        this.Fromadd = Fromadd;
    }

    public String getToadd() {
        return Toadd;
    }

    public void setToadd(String Toadd) {
        this.Toadd = Toadd;
    }
    
    
    
    
}
