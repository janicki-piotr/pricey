package pl.redny.domain.consumer

interface SubscriptionManager {

    fun addSubscription(subscription: Subscription): Result<Unit>

    fun deleteSubscription(subscription: Subscription): Result<Unit>

    fun updateSubscription(subscription: Subscription): Result<Unit>

    fun getSubscriptions(): Result<List<Subscription>>

    fun getSubscriptions(subscriptionType: Class<*>): Result<List<Subscription>>

}