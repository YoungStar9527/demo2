package com.star.jvm.demo.design.command;

import com.star.jvm.demo.design.command.firm.Light;
import com.star.jvm.demo.design.command.firmand.LightOffCommand;
import com.star.jvm.demo.design.command.firmand.LightOnCommand;

/**
 * 测试命令模式
 */
public class CommandDriver {

    /**
     * 简单样例
     */
    public static void simpleCommand(){
        Command lcOn = new LightOnCommand(new Light("room"));
        Command lcOff = new LightOffCommand(new Light("room"));
        lcOn.execute();
        lcOff.execute();
    }

    public static void main(String[] args) {

    }
}
