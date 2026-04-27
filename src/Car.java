public class Car {
  //PetrolEngine engine = new PetrolEngine();

    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
      engine.start();
      System.out.println("Car is Moving....");
  }
}
