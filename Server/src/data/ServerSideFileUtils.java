package data;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;

/**
 *
 * @author Komputer
 */

public class ServerSideFileUtils {

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public RandomAccessFile getAccFile() {
        return accFile;
    }

    public void setAccFile(RandomAccessFile accFile) {
        this.accFile = accFile;
    }

    public ServerSideFileUtils(File file, long fileSize) throws IOException {
        //  rw is mode read and write
        // support both reading and writing to a file
        accFile = new RandomAccessFile(file, "rw");
        this.file = file;
        this.fileSize = fileSize;

    }

    private File file;
    private long fileSize;
    private RandomAccessFile accFile;
    
    /**
    *
    * writes file to data in synchronized way to prevent thread interference
    */
    public synchronized long writeFile(byte[] data) throws IOException {
        accFile.seek(accFile.length());
        accFile.write(data);
        return accFile.length();
    }

    public void close() throws IOException {
        accFile.close();
    }

    public String getMaxFileSize() {
        return convertFile(fileSize);
    }
    /**
    *
    * returns current file size (when saving)
    */
    public String getCurrentFileSize() throws IOException {
        return convertFile(accFile.length());
    }
    
    /**
    *
    * returns progres of file when saving 
    */
    public double getPercentage() throws IOException {
        double percentage;
        long filePointer = accFile.length();
        percentage = filePointer * 100 / fileSize;
        return percentage;
    }
    
    /**
    *
    * returns file lenght 
    */
    
    public long getFileLength() throws IOException {
        return accFile.length();
    }
    
    /**
    *
    * returns size after conversion to bytes
    */

    private String convertFile(double bytes) {
        String[] fileSizeUnits = {"bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        String sizeToReturn;
        DecimalFormat df = new DecimalFormat("0.#");
        int index;
        for (index = 0; index < fileSizeUnits.length; index++) {
            if (bytes < 1024) {
                break;
            }
            bytes = bytes / 1024;
        }
        sizeToReturn = df.format(bytes) + " " + fileSizeUnits[index];
        return sizeToReturn;
    }
}
