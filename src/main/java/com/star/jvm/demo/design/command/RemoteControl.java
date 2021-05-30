package com.star.jvm.demo.design.command;

import com.star.jvm.demo.design.command.firmand.NoCommand;

/**
 * 命令模式控制器(遥控器)
 */
public class RemoteControl {

    /**
     * 开按钮
     */
    private Command[] commandOns;

    /**
     * 关按钮
     */
    private Command[] commandOffs;

    /**
     * 撤销/回退
     */
    private Command undo;

    public RemoteControl() {
        //默认置顶按钮无命令
        commandOns = new Command[7];
        commandOffs = new Command[7];
        Command commandNo = new NoCommand();
        for(int i = 0;i<commandOns.length;i++){
            commandOns[i]=commandNo;
            commandOffs[i]=commandNo;
        }
    }

    public void setCommand(Command on,Command off,int index){
        if(index<0||index>=commandOns.length){
            return;
        }
        commandOns[index] = on;
        commandOffs[index] = off;
    }

    public void onButtonWasPushed(int index){
        undo = commandOns[index];
        commandOns[index].execute();
    }

    public void offButtonWasPushed(int index){
        undo = commandOns[index];
        commandOns[index].execute();
    }

    /**
     * 调用撤回命令
     */
    public void undoButtonWasPushed(){
        undo.undo();
    }
}
