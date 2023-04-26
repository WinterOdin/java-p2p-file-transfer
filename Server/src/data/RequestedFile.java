package data;

/**
 *
 * @author Komputer
 */

public class RequestedFile {

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public RequestedFile(int fileID, long length) {
        this.fileID = fileID;
        this.length = length;
    }

    public RequestedFile() {
    }

    private int fileID;
    private long length;
}
