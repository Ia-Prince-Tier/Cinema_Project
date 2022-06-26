/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author laurentdavenne
 */
public class History {
    private  String title;
    private  String screensession;
    private  String ticketnumber;
    //private final SimpleStringProperty IDmember;
    
    // History(String title, String screensession, String ticketnumber/*,wString IDmember*/) {
        //this.title = new SimpleStringProperty(title);
        //this.screensession = new SimpleStringProperty(screensession);
        //this.ticketnumber = new SimpleStringProperty(ticketnumber);
        //this.IDmember = new SimpleStringProperty(IDmember);
    //}
     
/*
    public String getIDmember() {
        return this.IDmember.get();
    }
*/
    //public String gettitle() {
     //   return this.title.get();
    //}
 
    //public void settitle(String title) {
     //   this.title.set(title);
    //}
 /*
    public String getscreensession() {
        return this.screensession.get();
    }
 
    public void setscreensession(String screensession) {
        this.screensession.set(screensession);
    }
 
    public String getticketnumber() {
        return this.ticketnumber.get();
    }
 */
    //public void setticketnumber(String ticketnumber) {
    //    this.ticketnumber.set(ticketnumber);
    //}

    public History(String title, String screensession, String ticketnumber) {
        this.title = title;
        this.screensession = screensession;
        this.ticketnumber = ticketnumber;
    }

    public String getTitle() {
        return title;
    }

    public String getScreensession() {
        return screensession;
    }

    public String getTicketnumber() {
        return ticketnumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setScreensession(String screensession) {
        this.screensession = screensession;
    }

    public void setTicketnumber(String ticketnumber) {
        this.ticketnumber = ticketnumber;
    }
    
   
}
