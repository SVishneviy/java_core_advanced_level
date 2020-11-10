package homework_1;

public class Cat implements Jumping, Running {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void jump() {
        System.out.printf("%s прыгает.\n", name);
    }

    @Override
    public void run() {
        System.out.printf("%s бегает.\n", name);
    }

}
