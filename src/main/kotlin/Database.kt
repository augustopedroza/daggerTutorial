
import java.math.BigDecimal
import javax.inject.Inject
import java.util.HashMap

class Database @Inject constructor() {
    private val accounts = HashMap<String, Account>()

    fun getAccount(username: String): Account {
        return accounts.getOrPut(username, { Account(username) })
    }

    class Account(private val username: String) {
        private val balance = BigDecimal.ZERO

        fun username(): String {
            return username
        }

        fun balance(): BigDecimal {
            return balance
        }
    }
}