package lab_1.task3;

import lab_1.task1.Display;
import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName = null;
    private List<Display> assignedDisplays = new ArrayList<>();

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }
    public void assist() {
        for (int i = 0; i < assignedDisplays.size()-1; i++) {
            Display d1 = assignedDisplays.get(i);
            Display d2 = assignedDisplays.get(i+1);
            d1.compareWithMonitor(d2);
        }
    }
    public Display buyDisplay(Display d) {
        assignedDisplays.remove(d);
        return d;
    }

    public static void main(String[] args) {
        Assistant assistant = new Assistant();
        assistant.assistantName = "Alex";

        Display[] displays = {
                new Display(70, 30, 120, "Monitor1"),
                new Display(55, 27, 210, "Monitor2"),
                new Display(70, 30, 120, "Monitor3"),
                new Display(70, 30, 120, "Monitor4"),
                new Display(70, 30, 120, "Monitor5")
        };

        // assigning each display
        for (Display display : displays) {
            assistant.assignDisplay(display);
        }

        //comparing every display
        assistant.assist();

        //removing display after being bought
        System.out.println();
        Display displayRemoved = assistant.buyDisplay(displays[0]);
        System.out.println("Object removed: ");
        displayRemoved.getDisplay();
    }
}
