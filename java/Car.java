public class Car extends Vehicle
{


	
	public FuelTank fuelTankNeedFor(Engine engine)
	{
		return new AdvancedFuelTank();
	}



	public AdvancedFuelTank fuelTankNeedFor(V1 engine)
	{
		return new AdvancedFuelTank();
	}


	public static void main(String [] args)
		{

		Vehicle vehicle = new Vehicle();
		
		System.out.println("Vehicle");
		Engine e = new Engine();
		V1 v1 = new V1();

		System.out.println(vehicle.fuelTankNeedFor(e).capacity(e));
		System.out.println(vehicle.fuelTankNeedFor(v1).capacity(v1));


		Engine e2 = new Engine();
		System.out.println(vehicle.fuelTankNeedFor(e2).capacity(e2));
		e2 = new V1();
		System.out.println(vehicle.fuelTankNeedFor(e2).capacity(e2));

		System.out.println("Car ");
		vehicle = new Car();
		System.out.println(vehicle.fuelTankNeedFor(e).capacity(e));
		System.out.println(vehicle.fuelTankNeedFor(v1).capacity(v1));


		e2 = new Engine();
		System.out.println(vehicle.fuelTankNeedFor(e2).capacity(e2));
		e2 = new V1();
		System.out.println(vehicle.fuelTankNeedFor(e2).capacity(e2));



		System.out.println("Car 2 ");
		System.out.println(new Car().fuelTankNeedFor(e).capacity(e));
		System.out.println(new Car().fuelTankNeedFor(v1).capacity(v1));


		e2 = new Engine();
		System.out.println(new Car().fuelTankNeedFor(e2).capacity(e2));
		e2 = new V1();
		System.out.println(new Car().fuelTankNeedFor(e2).capacity(e2));
	}
}