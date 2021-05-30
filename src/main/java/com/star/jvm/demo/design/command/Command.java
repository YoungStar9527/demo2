package com.star.jvm.demo.design.command;

/**
 * 命令接口
 */
public interface Command {

    /**
     * 控制器只需要调用execute，不需要关心具体实现细节，和是谁实现的
     */
    void execute();

    /**
     * 撤回接口，通常是与执行相反的行为
     */
    void undo();
}
