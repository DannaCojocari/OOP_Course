package lab_1.task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public void getDisplay() {
        System.out.println("Model: " + model + " Width: " + width + " Height: " + height + " Ppi: " + ppi);
    }

    public void compareSize(Display m) {
        int area1 = this.width * this.height;
        int area2 = m.width * m.height;

        if (area1 > area2) {
            System.out.println(this.model + " is bigger than " + m.model + " with " + (area1 - area2) + "cm^2");
        } else if (area1 < area2) {
            System.out.println(this.model + " is smaller than " + m.model + " with " + (area2 - area1) + "cm^2");
        } else {
            System.out.println(this.model + " is equal to " + m.model + " by size");
        }
    }

    public void compareSharpness(Display m) {
        if (this.ppi > m.ppi) {
            System.out.println(this.model + " has a sharper monitor than " + m.model + " with " + (this.ppi - m.ppi) + " PPI");
        } else if (this.ppi < m.ppi) {
            System.out.println(this.model + " has a  less sharper monitor than " + m.model + " with " + (m.ppi - this.ppi) + " PPI");
        } else {
            System.out.println(this.model + " and " + m.model + " have the same sharpness");
        }
    }

    public void compareWithMonitor(Display m) {
        compareSize(m);
        compareSharpness(m);
    }

    public static void main(String[] args) {
        Display m1 = new Display(50, 30, 90, "Monitor1");
        Display m2 = new Display(45, 27, 230, "Monitor2");
        Display m3 = new Display(60, 35, 120, "Monitor3");
        m1.compareSize(m2);
        m2.compareSharpness(m3);
        m1.compareWithMonitor(m3);
    }
}


