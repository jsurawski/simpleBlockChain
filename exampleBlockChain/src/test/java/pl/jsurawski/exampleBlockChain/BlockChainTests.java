package pl.jsurawski.exampleBlockChain;

import static org.junit.Assert.assertEquals;

import java.nio.charset.StandardCharsets;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.hash.Hashing;

import pl.jsurawski.exampleBlockChain.blockChainImp.Block;
import pl.jsurawski.exampleBlockChain.blockChainImp.BlockChain;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockChainTests {
	@Test
	public void checkBlockChainAdd()
	{
		Block block= new Block("", "abc");
		BlockChain blockChain= new BlockChain();
		String hashExpected=Hashing.sha512()
				.hashString("first", StandardCharsets.UTF_8)
				.toString();
		blockChain.addToChain(block);
		assertEquals(hashExpected, blockChain.getLast());
	}
}
