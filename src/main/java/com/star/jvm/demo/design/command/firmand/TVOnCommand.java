package com.star.jvm.demo.design.command.firmand;

import com.star.jvm.demo.design.command.Command;
import com.star.jvm.demo.design.command.firm.TV;

public class TVOnCommand implements Command {
	TV tv;

	public TVOnCommand(TV tv) {
		this.tv= tv;
	}

	public void execute() {
		tv.on();
		tv.setInputChannel();
	}

	public void undo() {
		tv.off();
	}
}
