package kz.kimep.moodle_api.responses;

public class HelloFullName {
    private String first;
    private  String last;
    private String middle;
    private String  fullName;

    public HelloFullName(String first, String last, String middle){
        this.first = first;
        this.last = last;
        this.middle = middle;
    }

    public void setFullName(){
        this.fullName = this.first + " " + this.middle + " " + this.last;
    }

    public String getFullName(){
        return this.fullName;
    }

    public void setFirst(String first){
        this.first = first;
    }

    public String getFirst(){
        return this.first;
    }

    public void setMiddle(String middle){
        this.middle = middle;
    }

    public String getMiddle(){
        return this.middle;
    }

    public void setLast(String last){
        this.last = last;
    }

    public String getLast(){
        return this.last;
    }
}
