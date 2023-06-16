/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Scanner;

/**
 *
 * @author Pham Hieu
 */
public class HR {
    private static int cont = 0;
    private static Employee ep[] = new Employee[100];

    public HR() {
    }
    
    public static void main(String[] args) {
        byte choose, choose2;
        
        Scanner sc = new Scanner(System.in);
        do{
            menu();
            choose = sc.nextByte();
            switch(choose){
                case 1:
                    nhapDS();
                    choose2 = sc.nextByte();
                    switch(choose2){
                        case 1:
                            inputBussiness();
                            break;
                        case 2:
                    }
                    break;
                case 2:
                    for (int i = 0; i < cont; i++) {
                        ep[i].xuatThongTinNV();
                    break;
                    }
            }
        } while(true);
    }
    public static void menu(){
        System.out.println("=============");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Danh sách nhân viên");
        System.out.println("3. Danh sách nhân viên theo loại");
        System.out.println("4. Lương trung bình toàn công ty");
        System.out.println("5. Lương cao nhất");
        System.out.println("6. Lương thấp nhất");
        System.out.println("7. Tìm kiếm nhân viên");
        System.out.println("8. Sắp xếp nhân viên");
        System.out.println("9. Xóa nhân viên theo mã");
        System.out.println("10. Cập nhật nhân viên theo mã");
        System.out.println("11. Exit chương trình");
        System.out.println("=============");
        System.out.print("Choose your option: ");
    }
    public static void nhapDS(){
        System.out.println("=====ADD=====");
        System.out.println("1. Nhân viên kinh doanh");
        System.out.println("2. Nhân viên hành chính");
        System.out.println("=============");
        System.out.print("Choose your option: ");
    }
    public static void inputBussiness(){
        String name, ID, birth;
        boolean gender;
        double basicSalary, seniority, sales;
        int check = 0;
        Scanner sc = new Scanner(System.in);
        name = Validation.getNoneBlankString("Tên: ", "Lỗi tên cmm");
        while(true){
            System.out.print("ID: ");
            ID = sc.nextLine();
            if (Validation.isID(ID)){
                for (int i = 0; i < cont; i++) {
                    if(ep[i].id.equals(ID)) {
                        System.err.println("ID đã bị trùng");
                        check = i;
                        break;
                    } 
                } break;
            } else System.err.println("Không đúng định dạng ID (HRxxxxx)");
        }
//        while(1 + 1 == 2){
//            try{
//                System.out.print("Giới tính (true: nam | false: nữ):");
//                gender = sc.nextBoolean();
//                break;
//            }catch(Exception e){
//                System.err.println("Vui lòng nhập true/false");
//            }
//        }
        do{
            System.out.print("Giới tính (true: nam | false: nữ):");
            String genderCheck = sc.nextLine().toLowerCase();
            if(genderCheck.equals("true")){
                gender = true;
                break;
            }else if(genderCheck.equals("false")){
                gender = false;
                break;
            } else System.err.println("Vui lòng nhập true/false");
        }while(true);
        birth = Validation.getBirthDate("Ngày sinh (dd/mm/yyyy): ", "Vui lòng nhập đúng định dạng");
        basicSalary = Validation.isNumber("Lương cơ bản: ", "Lương phải là số và lớn hơn 0");
        seniority = Validation.isNumber("Thâm niên: ", "Thâm niên phải là số và lớn hơn 0");
        sales = Validation.isNumber("Doanh số: ", "Doanh số phải là số và lớn hơn 0");
        ep[cont++] = new Business(sales, name, ID, gender, birth, basicSalary, seniority);
    }

}