import java.util.*;

public class Cinema {
   private List <Movie> availableMovies = new ArrayList<>();

   public void addMovie(Movie movie){
    availableMovies.add(movie);
    System.out.println("Movie added to cinema: "+ movie.getTitle());
   } 
   public void rentMovie(Viewer viewer, Movie movie){
    viewer.rentMovies.add(movie);
    availableMovies.remove(movie);
    System.out.println(viewer.getName()+ "rented: " + movie.getTitle());
   }

   public void returnMovie(Viewer viewer, Movie movie){
    availableMovies.add(movie);
    viewer.rentMovies.remove(movie);
    System.out.println(viewer.getName()+ " returned: "+movie.getTitle());
   }

   public void displayAvailableMovies(){

   }

}
