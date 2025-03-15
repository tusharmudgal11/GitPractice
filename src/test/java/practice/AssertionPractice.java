package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice 
{
	@Test
	public void sample()
	{
		System.out.println("Hi");
		{
			System.out.println("step1");
			Assert.assertEquals(1,1);
			System.out.println("step2");
			System.out.println("step3");
			System.out.println("step4");
		}
	}
	
		public void sample2()
		{
			
		SoftAssert softAssert = new SoftAssert();
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
		System.out.println("step5");
		softAssert.assertAll();
		
		
		
	       
	}

}
