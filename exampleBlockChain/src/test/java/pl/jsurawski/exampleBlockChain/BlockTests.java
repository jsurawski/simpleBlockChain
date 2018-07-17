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

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockTests {
	@Test
	public void checkBlock()
	{
		Block block = new Block("", "first");
		String hashExpected=Hashing.sha512()
				.hashString("first", StandardCharsets.UTF_8)
				.toString();
		assertEquals(hashExpected, block.getHash());
	}
}
