package streambuoi2.baitap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentMpl {
    public Map<String, List<StudentAthena>> deviceStudentToClass(List<StudentAthena> studentAthenaList) {
        return studentAthenaList.stream()
                .collect(Collectors.groupingBy(StudentAthena::getClassName,
                        HashMap::new, Collectors.mapping(Function.identity(), Collectors.toList())));
    }

    public Map<String, List<StudentAthena>> limitStudentToClass(List<StudentAthena> studentAthenaList) {
        var athena = studentAthenaList.stream()
                .limit(2)
                .collect(Collectors.groupingBy(StudentAthena::getClassName,
                        HashMap::new, Collectors.mapping(Function.identity(), Collectors.toList())));

        Map<String, List<StudentAthena>> newClass = new HashMap<>();
        athena.forEach((course, studentInClass) -> {
            newClass.put(course, studentInClass.stream().limit(2).collect(Collectors.toList()));
        });
        return newClass;
    }

    public Map<String, List<StudentAthena>> paymentFalseStudentToClass(List<StudentAthena> studentAthenaList) {
        return studentAthenaList.stream().filter(StudentAthena::isPayment)
                .collect(Collectors.groupingBy(StudentAthena::getClassName,
                        HashMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
    }

    public Map<String, List<StudentAthena>> phoneStudentToClass(List<StudentAthena> studentAthenaList) {
        var athena2 = studentAthenaList.stream()
                .collect(Collectors.groupingBy(StudentAthena::getPhone,
                        HashMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
        HashMap<String, List<StudentAthena>> newClass = new HashMap<>();
        athena2.forEach((sdt, studentInClass) -> {
            newClass.put(sdt, studentInClass.stream()
                    .filter(student -> student.getPhone().length() == 0).collect(Collectors.toList()));
        });
        return newClass;
    }


    public Map<String, List<String>> maxScoreStudentToClass(List<StudentAthena> studentAthenaList) {
        Map<String, List<StudentAthena>> mapClass = deviceStudentToClass(studentAthenaList);
        Map<String, List<String>> newMap = new HashMap<>();
        mapClass.forEach((key, value) -> {
            List<String> listStudent = value.stream().map(student -> {
                Optional<Integer> optional = student.getExamScore().stream().max((i, j) -> i.compareTo(j));
                if (optional.isPresent()) {
                    Integer maxScore = optional.get();
                    String info = student.getName() + " điểm: " + maxScore;
                    return info;
                } else {
                    return null;
                }
            }).collect(Collectors.toList());
            newMap.put(key, listStudent);
        });

        return newMap;
    }

    public Map<String, List<StudentAthena>> scoreStudentToClass(List<StudentAthena> studentAthenaList) {
        List<StudentAthena> listStudentMaxScore = new ArrayList<>();
        studentAthenaList.forEach(student -> {
            List<Integer> scores = student.getExamScore();
            int count = 0;
            for (Integer score : scores) {
                if (score < 8) {
                    break;
                } else {
                    count++;
                }
            }
            if (count > 0) {
                listStudentMaxScore.add(student);
            }
        });
        return deviceStudentToClass(listStudentMaxScore);
    }

    public Map<Integer, StudentAthena> twoCourseStudentToClass(List<StudentAthena> studentAthenaList) {
        Map<Integer, StudentAthena> list1 = new HashMap<>();
        for (int i = 0; i < studentAthenaList.size() - 1; i++) {
            for (int j = i + 1; j < studentAthenaList.size(); j++) {
                if (studentAthenaList.get(i).getId() == studentAthenaList.get(j).getId()) {
                    list1.put(studentAthenaList.get(i).getId(), studentAthenaList.get(i));
                }
            }
        }

        return list1;
    }
}
