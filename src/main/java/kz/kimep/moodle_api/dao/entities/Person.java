package kz.kimep.moodle_api.dao.entities;

public class Person {
    private Long id;
    private String first;
    private String middle;
    private String last;

    public Person(Long id, String first, String middle, String last){
        this.id = id;
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirst(){
        return this.first;
    }

    public void setFirst(String first){
        this.first = first;
    }

    public String getMiddle(){
        return this.middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast(){
        return this.last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
