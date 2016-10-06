package ch.heig_vd.iict.symexercices.helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import ch.heig_vd.iict.symexercices.R;

/**
 * Created by Fabien on 28.09.2016.
 */

public final class Tools {

    private static Random RAND = new Random();

    private static String[] FIRSTNAMES = {"Yun", "Katelyn", "Ralph", "Son", "See", "Belkis", "Jeffrey", "Corina", "Mari", "Trent", "Libbie", "Larue", "Corinne", "Devona", "Cherelle", "Pam", "Katheleen", "Larissa", "Micah", "Jill", "Tamara", "Malik", "Melonie", "Francesco", "Shayla", "Shirley", "Alisha", "Kanesha", "Debi", "Lucretia"};
    private static String[] NAMES = {"Abraham", "Allan", "Alsop", "Anderson", "Arnold", "Avery", "Bailey", "Baker", "Ball", "Bell", "Berry", "Black", "Blake", "Bond", "Bower", "Brown", "Buckland", "Burgess", "Butler", "Cameron", "Campbell", "Carr", "Chapman", "Churchill", "Clark", "Clarkson", "Coleman", "Cornish", "Davidson", "Davies", "Dickens", "Dowd", "Duncan", "Dyer", "Edmunds", "Ellison", "Ferguson", "Fisher", "Forsyth", "Fraser", "Gibson", "Gill", "Glover", "Graham", "Grant", "Gray", "Greene", "Hamilton", "Hardacre", "Harris", "Hart", "Hemmings", "Henderson", "Hill", "Hodges", "Howard", "Hudson", "Hughes", "Hunter", "Ince", "Jackson", "James", "Johnston", "Jones", "Kelly", "Kerr", "King", "Knox", "Lambert", "Langdon", "Lawrence", "Lee", "Lewis", "Lyman", "MacDonald", "Mackay", "Mackenzie", "MacLeod", "Manning", "Marshall", "Martin", "Mathis", "May", "McDonald", "McLean", "McGrath", "Metcalfe", "Miller", "Mills", "Mitchell", "Morgan", "Morrison", "Murray", "Nash", "Newman", "Nolan", "North", "Ogden", "Oliver", "Paige", "Parr", "Parsons", "Paterson", "Payne", "Peake", "Peters", "Piper", "Poole", "Powell", "Pullman", "Quinn", "Rampling", "Randall", "Rees", "Reid", "Roberts", "Robertson", "Ross", "Russell", "Rutherford", "Sanderson", "Scott", "Sharp", "Short", "Simpson", "Skinner", "Slater", "Smith", "Springer", "Stewart", "Sutherland", "Taylor", "Terry", "Thomson", "Tucker", "Turner", "Underwood", "Vance", "Vaughan", "Walker", "Wallace", "Walsh", "Watson", "Welch", "White", "Wilkins", "Wilson", "Wright", "Young"};
    //faces images
    //src: AT&T Laboratories Cambridge - http://www.cl.cam.ac.uk/research/dtg/attarchive/facedatabase.html
    private static int[]    PICTURES = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p8, R.drawable.p9, R.drawable.p10};

    public static String getRandomName() {
        return NAMES[RAND.nextInt(NAMES.length)];
    }

    public static String getRandomFirstname() {
        return FIRSTNAMES[RAND.nextInt(FIRSTNAMES.length)];
    }

    public static int getRandomImageRes() {
        return PICTURES[RAND.nextInt(PICTURES.length)];
    }

    public static Date getRandomBirthday() {
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(Calendar.YEAR, 1940 + RAND.nextInt(60));
        cal.set(Calendar.MONTH, RAND.nextInt(12));
        cal.set(Calendar.DAY_OF_MONTH, 1+RAND.nextInt(31));

        return cal.getTime();
    }

}
