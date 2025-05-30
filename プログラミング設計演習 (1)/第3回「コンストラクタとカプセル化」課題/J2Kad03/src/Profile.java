public class Profile {
    private String name;
    private double height;
    private double weight;

    public Profile(String name, double height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public double getHeight() {
        return (height < 120)? 170 : height;
    }

    public double getWeight() {
        return (weight > 100)? 50 : weight ;
    }
}
