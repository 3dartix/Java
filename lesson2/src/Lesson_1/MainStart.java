package Lesson_1;

public class MainStart {
    public static void main(String[] args) {
        Box box = new Box("box1", 10);
        Tools tools = new Tools("hummer");
        box.startTest(tools);
    }
}

class Box {
    String name;
    int weight;

    public Box(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    void startTest(Tools tools) {
//        Box box = new Box()
        tools.infoToolsAndBox(this, 5);
    }
}

class Tools {
    public Tools(String tools) {
        this.tools = tools;
    }

    String tools;

    void infoToolsAndBox(Box box, int a) {
        System.out.println(tools + " "
                + box.name + " "
                + box.weight);
    }
}