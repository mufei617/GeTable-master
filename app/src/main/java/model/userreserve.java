package model;

import android.widget.EditText;

public class userreserve {
    private String tablenumber;
    private String seat;
    private String reserveyear;
    private  String reservemonth;
    private  String reserveday;

    public userreserve() {
    }

    public userreserve(String tablenumber,String seat,String reserveyear,String reservemonth,String reserveday) {
        this.tablenumber = tablenumber;
        this.seat = seat;
        this.reserveyear = reserveyear;
        this.reservemonth = reservemonth;
        this.reserveday = reserveday;
    }

    public userreserve(int year, int month, int day, String seat) {
    }

    public userreserve(String number) {
    }


    public String getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(String tablenumber) {
        this.tablenumber = tablenumber;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getReserveyear() {
        return reserveyear;
    }

    public void setReserveyear(String reserveyear) {
        this.reserveyear = reserveyear;
    }

    public String getReservemonth() {
        return reservemonth;
    }

    public void setReservemonth(String reservemonth) {
        this.reservemonth = reservemonth;
    }

    public String getReserveday() {
        return reserveday;
    }

    public void setReserveday(String reserveday) {
        this.reserveday = reserveday;
    }
}
