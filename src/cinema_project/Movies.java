/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

/**
 *
 * @author tad-t
 */
public class Movies {
    private int ID ;
    private String Title;
    private int Duration;
    private String Genre;
    
    public Movies(){
    }
    
    public void setmovieID (int mID){
        ID = mID;
    }
    
    public void setmovieTitle (String mTitle){
        Title = mTitle;
    }
    
    public void setmovieDuration (int mDuration){
        Duration = mDuration;
    }
    
    public void setmovieGenre (String mGenre){
        Genre = mGenre;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public int getDuration() {
        return Duration;
    }

    public String getGenre() {
        return Genre;
    }
    
    
}
