
import java.math.BigDecimal
import javax.inject.Inject
import java.util.HashMap
import javax.inject.Singleton

@Singleton
class Database @Inject constructor() {
    private val accounts = HashMap<String, Account>()

    fun getAccount(username: String): Account {
        return accounts.getOrPut(username, { Account(username) })
    }

    class Account(internal val username: String) {
        internal var balance = BigDecimal.ZERO

        fun username(): String {
            return username
        }

        fun balance(): BigDecimal {
            return balance
        }

        fun deposit(amount: BigDecimal) {
            balance += amount
        }
    }
}