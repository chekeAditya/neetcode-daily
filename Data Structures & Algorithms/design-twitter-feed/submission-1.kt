class Twitter {

    private val userMap = mutableMapOf<Int, User>()
    private var timeCounter = 0

    fun postTweet(userId: Int, tweetId: Int) {
        timeCounter++ 
        if (userMap.contains(userId).not()) { 
            userMap[userId] = User(userId)
        }

        val user = userMap[userId]
        val newTweet = Tweet(time = timeCounter, tweetId = tweetId) 
        user?.addTweet(newTweet)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        if (userMap.contains(userId).not()) return mutableListOf()
        
        val priorityQueue = PriorityQueue<Tweet>()
        val user = userMap[userId]!!

        // Add tweets from people this user is following
        for (followeeId in user.following) {
            var cnt = 0
            val followee = userMap[followeeId]
            if (followee != null) {
                for (tweet in followee.tweets) {
                    priorityQueue.offer(tweet)
                    cnt++
                    if (cnt > 10) break 
                }
            }
        }

        // Add user's own tweets
        var cnt = 0
        for (tweet in user.tweets) {
            priorityQueue.offer(tweet)
            cnt++
            if (cnt > 10) break 
        }

        val result = mutableListOf<Int>()
        var index = 0
        while (priorityQueue.isNotEmpty() && index++ < 10) {
            result.add(priorityQueue.poll().tweetId) 
        }

        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        // Prevent user from following themselves
        if (followerId == followeeId) return

        if (userMap.contains(followerId).not()) {
            userMap[followerId] = User(followerId)
        }
        if (userMap.contains(followeeId).not()) {
            userMap[followeeId] = User(followeeId)
        }

        val user = userMap[followerId]
        user?.addFollowing(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        // Prevent user from unfollowing themselves
        if (followerId == followeeId) return
        if (userMap.contains(followerId).not() || userMap.contains(followeeId).not()) return

        val user = userMap[followerId]
        user?.removeFollowing(followeeId)
    }

    class Tweet(val time: Int, val tweetId: Int) : Comparable<Tweet> {
        override fun compareTo(other: Tweet): Int {
            return other.time - this.time
        }
    }

    class User(val userId: Int) {
        // Renamed to 'following' to accurately describe who the user follows
        val following = HashSet<Int>()
        
        // Changed to LinkedList for O(1) insertions at the head
        val tweets = LinkedList<Tweet>()

        fun addTweet(tweet: Tweet) {
            tweets.addFirst(tweet) 
        }

        fun addFollowing(followeeId: Int) {
            following.add(followeeId)
        }

        fun removeFollowing(followeeId: Int) {
            following.remove(followeeId)
        }
    }
}
