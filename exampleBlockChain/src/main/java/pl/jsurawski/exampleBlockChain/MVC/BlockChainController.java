package pl.jsurawski.exampleBlockChain.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pl.jsurawski.exampleBlockChain.blockChainImp.Block;
import pl.jsurawski.exampleBlockChain.blockChainImp.BlockChain;




@Controller
public class BlockChainController{
	public static BlockChain blockChain= new BlockChain();
	@GetMapping("/getBlock")
	public ModelAndView getNextChain()
	{
		ModelAndView model= new ModelAndView("chain");
		System.out.println(blockChain.getLast());
		Block newBlock= new Block(blockChain.getLast(), "abc");
		blockChain.addToChain(newBlock);
		Gson praser= new Gson();
		model.addObject("block",praser.toJson(newBlock));
		return model;
	}
	@GetMapping("/")
	public ModelAndView getMain()
	{
		return new ModelAndView("chain");
	}
	@GetMapping("/getBlockChain")
	public ModelAndView getBlockChain()
	{
		ModelAndView model= new ModelAndView("chain");
		Gson praser= new Gson();
		model.addObject("block",praser.toJson(praser.toJson(blockChain)));
		return model;
	}
}
