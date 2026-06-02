package hello.core.member;

public class Member {

    private Long id;
    private String name;
    private Grade grade;

    //생성자 객체 생성시 필요한 정보를 강제할수있음 (없으면 정보가 없는 객체가됨) 오류
    public Member(Long id, Grade grade, String name) {
        this.id = id;  //this는 왼쪽은 객제자체가 가진 필드id , 오른쪽은 외부 정보매개변수id의미
        this.grade = grade; //this 는 메모리에 생성된 객체 자신의미
        this.name = name;//public static void main static는 static를 객체를 생성하지 않고 클래스이름으로 바로 사용하기때문에 this사용불가
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
