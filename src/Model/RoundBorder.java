package Model;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

public class RoundBorder extends AbstractBorder {
    private final Color color;
    private final int thickness;

    public RoundBorder(Color color, int thickness) {
        this.color = color;
        this.thickness = thickness;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.drawRoundRect(x, y, width, height , 10, 10); // Changez les valeurs des coins pour ajuster l'arrondi
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = thickness;
        return insets;
    }
}
