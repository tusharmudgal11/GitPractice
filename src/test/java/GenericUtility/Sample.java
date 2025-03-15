package GenericUtility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample 
{
	@Test (retryAnalyzer = RetryAnalyserImplementation.class)
	public void Sample() 
	{
		Assert.fail();
		System.out.println("Hi");
	}

}
