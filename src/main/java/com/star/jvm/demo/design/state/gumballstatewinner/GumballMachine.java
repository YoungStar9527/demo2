package com.star.jvm.demo.design.state.gumballstatewinner;

/**
 * 糖果机操作类
 */
public class GumballMachine {
 	//售空状态
	State soldOutState;
	//没投入钱
	State noQuarterState;
	//已投入钱
	State hasQuarterState;
	//售出
	State soldState;
	//赢家
	State winnerState;

	//当前状态
	State state = soldOutState;
	//糖果数量
	int count = 0;

	/**
	 * 注入数量及状态
	 * @param numberGumballs
	 */
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noQuarterState;
		} 
	}

	/**
	 * 投钱
	 */
	public void insertQuarter() {
		state.insertQuarter();
	}

	/**
	 * 退钱
	 */
	public void ejectQuarter() {
		state.ejectQuarter();
	}

	/**
	 * 转动曲柄
	 */
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	/**
	 * 设置状态
	 * @param state
	 */
	void setState(State state) {
		this.state = state;
	}

	/**
	 * 糖果数-1
	 */
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count > 0) {
			count = count - 1;
		}
	}

	int getCount() {
		return count;
	}

	/**
	 * 注满糖果
	 * @param count
	 */
	void refill(int count) {
		this.count += count;
		System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
		state.refill();
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
