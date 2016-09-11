class MySuper {
}

class MySub extends MySuper {
}

class MyOtherSuper {
}

class MyOtherSub extends MyOtherSuper {
}


class MyStillOtherPoly {

	MySuper m1(MyOtherSuper myOtherSuper)	{
		System.out.println("m1 super object arg and return type ");
		return null;
	}

	MySub m1(MyOtherSub myOtherSub)	{
		System.out.println("m1 sub object arg and return type ");
		return null;
	}
}

class MyStillOtherRolyPoly extends MyStillOtherPoly {


	MySuper m1(MyOtherSuper myOtherSuper)	{
		System.out.println("mSub1 super object arg and return type ");
		return null;
	}

	MySub m1(MyOtherSub myOtherSub)	{
		System.out.println("mSub1 sub object arg and return type ");
		return null;
	}
}



public class Poly 
{
	public static void main(String [] args)
	{
		System.out.println("Poly");
		MyStillOtherPoly poly = new MyStillOtherPoly();
		MyOtherSuper mOS1 = new MyOtherSub();
		MyOtherSuper mOS2 = new MyOtherSuper();	
		MyOtherSub   mOs3 = ( MyOtherSub ) mOS1;

		new MyStillOtherPoly().m1(mOS1);
                new MyStillOtherPoly().m1(mOS2);
		new MyStillOtherPoly().m1(mOs3);

		new MyStillOtherRolyPoly().m1(mOS1);
		new MyStillOtherRolyPoly().m1(mOS2);
         	new MyStillOtherRolyPoly().m1(mOs3);

		
	}	
}