package peval3acda2223;

/**
 * @author José Ramón Gallego Vélez
 * @project acda01
 * @date 16/11/2022
 * @info Class where we have general settings for our program
 */
public class Config {
    /**
     * String MYPATH has the path where we´ll save the neodatis file
     */
    private String MYPATH = "D:\\2 DAM\\ACDA\\db\\neodatis\\biblioteca.neo";
    /**
     * String DBNAME has the name of our PHPMyAdmin database
     */
    private String DBNAME = "biblioteca";
    /**
     * String DBUSER has the name of the user of our PHPMyAdmin database
     */
    private String DBUSER = "root";

    /**
     * Generate GETTERS y Setters
     */
    public String getMYPATH() {
        return MYPATH;
    }

    public String getDBNAME() {
        return DBNAME;
    }

    public String getDBUSER() {
        return DBUSER;
    }
}
