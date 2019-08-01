package client.round;

import client.Client;

/**
 * 
 * This interface represents one of listed user's actions 
 * (deposit, view balance and withdraw). 
 * 
 * @author Aleksey-S-58
 *
 */
@FunctionalInterface
public interface Command {

	public void execute(long userId, Client client);
	
}
