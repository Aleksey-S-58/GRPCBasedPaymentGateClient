package client.round;

import java.util.LinkedList;

public class RoundBuilder {

	private LinkedList<Command> commands;
	
	public RoundBuilder() {
		commands = new LinkedList<>();
	}
	
	public RoundBuilder deposit(Currency currency, int amount) {
		commands.add(new DepositCommand(currency, amount));
		return this;
	}
	
	public RoundBuilder withdraw(Currency currency, int amount) {
		commands.add(new WithdrawCommand(currency, amount));
		return this;
	}
	
	public RoundBuilder balance() {
		commands.add(new BalanceCommand());
		return this;
	}
	
	public Round build() {
		AbstractRound result = new AbstractRound() {
			private AbstractRound init(LinkedList<Command> commands) {
				super.commands = commands;
				return this;
			}
		}.init(commands);
		return result;
	}
	
}
