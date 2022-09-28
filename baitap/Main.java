package streambuoi2.baitap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<StudentAthena> studentAthena = new ArrayList<>() {
            {
                add(new StudentAthena(1,"hathang1","", "jB", LocalDate.parse("2012-12-12"),List.of(3,2,6,7),false));
                add(new StudentAthena(2,"hathang2","0123456", "jSB", LocalDate.parse("2012-12-12"),List.of(5,2,6,7),true));
                add(new StudentAthena(3,"hathang3","", "Rj", LocalDate.parse("2012-12-12"),List.of(3,6,6,7),false));
                add(new StudentAthena(4,"hathang4","0123456", "jSP", LocalDate.parse("2012-12-12"),List.of(3,2,6,7),true));
                add(new StudentAthena(5,"hathang5","0123456", "AD", LocalDate.parse("2012-12-12"),List.of(9,9,9,8),false));
                add(new StudentAthena(6,"hathang3","0133335", "jB", LocalDate.parse("2012-12-12"),List.of(5,7,8,8),true));
                add(new StudentAthena(7,"hathang7","0123456", "jB", LocalDate.parse("2012-12-12"),List.of(6,4,8,8),true));
                add(new StudentAthena(1,"hathang1","0123456", "RN", LocalDate.parse("2012-12-12"),List.of(3,2,6,7),false));
            }
        };
        Map<String, List<StudentAthena>> stringListMap = new HashMap<>();

        StudentMpl studentMpl = new StudentMpl();

        System.out.println("danh sach theo lop : ");
        System.out.println(studentMpl.deviceStudentToClass(studentAthena));

        System.out.println("danh sach lay 2 la : ");
        System.out.println(studentMpl.limitStudentToClass(studentAthena));

        System.out.println("danh sach chua nop tien ");
        System.out.println(studentMpl.paymentFalseStudentToClass(studentAthena));

        System.out.println("danh sach chua co sdt ");
        System.out.println(studentMpl.phoneStudentToClass(studentAthena));

        System.out.println("danh sach sinh vien co diem tren 8 tat ca mon hoc : ");
        System.out.println(studentMpl.scoreStudentToClass(studentAthena));

        System.out.println("danh sach sinh vien co diem cao nhat : ");
        System.out.println(studentMpl.maxScoreStudentToClass(studentAthena));

        System.out.println("danh sach sinh vien theo 2 lop hoc : ");
        System.out.println(studentMpl.twoCourseStudentToClass(studentAthena));
    }
}
