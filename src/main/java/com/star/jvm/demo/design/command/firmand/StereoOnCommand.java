package com.star.jvm.demo.design.command.firmand;

import com.star.jvm.demo.design.command.Command;
import com.star.jvm.demo.design.command.firm.Stereo;

public class StereoOnCommand implements Command {
	Stereo stereo;

	public StereoOnCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.on();
	}

	public void undo() {
		stereo.off();
	}
}
