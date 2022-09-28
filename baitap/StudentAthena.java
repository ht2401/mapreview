package streambuoi2.baitap;

import java.time.LocalDate;
import java.util.List;

public class StudentAthena {
    private int id;
    private String name;
    private String phone;
    private String className;
    LocalDate dateOfBirth;
    List<Integer> examScore;
    boolean payment;

    public StudentAthena() {
    }

    public StudentAthena(int id, String name, String phone, String className, LocalDate dateOfBirth, List<Integer> examScore, boolean payment) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.className = className;
        this.dateOfBirth = dateOfBirth;
        this.examScore = examScore;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Integer> getExamScore() {
        return examScore;
    }

    public void setExamScore(List<Integer> examScore) {
        this.examScore = examScore;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "StudentAthena{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", className='" + className + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", examScore=" + examScore +
                ", payment=" + payment +
                '}';
    }
}
