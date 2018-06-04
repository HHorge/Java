package objectstructures;

public class Tweet {
	String message;
	TwitterAccount account;
	private int retweets = 0;
	
	public Tweet(TwitterAccount account, String message) {
		
		this.message = message;
		this.account = account;

		
	}
	public Tweet(TwitterAccount account, Tweet tweet) {
		if(tweet.getText().equals(this.message) && account != this.account) {
			
		}
		
	}
	
	public String getText() {
		return this.message;
	}

	public TwitterAccount getOwner() {
		return this.account;
	}

	public Tweet getOriginalTweet() {
		
	}

	public int getRetweetCount() {
		
	}
}
