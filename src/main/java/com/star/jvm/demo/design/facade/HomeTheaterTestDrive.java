package com.star.jvm.demo.design.facade;

import com.star.jvm.demo.design.facade.other.*;

/**
 * 外观模式测试类
 */
public class HomeTheaterTestDrive {

	public static void main(String[] args) {
		Amplifier amp = new Amplifier("Amplifier");
		Tuner tuner = new Tuner("AM/FM Tuner", amp);
		StreamingPlayer player = new StreamingPlayer("Streaming Player", amp);
		CdPlayer cd = new CdPlayer("CD Player", amp);
		Projector projector = new Projector("Projector", player);
		TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
		Screen screen = new Screen("Theater Screen");
		PopcornPopper popper = new PopcornPopper("Popcorn Popper");
 		//构造注入子系统
		HomeTheaterFacade homeTheater = 
				new HomeTheaterFacade(amp, tuner, player, 
						projector, screen, lights, popper);

		//一个方法完成对应复杂操作
		homeTheater.watchMovie("Raiders of the Lost Ark");
		homeTheater.endMovie();
	}
}
