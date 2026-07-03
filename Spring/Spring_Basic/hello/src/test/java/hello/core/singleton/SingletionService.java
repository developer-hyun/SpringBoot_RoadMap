package hello.core.singleton;

public class SingletionService {

    //싱글톤이 만들어질때 하나의 객체를 static으로 등록해둠 반환해야해서 하나는 필요
    private static final SingletionService instance = new SingletionService();

    //외부요청시 하나의 객체 반환해야함
    public static SingletionService getInstance() {
        return instance;
    }
    //싱글톤 생성자 private로 new 새로운 인스턴스 생성 못하게
    private SingletionService() {
    }

    public void logic() {
        System.out.println("실글톤 객체 로직 호출");
    }

}
