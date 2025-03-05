public class Movie {
    private String title;
    private String id;
    private Director director;

    Movie(String title, String id, Director director){
        this.title=title;
        this.id=id;
        this.director=director;
    }

    String getTitle(){
        return title;
    }

    pString getId(){
        return id;
    }

    public Director getDirector(){
        return director;
    }
}
