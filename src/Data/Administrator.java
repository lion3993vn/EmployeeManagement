/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Pham Hieu
 */
public class Administrator extends Employee{
    private double allowance;

    public Administrator(String name, String id, boolean gender, String birth, double basicSalary, double seniority) {
        super(name, id, gender, birth, basicSalary, seniority);
    }

    public Administrator(double allowance, String name, String id, boolean gender, String birth, double basicSalary, double seniority) {
        super(name, id, gender, birth, basicSalary, seniority);
        this.allowance = allowance;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }
    
    @Override
    public void tinhLuong() {
        salary = basicSalary * getRateSalary() + getAllowance();
    }

    @Override
    public void xuatThongTinNV() {
        System.out.println("Tên: " + name);
        System.out.println("Mã số:" + id);
        System.out.println("Giới tính: " + gender);
        System.out.println("Ngày sinh: " + birth);
        System.out.println("Chức vụ: Nhân viên hành chính");
        System.out.println("Lương: "+ getSalary());
        System.out.println("Thâm niên: " + seniority);
        System.out.println("Phụ cấp: " + getAllowance());
    }
    
}