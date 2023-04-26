package data;
import com.corundumstudio.socketio.SocketIOClient;
import java.awt.Component;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JTable;
import swing.PanelStatus;

/**
 *
 * @author Komputer
 */

public class ClientDownload {

    public PanelStatus getStatus() {
        return status;
    }

    public SocketIOClient getClient() {
        return client;
    }

    public void setClient(SocketIOClient client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientDownload(SocketIOClient client, String name, JTable table) {
        this.client = client;
        this.name = name;
        this.status = new PanelStatus();
        this.table = table;
    }

    public ClientDownload() {
    }

    private SocketIOClient client;
    private String name;
    //  Key integer is fileID
    //  Use hash to store multi transfer
    private final HashMap<Integer, ServerSideFileUtils> list = new HashMap<>();
    private PanelStatus status;
    private JTable table;
    
    
    /**
    *
    * Adds new row in column when file is added to server
    */
    public void addWrite(ServerSideFileUtils data, int fileID) {
        list.put(fileID, data);
        status.addItem(fileID, data.getFile().getName(), data.getMaxFileSize());
        //  update table row height
        autoRowHeight(table, 3);
    }
    
    /**
    *
    * sets color and state of file when saving 
    */

    public void writeFile(byte[] data, int fileID) throws IOException {
        list.get(fileID).writeFile(data);
        status.updateStatus(fileID, (int) list.get(fileID).getPercentage());
        table.repaint();
    }

    public void closeWriter(int fileID) throws IOException {
        list.get(fileID).close();
    }

    public Object[] toRowTable(int row) {
        return new Object[]{this, row, name};
    }
    /**
    *
    * sets row height auto
    */

    private void autoRowHeight(JTable table, int... cols) {
        for (int row = 0; row < table.getRowCount(); row++) {
            int rowHeight = table.getRowHeight();
            for (int col : cols) {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, col), row, col);
                if (comp.getPreferredSize().height > rowHeight) {
                    rowHeight = comp.getPreferredSize().height;
                }
            }
            table.setRowHeight(row, rowHeight);
        }
    }

    public long getFileLength(int fileID) throws IOException {
        return list.get(fileID).getFileLength();
    }
    
    /**
    *
    * returns new instance of CurrentObjServer
    */
    public CurrentObjServer getDataFileServer(int fileID) throws IOException {
        ServerSideFileUtils data = list.get(fileID);
        String fileName = data.getFile().getName();
        return new CurrentObjServer(fileID, fileName.substring(fileName.indexOf("-", 0) + 1, fileName.length()), data.getMaxFileSize(), data.getFileLength(), data.getFile());
    }
}
