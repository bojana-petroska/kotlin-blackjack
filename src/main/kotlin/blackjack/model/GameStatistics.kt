package blackjack.model

object GameStatistics {
    fun createStatistics(
        players: List<Player>,
        dealer: Dealer,
    ): MutableList<String> {
        val results: MutableList<String> = mutableListOf()
        val counter: Triple
//        var winCounterDealer = 0
//        var loseCounterDealer = 0
//        var tieCounterDealer = 0

        for (player in players) {
            var result = comparison(player, dealer)
            results.add("${player.name}: $result")
        }

        // Output call
        var dealerWins = if (winCounterDealer > 0) "$winCounterDealer Win" else ""
        var dealerLose = if (loseCounterDealer > 0) "$loseCounterDealer Lose" else ""
        var dealerTie = if (tieCounterDealer > 0) "$tieCounterDealer Tie" else ""

        results.add(
            0,
            "${dealer.name}: $dealerWins $dealerLose $dealerTie",
        )
        return results
    }
}


fun comparison(player: Player, dealer: Dealer): String {
    var winCounterDealer = 0
    var loseCounterDealer = 0
    var tieCounterDealer = 0
    var result = ""
    when {
        player.getScore() > 21 -> {
            result = "Lose"
            winCounterDealer++
        }

        dealer.getScore() > 21 -> {
            result = "Win"
            loseCounterDealer++
        }

        player.getScore() == 21 && dealer.getScore() != 21 -> {
            result = "Win"
            loseCounterDealer++
        }

        dealer.getScore() > player.getScore() -> {
            result = "Lose"
            winCounterDealer++
        }

        player.getScore() == dealer.getScore() -> {
            result = "Tie"
            tieCounterDealer++
        }

        else -> {
            result = "Win"
            loseCounterDealer++
        }
    }
    return result
}