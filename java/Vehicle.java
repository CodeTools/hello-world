public class Vehicle
{


	public FuelTank fuelTankNeedFor(Engine engine)
	{
		return new FuelTank();
	}



	public AdvancedFuelTank fuelTankNeedFor(V1 engine)
	{
		return new AdvancedFuelTank();
	}


	public static void main(String [] args)
	{
		System.out.println("Vehicle");
		Engine e = new Engine();
		V1 v1 = new V1();

		System.out.println(new Vehicle().fuelTankNeedFor(e).capacity(e));
		System.out.println(new Vehicle().fuelTankNeedFor(v1).capacity(v1));


		Engine e2 = new Engine();
		System.out.println(new Vehicle().fuelTankNeedFor(e2).capacity(e2));
		e2 = new V1();
		System.out.println(new Vehicle().fuelTankNeedFor(e2).capacity(e2));		
	}
}