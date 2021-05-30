package com.star.jvm.demo.design.command.firmand;

import com.star.jvm.demo.design.command.Command;
import com.star.jvm.demo.design.command.firm.Light;

public class LivingroomLightOffCommand implements Command {
	Light light;

	public LivingroomLightOffCommand(Light light) {
		this.light = light;
	}
	public void execute() {
		light.off();
	}
	public void undo() {
		light.on();
	}
}
