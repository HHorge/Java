package objectstructures;

public class TwitterAccount {
	String username;
	TwitterAccount account;
	int tweetCount;
	
	
	public TwitterAccount(String name){
		this.username = name;
		
	}
	public String getUserName() {
		return this.username;
	}

	public void follow(TwitterAccount account) {
		if(this.account == account) {
			return;
		}	
		else {
			this.account = account;
			account.follow(this);
		}
	}

	public void unfollow(TwitterAccount account) {
		
			this.account.account = null;
			this.account = null;
	}

	public boolean isFollowing(TwitterAccount account) {
		return this.account == account ? true : false;
		
	}

	public boolean isFollowedBy(TwitterAccount account) {
		return this.account == account ? true : false;
	}

	public void tweet(String message) {
		Tweet tweet = new Tweet(this.account, message);
	}

	public void retweet(Tweet tweet) {
		
	}

	public Tweet getTweet(int i) {
		
	}

	public int getTweetCount() {
		return this.tweetCount;
	}
	public int getRetweetCount() {
		
	}

}
