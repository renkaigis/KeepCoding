import java.awt.*;

public class Cat4 {
    private String name;
    private int age;
    private double weight;
    private Color color;

    public Cat4(String name, int age, double weight, Color color) { // 初始化猫咪的属性
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String toString() { // 重写 toString() 方法
        StringBuilder sb = new StringBuilder();
        sb.append("名字：" + name + "\n");
        sb.append("年龄：" + age + "\n");
        sb.append("体重：" + weight + "\n");
        sb.append("颜色：" + color + "\n");
        return sb.toString();
    }
}
