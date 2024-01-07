package rate.limiting;

// https://www.youtube.com/watch?v=PJ-c0QI-QCk
// https://www.youtube.com/watch?v=FU4WlwfS3G0

public class TokenBucket {

    private final long maxBucketSize;
    private final long refillRate;

    private double currentBucketSize;
    private long lastRefillTimeStamp;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        currentBucketSize = maxBucketSize; // no of tokens is initially set to maximum capacity
        lastRefillTimeStamp = System.nanoTime();
    }

    public synchronized boolean allowRequests(int tokens) { // synchronized as several threads may be calling the method concurrently
        refill();

        if(currentBucketSize > tokens) { // if bucket has enough tokens, call is allowed
            currentBucketSize -= tokens;
            return true;
        }
        return false; // call dropped
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTimeStamp) * refillRate / 1e9; // These many tokens accumulated since last refill
        currentBucketSize = Math.min(tokensToAdd + currentBucketSize, maxBucketSize); // no of tokens should never exceed max bucket size
        lastRefillTimeStamp = now;
    }
}
