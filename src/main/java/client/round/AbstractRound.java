package client.round;

import java.util.LinkedList;

import client.Client;

public abstract class AbstractRound implements Round {

	/**
	 * commands should be obtained only via iterator.
	 */
	protected LinkedList<Command> commands;
	
	@Override
	public void execute(long userId, Client client) {
		commands.stream().forEach(c -> c.execute(userId, client));
	}
	
}
