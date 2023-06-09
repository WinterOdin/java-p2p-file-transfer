package data;
import java.io.File;

/**
 *
 * @author Komputer
 */
/**
 *
 * refers to the current object and returns/sets it's values
 */

public class CurrentObjServer {

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public long getFileSizeLength() {
        return fileSizeLength;
    }

    public void setFileSizeLength(long fileSizeLength) {
        this.fileSizeLength = fileSizeLength;
    }

    public File getOutPutPath() {
        return outPutPath;
    }

    public void setOutPutPath(File outPutPath) {
        this.outPutPath = outPutPath;
    }

    public CurrentObjServer(int fileID, String fileName, String fileSize, long fileSizeLength, File outPutPath) {
        this.fileID = fileID;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileSizeLength = fileSizeLength;
        this.outPutPath = outPutPath;
    }

    public CurrentObjServer() {
    }

    private int fileID;
    private String fileName;
    private String fileSize;
    private long fileSizeLength;
    private File outPutPath;
}
