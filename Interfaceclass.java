import java.awt.*;
public interface Interfaceclass {

    default void drawBackground(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // deep dark navy background
        g2d.setColor(new Color(8, 8, 20));
        g2d.fillRect(0, 0, width, height);

        // top bar
        g2d.setColor(new Color(200, 40, 40));
        g2d.fillRect(0, 0, width, 6);

        // bottom bar
        g2d.setColor(new Color(200, 40, 40));
        g2d.fillRect(0, height - 6, width, 6);

        // faded circles top right
        g2d.setColor(new Color(200, 40, 40, 18));
        g2d.fillOval(width - 520, -200, 900, 900);
        g2d.setColor(new Color(200, 40, 40, 28));
        g2d.fillOval(width - 370, -120, 620, 620);
        g2d.setColor(new Color(200, 40, 40, 38));
        g2d.fillOval(width - 240, -60, 380, 380);

        // diamond chain left side
        int diamondX = 70;
        int gap = 36;
        int count = height / gap;
        for (int i = 0; i < count; i++) {
            int cy = 50 + i * gap;
            double distFromCenter = Math.abs(cy - height / 2.0) / (height / 2.0);
            int size = (int) (13 - distFromCenter * 7);
            int alpha = (int) (200 - distFromCenter * 140);
            if (size < 4)
                size = 4;
            if (alpha < 40)
                alpha = 40;
            int[] xp = { diamondX, diamondX + size, diamondX, diamondX - size };
            int[] yp = { cy - size, cy, cy + size, cy };
            g2d.setColor(new Color(220, 60, 60, alpha / 3));
            g2d.fillPolygon(xp, yp, 4);
            g2d.setColor(new Color(220, 60, 60, alpha));
            g2d.setStroke(new BasicStroke(1.2f));
            g2d.drawPolygon(xp, yp, 4);
        }
        g2d.setColor(new Color(200, 40, 40, 35));
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(diamondX, 0, diamondX, height);

        // corner brackets
        g2d.setColor(new Color(220, 60, 60, 200));
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(20, height - 20, 20, height - 130);
        g2d.drawLine(20, height - 20, 130, height - 20);
        g2d.drawLine(width - 20, 20, width - 20, 130);
        g2d.drawLine(width - 20, 20, width - 130, 20);

        // scan lines
        for (int y = 0; y < height; y += 6) {
            g2d.setColor(new Color(255, 255, 255, 5));
            g2d.drawLine(0, y, width, y);
        }

        // scattered dots
        int[] dotX = { 220, 280, 250, 340, 195, 370 };
        int[] dotY = { 90, 65, 145, 110, 175, 160 };
        int[] dotSize = { 6, 4, 8, 5, 4, 6 };
        int[] dotA = { 160, 100, 180, 120, 90, 140 };
        for (int i = 0; i < dotX.length; i++) {
            g2d.setColor(new Color(220, 60, 60, dotA[i]));
            g2d.fillOval(dotX[i], dotY[i], dotSize[i], dotSize[i]);
        }

        // watermark
        g2d.setFont(new Font("Arial", Font.BOLD, 10));
        g2d.setColor(new Color(200, 60, 60, 35));
        String wm = "EMS v1.0";
        FontMetrics fmw = g2d.getFontMetrics();
        g2d.drawString(wm, width - fmw.stringWidth(wm) - 20, height - 16);

        // flow diagram right side
        int diagramCX = width - 320;
        int diagramCY = height / 2;

        String[] branches = { "Schedule", "Guest List", "Venue", "Budget", "Feedback", "Reports" };
        double[] angles = { -90, -40, 20, 90, 145, 210 };
        int branchLen = 160;

        // glow rings
        g2d.setColor(new Color(200, 40, 40, 30));
        g2d.fillOval(diagramCX - 60, diagramCY - 60, 120, 120);
        g2d.setColor(new Color(200, 40, 40, 60));
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.drawOval(diagramCX - 60, diagramCY - 60, 120, 120);
        g2d.setColor(new Color(200, 40, 40, 100));
        g2d.drawOval(diagramCX - 45, diagramCY - 45, 90, 90);

        // center text
        g2d.setColor(new Color(255, 90, 90));
        g2d.setFont(new Font("Arial", Font.BOLD, 15));
        FontMetrics fmC = g2d.getFontMetrics();
        String line1 = "Event";
        String line2 = "Management";
        String line3 = "System";
        g2d.drawString(line1, diagramCX - fmC.stringWidth(line1) / 2, diagramCY - 18);
        g2d.drawString(line2, diagramCX - fmC.stringWidth(line2) / 2, diagramCY);
        g2d.drawString(line3, diagramCX - fmC.stringWidth(line3) / 2, diagramCY + 18);

        // branches
        for (int i = 0; i < branches.length; i++) {
            double rad = Math.toRadians(angles[i]);
            int ex = (int) (diagramCX + branchLen * Math.cos(rad));
            int ey = (int) (diagramCY + branchLen * Math.sin(rad));
            int sx = (int) (diagramCX + 62 * Math.cos(rad));
            int sy = (int) (diagramCY + 62 * Math.sin(rad));

            g2d.setColor(new Color(200, 60, 60, 160));
            g2d.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND, 0, new float[] { 8, 5 }, 0));
            g2d.drawLine(sx, sy, ex, ey);

            g2d.setColor(new Color(200, 40, 40, 80));
            g2d.fillOval(ex - 5, ey - 5, 10, 10);
            g2d.setColor(new Color(255, 90, 90, 200));
            g2d.setStroke(new BasicStroke(1.5f));
            g2d.drawOval(ex - 5, ey - 5, 10, 10);

            g2d.setFont(new Font("Arial", Font.BOLD, 13));
            FontMetrics fmB = g2d.getFontMetrics();
            int lx = ex + (int) (20 * Math.cos(rad));
            int ly = ey + (int) (20 * Math.sin(rad)) + 5;
            if (lx + fmB.stringWidth(branches[i]) > width - 20)
                lx = width - fmB.stringWidth(branches[i]) - 20;
            if (lx < 110)
                lx = 110;

            g2d.setColor(new Color(255, 255, 255, 190));
            g2d.drawString(branches[i], lx, ly);

            g2d.setColor(new Color(200, 40, 40, 120));
            g2d.setStroke(new BasicStroke(1));
            g2d.drawLine(lx, ly + 3, lx + fmB.stringWidth(branches[i]), ly + 3);
        }
    }

}