package movie;

import java.io.Serializable;

public class MovieInfo implements Serializable{
      private String title, director, year, score;
      
      public MovieInfo() {}
      
      public MovieInfo(String title, String director, String score,String year) {
         this.title = title;
         this.director = director;
         this.score = score;
         this.year = year;
      }
      
      public void setTitle(String title) {
         this.title = title;
         }
      public void setDirector(String director) {
         this.director = director;
         }
      public void setScore(String score) {
         this.score = score;
         }
      public void setYear(String year) {
         this.year = year;
         }
      
      
      public String getTitle() {
         return title;}
      public String getDirector() {
         return director;}
      public String getScore() {
         return score;}
      public String getYear() {
         return year;}
      
      public String toString() {
         return "\n [제  목] : " + title + "\n [감  독] : " + director + "\n [평  점] : " + score +
               "\n [출시 연도] : " + year;
      }
      }
      