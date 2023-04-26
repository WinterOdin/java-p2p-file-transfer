package swing;

import data.SaveFileClient;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CellEditorFile extends DefaultCellEditor {

    public CellEditorFile() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        Object data = jtable.getValueAt(i, 0);
        if (data instanceof SaveFileClient) {
            SaveFileClient d = (SaveFileClient) data;
            return d.getItem();
        } else {
            return super.getTableCellEditorComponent(jtable, o, bln, i, i1);
        }
    }
}
