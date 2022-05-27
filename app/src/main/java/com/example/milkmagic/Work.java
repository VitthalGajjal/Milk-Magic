package com.example.milkmagic;

import java.io.Serializable;

public class Work  implements Serializable {
    private String Work_name;
    private String Work_type;
    private String Work_date;
    private String Work_fat;
    private String Work_srf;
    private String Work_quantity;
    private String Work_total;

    public Work(String Work_name,String Work_type,String Work_date,String Work_fat,String Work_srf,String Work_quantity,String Work_total) {
        this.Work_name = Work_name;
        this.Work_type = Work_type;
        this.Work_date = Work_date;
        this.Work_fat = Work_fat;
        this.Work_srf = Work_srf;
        this.Work_quantity = Work_quantity;
        this.Work_total = Work_total;
    }


    public String getWork_name() {
        return Work_name;
    }
    public void setWork_name(String work_name) {
        this.Work_name = work_name;
    }

    public String getWork_type() {
        return Work_type;
    }
    public void setWork_type(String Work_type) {
        this.Work_type= Work_type;
    }

    public String getWork_date() {
        return Work_date;
    }
    public void setWork_date(String Work_date) {
        this.Work_date= Work_date;
    }

    public String getWork_fat() { return Work_fat; }
    public void setWork_fat(String Work_fat) {
        this.Work_fat= Work_fat;
    }

    public String getWork_srf() {
        return Work_srf;
    }
    public void setWork_srf(String Work_srf) {
        this.Work_srf= Work_srf;
    }

    public String getWork_quantity() {
        return Work_quantity;
    }
    public void setWork_quantity(String Work_quantity) {
        this.Work_quantity= Work_quantity;
    }

    public String getWork_total() {
        return Work_total;
    }
    public void setWork_total(String Work_total) {
        this.Work_total= Work_total;
    }

}