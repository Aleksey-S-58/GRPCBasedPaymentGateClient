package application;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import client.WalletClient;
import client.round.Round;
import client.round.RoundsBacket;

public class Application {

	private static long usersAmount = 100;
	private static int threadPerUser = 10;
	private static int roundsPerThread = 10;
	
	private static class Task implements Runnable {
		
		private long userId;
		private WalletClient client;
		private RoundsBacket backet;
		private int roundsAmount;
		
		public Task(long userId, WalletClient client, RoundsBacket backet, int roundsAmount) {
			this.userId = userId;
			this.client = client;
			this.backet = backet;
			this.roundsAmount = roundsAmount;
		}

		@Override
		public void run() {
			for(int k = 0; k < roundsAmount; k++) {
				if(Thread.currentThread().isInterrupted()) {break;}
				Round round = backet.getRandomRound();
				round.execute(userId, client);
			}
			
		}
	};
	public static void main(String[] args) {
		setInitialParams(args);
		RoundsBacket backet = new RoundsBacket();
		WalletClient client = new WalletClient();
		client.init();
		List<Task> tasks = LongStream.range(0, usersAmount).boxed().flatMap(userId -> {
			return IntStream.range(0, threadPerUser).boxed().map(i -> {
				return new Task(userId, client, backet, roundsPerThread);
			});
		}).collect(Collectors.toList());
		int nThreads = (int) (usersAmount * threadPerUser);
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		tasks.stream().forEach(task -> executor.submit(task));
		executor.shutdown();

	}
	private static void setInitialParams(String[] args) {
		if(args != null && args.length == 3) {
			try {
				usersAmount = Long.parseLong(args[0]);
				threadPerUser = Integer.parseInt(args[1]);
				roundsPerThread = Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {
				setDefaultParams();
			}
		}
	}
	
	private static void setDefaultParams() {
		usersAmount = 100;
		threadPerUser = 10;
		roundsPerThread = 10;		
	}
}
