package src.Entities;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SearchPropertyTableModel extends AbstractTableModel {

  private static final int NAME_COL = 0;
  private static final int OWNER_COL = 1;
  private static final int TYPE_COL = 2;
  private static final int BEDROOM_COL = 3;
  private static final int BATHROOM_COL = 4;
  private static final int FURNISHED_COL = 5;
  private static final int QUADRANT_COL = 6;

  private String[] columnNames = {
    "Name",
    "Owner",
    "Type",
    "Bedrooms",
    "Bathrooms",
    "Furnished",
    "Quadrant",
  };
  private List<Property> properties;

  public SearchPropertyTableModel(List<Property> theproperties) {
    properties = theproperties;
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public int getRowCount() {
    return properties.size();
  }

  @Override
  public String getColumnName(int col) {
    return columnNames[col];
  }

  @Override
  public Object getValueAt(int row, int col) {
    Property tempProperty = properties.get(row);

    switch (col) {
      case NAME_COL:
        return tempProperty.getName();
      case OWNER_COL:
        return tempProperty.getOwner();
      case TYPE_COL:
        return tempProperty.getType();
      case BEDROOM_COL:
        return tempProperty.getBedrooms();
      case BATHROOM_COL:
        return tempProperty.getBathrooms();
      case FURNISHED_COL:
        return tempProperty.isFurnished();
      case QUADRANT_COL:
        return tempProperty.getQuadrant();
      default:
        return tempProperty.getName();
    }
  }

  @Override
  public Class getColumnClass(int c) {
    return getValueAt(0, c).getClass();
  }
}
