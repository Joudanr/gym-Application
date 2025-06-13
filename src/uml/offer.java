/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml;


public class offer {
    
    private String coupon ,occison , Discount , expireDate;

    public offer(String coupon, String occison, String Discount, String expireDate) {
        this.coupon = coupon;
        this.occison = occison;
        this.Discount = Discount;
        this.expireDate = expireDate;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getOccison() {
        return occison;
    }

    public void setOccison(String occison) {
        this.occison = occison;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String Discount) {
        this.Discount = Discount;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "occison:" + occison + ", " + expireDate;
    }
    
    
    
}
