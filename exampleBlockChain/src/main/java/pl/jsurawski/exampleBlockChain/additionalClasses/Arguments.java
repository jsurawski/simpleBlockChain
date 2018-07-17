package pl.jsurawski.exampleBlockChain.additionalClasses;

import java.util.Arrays;

import pl.jsurawski.exampleBlockChain.blockChainImp.Block;

public class Arguments {
	public static void checkArgumentsAreNotNull(Object[] arguments)
	{
		if(Arrays.asList(arguments).stream().anyMatch(Arguments::objectIsNull))
		throw new IllegalArgumentException();
	}
	private static boolean objectIsNull(Object obj) {
		return obj==null ? true : false;
	}
}
