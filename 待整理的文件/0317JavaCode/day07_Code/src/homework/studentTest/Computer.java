package homework.studentTest;

public class Computer {

    private String cpu;
    private int memory;

    public Computer(){}

    public Computer(String cpu, int memory){
        this.cpu = cpu;
        this.memory = memory;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpu(){
        return cpu;
    }

    public void setMemory(int memory){
        this.memory = memory;
    }

    public int getMemory(){
        return memory;
    }

    public String say(){
        return "CPU: " + cpu + ", 内存: " + memory + "G";
    }
}
