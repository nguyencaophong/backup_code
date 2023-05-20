package com.application.wiselaptop.utils;

import com.application.wiselaptop.interfaces.OnRunBlock;

import java.util.concurrent.CountDownLatch;

public class Block  extends Thread {

    Block nBlock;
    OnRunBlock onRunBlock;

    public Block(){
        System.out.println("oke");
    }

    public Block(OnRunBlock onRunBlock){

    }

    public Block(Block nBlock, OnRunBlock onRunBlock){
        this.nBlock = nBlock;
        this.onRunBlock = onRunBlock;
    }

    @Override
    public void run(){
        if(this.nBlock != null &&  onRunBlock != null){
            onRunBlock.run(this.nBlock);
        }
        else{
            if(onRunBlock != null){
                onRunBlock.run();
            }
        }
    }
}
