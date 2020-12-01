package bsu.rfe.java.group7.lab3.Vertinskaya.var2A;
import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    protected GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.coefficients = coefficients;
        this.from = from;
        this.to = to;
        this.step = step;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    @Override
    public int getRowCount() {
        return new Double(Math.ceil((to - from)/step)).intValue() + 1;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        double result = 0.0;
        if (col == 0) {
            return x;
        } else if (col == 1) {
            for (int i = 0; i < coefficients.length; i++) {
                result += Math.pow(x, coefficients.length - 1 - i) * coefficients[i];
            }
            return result;
        } else if (col == 2) {
            for (int i = 0; i < coefficients.length; i++)
                result += Math.pow(x, coefficients.length - 1 - i) * coefficients[i];
            return ((int) result != 0 && Math.sqrt((int)result) % 1 == 0);
        }
        return null;
    }
    @Override
    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 2:
                return Boolean.class;
            default:
                return Double.class;
        }
    }
    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение Х";
            case 1:
                return "Значение многочлена";
            default:
                return "Целая часть является квадратом?";
        }

    }
}
