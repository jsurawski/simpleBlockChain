package pl.jsurawski.exampleBlockChain.blockChainImp;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.sound.midi.VoiceStatus;

import pl.jsurawski.exampleBlockChain.additionalClasses.Arguments;

public class BlockChain {
private List<Block> blockChain= new ArrayList<>();



public BlockChain(){
}

public BlockChain(List<Block> blockChain)
{
	Arguments.checkArgumentsAreNotNull(new Object[]{blockChain});
	this.blockChain= blockChain;
}
public void addToChain(Block block)
{
	Arguments.checkArgumentsAreNotNull(new Object[]{block});
	blockChain.add(block);
}
public String getLast()
{
	return blockChain.stream()
			.map(e->e.getHash())
			.reduce((first,second)->second)
			.orElse("");
}
}
