package practice;

import org.openqa.selenium.internal.Debug;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

@Test
public class TestngPactice
{
      @Test  (enabled=false)
	public void Sample()
	{
		
		System.out.println("hi");
	}
      
      @Test (priority = 3)
      public void  Sample2()
      {
    	  System.out.println("Bye");
      }
      
      @Test  (priority = 1)
      public void Sample3()
      {
    	  System.out.println("Hello");
      }
}
