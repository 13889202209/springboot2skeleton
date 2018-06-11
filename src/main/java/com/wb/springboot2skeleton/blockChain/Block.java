package com.wb.springboot2skeleton.blockChain;

import java.util.Date;

public class Block {
    public String hash; //存放数字签名
    public String preHash; //前面块的签名
    private String data;
    private long timeStamp;
    private int nonce;

    public Block(String data, String preHash) {
        this.data = data;
        this.preHash = preHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();

    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(preHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
        return calculatedhash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!!" + hash);
    }


    public static void main(String[] args) {
        Block first = new Block("Hi i am the first blockChain", "0");
        System.out.println("Hash for blockChain 1 : " + first.hash);
        Block second = new Block("Hi i am the second blockChain", first.hash);
        System.out.println("Hash for blockChain 2 : " + second.hash);
        Block third = new Block("Hi i am the third blockChain", second.hash);
        System.out.println("Hash for blockChain 3 : " + third.hash);
    }
}
