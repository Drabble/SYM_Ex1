package ch.heig_vd.iict.symexercices.models;

import java.util.Date;

import ch.heig_vd.iict.symexercices.helpers.Tools;

/**
 * Created by Fabien on 28.09.2016.
 */

public class Directory {

    private String  name;
    private String  firstname;
    private Date    birthdate;
    private int     image;

    /**
     * Construct a directory person with random data
     */
    public Directory() {
        this.name       = Tools.getRandomName();
        this.firstname  = Tools.getRandomFirstname();
        this.image      = Tools.getRandomImageRes();
        this.birthdate  = Tools.getRandomBirthday();
    }

    public String getName() { return name; }
    public String getFirstname() { return firstname; }
    public Date getBirthdate() { return birthdate; }
    public int getImage() { return image; }
}