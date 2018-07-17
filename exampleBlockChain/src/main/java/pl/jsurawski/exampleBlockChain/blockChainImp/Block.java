package pl.jsurawski.exampleBlockChain.blockChainImp;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.function.Predicate;

import javax.validation.constraints.Null;

import com.google.common.hash.Hashing;

import pl.jsurawski.exampleBlockChain.additionalClasses.Arguments;

public class Block {
	
	private String hash;
	private String previousHash="";
	private String data;
	private LocalDateTime transactionTime;
	
	
	
	public Block(String previousHash, String data) {
		Arguments.checkArgumentsAreNotNull(new Object[]{previousHash,data});
		this.previousHash = previousHash;
		this.data = data;
		this.transactionTime = LocalDateTime.now();
		generateHash();
	}
	private void generateHash() {
		hash= Hashing.sha512()
				.hashString(previousHash+data, StandardCharsets.UTF_8)
				.toString();
	}
	
	public String getHash()
	{
		return hash;
	}
	
}
