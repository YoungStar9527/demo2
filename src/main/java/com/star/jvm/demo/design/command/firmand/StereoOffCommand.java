package com.star.jvm.demo.design.command.firmand;

import com.star.jvm.demo.design.command.Command;
import com.star.jvm.demo.design.command.firm.Stereo;

public class StereoOffCommand implements Command {
	Stereo stereo;
 
	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}
 
	public void execute() {
		stereo.off();
	}

	public void undo() {
		stereo.on();
	}
}
