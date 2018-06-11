package com.wb.springboot2skeleton.blockChain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;

public class Test {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;

    @org.junit.Test
    public void testMiningBlock() throws JsonProcessingException {
        long beginTime1 = new Date().getTime();
        blockchain.add(new Block("Hi i am the first block", "0"));
        System.out.println("Trying to  mine block 1...");
        blockchain.get(0).mineBlock(difficulty);
        long endTime1 = new Date ().getTime();
        System.out.println("Mining block 1 cost " + (endTime1 - beginTime1));


        long beginTime2 = new Date().getTime();
        blockchain.add(new Block("Hi i am the second block", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("Trying to  mine block 2...");
        blockchain.get(1).mineBlock(difficulty);
        long endTime2 = new Date().getTime();
        System.out.println("Mining block 2 cost " + (endTime2 - beginTime2));

        long beginTime3 = new Date().getTime();
        blockchain.add(new Block("Hi i am the third block", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("Trying to  mine block 3...");
        blockchain.get(2).mineBlock(difficulty);
        long endTime3 = new Date().getTime();
        System.out.println("Mining block 3 cost " + (endTime3 - beginTime3));

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new ObjectMapper().writeValueAsString(blockchain);
        System.out.println(blockchainJson);
    }

    public static void main(String[] args) throws JsonProcessingException {
        blockchain.add(new Block("Hi i am the first blockChain", "0"));
        blockchain.add(new Block("Hi i am the second blockChain", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Hi i am the third blockChain", blockchain.get(blockchain.size() - 1).hash));

        String blockchainJson = new ObjectMapper().writeValueAsString(blockchain);
        System.out.println(blockchainJson);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal!");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.preHash)) {
                System.out.println("Previous Hashes not equal!");
                return false;
            }
        }
        return true;
    }
}
