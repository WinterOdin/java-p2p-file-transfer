package data;

/**
 *
 * @author Komputer
 */
/**
 *
 * refers to the current object and returns/sets it's values
 */

public class InitFile {

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public InitFile(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public InitFile() {
    }

    private String fileName;
    private long fileSize;
}
